/* This is a stub for the House class */
import java.util.ArrayList;

import javax.management.RuntimeErrorException;

/**
 * The house class that extends the building class and adds the attributes residents and hasDiningRoom.
 */
public class House extends Building {
    private ArrayList<String> residents; 
    private boolean hasDiningRoom;

  /**
   * The constructor for the house class
   * @param name
   * @param address
   * @param nFloors
   * @param hasDiningRoom
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Getter for hasDiningRoom
   * @return if the house has a dining room (T/F)
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }
  
  /**
   * Getter for nResidents
   * @return the size of the residents ArrayList (Number of residents)
   */
  public int nResidents() {
    return this.residents.size();
  }

  /**
   * Adds new resident to ArrayList residents
   * @param name
   */
  public void moveIn(String name) {
    if (isResident(name) == false) {
      this.residents.add(name);
    }
    else {
      System.out.println(name + " already lives here!");
    }
  }

  /**
   * Removes resident from ArrayList resident
   * @param name
   * @return name
   */
  public String moveOut(String name) {
    if (isResident(name) == true) {
      this.residents.remove(name);
      return name;
    }
    else {
      System.out.println(name + " does not live here!");
      return name;
    }
  } 
  
  /**
   * Determines if someone is a resident of the house
   * @param person
   * @return boolean
   */
  public boolean isResident(String person) {
    if (this.residents.contains(person)) {
      return true;
    }
    else {
      return false;
    }
  }
  
  /**
   * Tester for the house class methods.
   * @param args
   */
  public static void main(String[] args) {
    House Albright = new House("Albright", "Bedford Terrace", 4, true);
    Albright.moveIn("Maura");
    Albright.moveIn("Nina");
    Albright.moveIn("Nina");
    Albright.moveOut("Joe");
    Albright.moveOut("Maura");
    System.out.println("T/F is a resident: " + Albright.isResident("Maura"));
    System.out.println("T/F is a resident: " + Albright.isResident("Sara"));
    System.out.println("Number of residents: " + Albright.nResidents());
  }

}