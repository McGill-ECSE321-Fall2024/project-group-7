package ca.mcgill.ecse321.gamecenter.dto.Purchase;

import jakarta.validation.constraints.NotBlank;

public class PurchaseRequestDTO {
    @NotBlank(message = "Client is required")
    private int clientId;
    @NotBlank(message = "Game is required")
    private int gameId;
    @NotBlank(message = "Game copies is required")
    private int copies;

    public PurchaseRequestDTO(int clientId, int gameId, int copies) {
        this.clientId = clientId;
        this.gameId = gameId;
        this.copies = copies;
    }

    public int getClientId() { return this.clientId; }
    public int getGameId() { return this.gameId; }
    public int getCopies() { return this.copies; }
}