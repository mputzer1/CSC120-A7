/* This is a stub for the Library class */

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.lang.Math;

/**
 * Creates the library class which extends the building class and adds the attribute hashtable collection (for books in library).
 */
public class Library extends Building {
    private Hashtable<String, Boolean> collection;
    private boolean hasElevator;

    /**
     * Constructor for the library class
     * @param name
     * @param address
     * @param nFloors
     * @param hasElevator
     */
    public Library(String name, String address, int nFloors, boolean hasElevator) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      this.hasElevator = hasElevator;
    }

    /**
     * Constructor for the library class where the hasElevator attribute is true
     * @param name
     * @param address
     * @param nFloors
     */
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      this.hasElevator = true;
    }

    /**
     * Constructor for the library class with preset params
     */
    public Library() {
      super();
      this.collection = new Hashtable<String, Boolean>();
      this.hasElevator = false;
    }
  
    /**
    * Getter for hasElevator
    * @return boolean for if the house has elevator (T/F)
    */
    public boolean hasElevator() {
      return this.hasElevator;
    }
    
    /**
     * Adds book title to the book collection
     * @param title of book to be added
     */
    private void addTitle(String title) { //Make way for people to checkout multiple books
      this.collection.put(title, true);
    }


    /**
     * Adds several book titles to the collection
     * @param nTitles number of books to be added
     */
    private void addTitle(int nTitles) {
      int roundsCounter = 0;
      Scanner myObj = new Scanner(System.in);
      ArrayList <String> titlesArrayList = new ArrayList<String>();
      while (nTitles > roundsCounter) {
        System.out.println("Give me a title to add:");
        String title = myObj.nextLine();
        titlesArrayList.add(title);
        this.collection.put(title, true);
        roundsCounter += 1;
      }
      myObj.close();
    }

    /**
     * Removes book title from the book collection
     * @param title of book to be removed
     * @return title of book removed
     */
    private String removeTitle(String title) {
      this.collection.remove(title, false);
      return title;
    }
    
    /**
     * Checks out book from the library
     * @param title of book checked out
     */
    public void checkOut(String title) {
      if (containsTitle(title) == true && isAvailable(title) == true) {
        this.collection.replace(title, false);
      }
      else {
        System.out.println("This book is not in the library's collection or was checked out!");
      }
    }
    
    /**
     * Returns book to the library
     * @param title of book returned
     */
    public void returnBook(String title) {
      if (containsTitle(title) == true) {
        this.collection.replace(title, true);
      }
      else {
        System.out.println("This book was never in the library's collection!");
      }
    }
    
    /**
     * Checks if library collection contains a certain book
     * @param title of book that might be contained in library
     * @return boolean(whether library contains book)
     */
    public boolean containsTitle(String title) {
      if (this.collection.containsKey(title)) {
        return true;
      }
      else;
        return false;
    }
    
    /**
     * Checks if library book is available to be checked out
     * @param title of book that might be available in library
     * @return boolean(whether library book is available to be checked out)
     */
    public boolean isAvailable(String title) {
      if (this.collection.get(title) == true) {
        return true;
      }
      else;
        return false;
    }
    
    /**
     * Prints out the entire library book collection
     */
    public void printCollection() {
      System.out.println("\nLibrary Book Collection:" + "\n" + this.collection);
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
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) \n + checkOut() \n + returnBook() \n + printCollection() \n + containsTitle() \n + isAvailable()");
    }

    /**
     * Tester for the library class
     * @param args
     */
    public static void main(String[] args) {
      Library Forbes = new Library("Forbes", "NoHo", 4, false);
      Forbes.addTitle("Little Mermaid");
      Forbes.checkOut("Little Mermaid");
      Forbes.checkOut("Little Mermaid");
      Forbes.returnBook("Red Balloon");
      System.out.println("T/F Book Available: " + Forbes.isAvailable("Little Mermaid"));
      Forbes.addTitle("It");
      Forbes.printCollection();
      Forbes.enter();
      //Forbes.goToFloor(3);
      Library Default = new Library();
      System.out.println(Default);
      Forbes.addTitle(10);
      //Forbes.showOptions();
    }
  }