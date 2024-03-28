/* This is a stub for the Library class */

import java.util.Hashtable;

/**
 * Creates the library class which extends the building class and adds the attribute hashtable collection (for books in library).
 */
public class Library extends Building {
    private Hashtable<String, Boolean> collection;

    /**
     * Constructor for the library class
     * @param name
     * @param address
     * @param nFloors
     */
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      System.out.println("You have built a library: 📖");
    }
  
    /**
     * Adds book title to the book collection
     * @param title
     */
    public void addTitle(String title) {
      this.collection.put(title, true);
    }

    /**
     * Removes book title from the book collection
     * @param title
     * @return title
     */
    public String removeTitle(String title) {
      this.collection.remove(title, false);
      return title;
    }
    
    /**
     * Checks out book from the library
     * @param title
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
     * @param title
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
     * @param title
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
     * @param title
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

    } // prints out the entire collection in an easy-to-read way (including checkout status)


    /**
     * Tester for the library class
     * @param args
     */
    public static void main(String[] args) {
      Library ford = new Library("ford", "NoHo", 4);
      ford.addTitle("Little Mermaid");
      ford.checkOut("Little Mermaid");
      ford.checkOut("Little Mermaid");
      ford.returnBook("Red Balloon");
      System.out.println("T/F Book Available: " + ford.isAvailable("Little Mermaid"));
      ford.addTitle("It");
      ford.printCollection();
    }
  }