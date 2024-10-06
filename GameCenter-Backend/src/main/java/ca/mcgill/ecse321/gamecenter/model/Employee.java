/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.34.0.7242.6b8819789 modeling language!*/

package ca.mcgill.ecse321.gamecenter.model;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.*;

// line 24 "../../../../../../GameCenter.ump"

@Entity
@DiscriminatorValue("EMPLOYEE")
public class Employee extends Staff
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Employee() {
    super();
  }

  public Employee(int aId, String aEmail, String aUsername, String aPassword, boolean aIsActive)
  {
    super(aId, aEmail, aUsername, aPassword, aIsActive);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }

}