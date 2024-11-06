package ca.mcgill.ecse321.gamecenter.controller;

import ca.mcgill.ecse321.gamecenter.dto.Purchase.PurchaseRequestDTO;
import ca.mcgill.ecse321.gamecenter.dto.Purchase.PurchaseResponseDTO;
import ca.mcgill.ecse321.gamecenter.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PurchaseRestController {
    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/purchases/place/{clientId}")
    public List<PurchaseResponseDTO> createPurchases(@Validated @RequestBody List<PurchaseRequestDTO> req, @PathVariable int clientId) {
        return req.stream()
                .map(r -> new PurchaseResponseDTO(purchaseService.createPurchase(clientId, r.getGameId(), r.getCopies())))
                .collect(Collectors.toList());
    }

    @PutMapping("/purchases/{purchaseId}/refund/{reason}")
    public PurchaseResponseDTO refundPurchase(@PathVariable int purchaseId, @PathVariable String reason) {
        return new PurchaseResponseDTO(purchaseService.returnGame(purchaseId, reason));
    }

    @GetMapping("/purchases/{clientId}")
    public List<PurchaseResponseDTO> getPurchaseHistory(@PathVariable int clientId) {
        return purchaseService.getClientPurchaseHistory(clientId).stream()
                .map(p -> new PurchaseResponseDTO(p))
                .collect(Collectors.toList());
    }

    @GetMapping("/purchases/recent/{clientId}")
    public List<PurchaseResponseDTO> getPurchaseHistory90Days(@PathVariable int clientId) {
        return purchaseService.getClientPurchaseHistory90Days(clientId).stream()
                .map(p -> new PurchaseResponseDTO(p))
                .collect(Collectors.toList());
    }
}