/* This is a stub for the House class */
import java.util.ArrayList;
import javax.management.RuntimeErrorException;
import java.lang.Math;
import java.util.Scanner;

/**
 * The house class that extends the building class and adds the attributes residents and hasDiningRoom.
 */
public class House extends Building {
    private ArrayList<String> residents; 
    private boolean hasDiningRoom;
    private boolean hasElevator;

  /**
   * The constructor for the house class that allows user to input following params
   * @param name
   * @param address
   * @param nFloors
   * @param hasDiningRoom
   * @param hasElevator
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
  }

  /**
   * The constructor for the house class that allows user to input following params
   * @param name
   * @param address
   * @param nFloors
   */
  public House(String name, String address, int nFloors) {
    super(name,address,nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = true;
    this.hasElevator = false;
  }

    /**
   * The constructor for the house class with default all params
   */
  public House() {
    super();
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = true;
    this.hasElevator = false;
  }


  /**
   * Getter for hasDiningRoom
   * @return boolean for if the house has a dining room
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * Getter for hasElevator
   * @return boolean for if the house has elevator
   */
  public boolean hasElevator() {
    return this.hasElevator;
  }
  
  /**
   * Getter for nResidents
   * @return the size of the residents ArrayList (Number of residents)
   */
  private int nResidents() {
    return this.residents.size();
  }

  /**
   * Adds new resident to ArrayList residents
   * @param name name of new resident
   */
  public void moveIn(String name) {//Make a way to move in many ppl at once
    if (isResident(name) == false) {
      this.residents.add(name);
    }
    else {
      System.out.println(name + " already lives here!");
    }
  }

  /**
   * Adds multiple new residents to ArrayList residents at once
   * @param nPeople number of people being moved in
   */
  public void moveIn(int nPeople) {
    int roundsCounter = 0;
    Scanner myObj = new Scanner(System.in);
    ArrayList <String> names = new ArrayList<String>();
    while (nPeople > roundsCounter) {
      System.out.println("Give me a name to move in:");
      String name = myObj.nextLine();
      names.add(name);
      if (isResident(name) == false) {
        this.residents.add(name);
      }
      else {
        System.out.println(name + " already lives here!");
      }
      roundsCounter += 1;
    }
    myObj.close();
  }

  /**
   * Removes resident from ArrayList resident
   * @param name name of resident
   * @return name of removed resident
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
   * @param person name of potential resident of the house
   * @return boolean for if the person lives in the house
   */
  private boolean isResident(String person) {
    if (this.residents.contains(person)) {
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * Allows the user to move floors based on presence or lack of elevator an floor picked
   * @param floorNum floor number to move to
   */
  public void goToFloor(int floorNum) { //Modify this or override in child class b/c teleporting doesn't work
    if (this.activeFloor == -1) {
      throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
      throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    if (this.hasElevator() == false && Math.abs(this.activeFloor - floorNum) > 1) {
      throw new RuntimeException("There is no elevator! You can only use the goUp() or goDown methods to change by more than 1 floor!");
    } 
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
  }
  
  /**
    * Prints available methods for this class
    */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) \n + moveIn() \n + moveOut()");
  }
  
  /**
   * Tester for the house class methods.
   * @param args
   */
  public static void main(String[] args) {
    House Albright = new House("Albright", "Bedford Terrace", 4, true, false);
    Albright.moveIn("Maura");
    Albright.moveIn("Nina");
    Albright.moveIn("Nina");
    Albright.moveOut("Joe");
    Albright.moveOut("Maura");
    System.out.println("T/F is a resident: " + Albright.isResident("Maura"));
    System.out.println("T/F is a resident: " + Albright.isResident("Sara"));
    System.out.println("Number of residents: " + Albright.nResidents());
    Albright.showOptions();
    House Default = new House();
    System.out.println(Default.getAddress());
    Albright.moveIn(2);
  }

}