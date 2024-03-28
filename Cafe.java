/* This is a stub for the Cafe class */
/**
 * The Cafe class which extends the building class and adds the attributes nCoffeeOunces, nSugarPackets, nCreams, and nCups.
 */
public class Cafe extends Building {
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**
     * Constructor for the Cafe class
     * @param name
     * @param address
     * @param nFloors
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }
    
    /**
     * Reduces the number of supplies in the cafe when coffee is sold. If no supplies are left, it calls the restock method.
     * @param size
     * @param nSugarPackets
     * @param nCreams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces > 0 && this.nSugarPackets > 0 && this.nCreams > 0 && this.nCups > 0) {
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
        }
        else {
            restock(size, nSugarPackets, nCreams, 1);
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
        }
    }

    /**
     * Restocks the supplies in the cafe when supplies hit 0. 
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        if (this.nCoffeeOunces == 0) {
            this.nCoffeeOunces += nCoffeeOunces + 100-nCoffeeOunces;
        }
        if (this.nSugarPackets == 0) {
            this.nSugarPackets += nSugarPackets + 100-nSugarPackets;
        }
        if (this.nCreams == 0) {
            this.nCreams += nCreams + 100-nCreams;
        }
        if (this.nCups == 0) {
            this.nCups += nCups + 100-nCups;
        }
    }

    /**
     * Tester for the cafe class methods
     * @param args
     */
    public static void main(String[] args) {
        Cafe Woodstar = new Cafe("Woodstar", "Noho", 5, 100, 100, 100, 100);
        Woodstar.sellCoffee(20,12, 2);
        System.out.println("Ounces of coffee left:" + Woodstar.nCoffeeOunces);
        Woodstar.sellCoffee(80,12, 2);
        System.out.println("Ounces of coffee left:" + Woodstar.nCoffeeOunces);
        Woodstar.sellCoffee(10,12, 2);
        System.out.println("Ounces of coffee left:" + Woodstar.nCoffeeOunces);
        System.out.println("Sugar remaining:" + Woodstar.nSugarPackets);
    }
    
}
