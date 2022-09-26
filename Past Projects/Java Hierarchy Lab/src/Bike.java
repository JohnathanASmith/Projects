/**
 * 3/25/2022
 *
 * CSC-331 003
 *
 * Class is for bike specific variables
 */
public class Bike extends Land_Transportation{

    private int numGears; // number of gears of bike

    /**
     * constructor for bike
     * @param quality quality of bike
     * @param color color of bike
     * @param speed speed of bike
     * @param price price of bike
     * @param capacityPeople capacity if bike
     * @param sizeInFeet size in feet if bike
     * @param age age of bike
     * @param capacityCargo capacity in cargo of bike
     * @param capacityWeight capacity in weight of cargo
     * @param powerSource power source of bike
     * @param materialType material type of bike
     * @param usage usage of bike
     * @param terrain terrain of bike
     * @param numberWheels number of wheels of bike
     * @param numGears number of gears of bike
     * @param ticketOrRental ticket or rental of bike
     * @param location location of bike
     * @param time time of bike
     */

    public Bike(String quality, String color, double speed, double price, int capacityPeople, int sizeInFeet,
                int age, double capacityCargo, double capacityWeight, String powerSource, String materialType,
                String usage, String terrain, int numberWheels, int numGears, String ticketOrRental, String location,
                String time) {
        super(quality, color, speed, price, capacityPeople, sizeInFeet, age, capacityCargo, capacityWeight,
                powerSource, materialType, usage, terrain, numberWheels, ticketOrRental, location, time);
        // assignment
        this.numGears = numGears;
    }

    /**
     * get number of gears
     * @return number of gears
     */
    public int getNumGears() {
        return numGears;
    }

    /**
     * set number of gears
     * @param numGears number of gears
     */
    public void setNumGears(int numGears) {
        this.numGears = numGears;
    }

    /**
     * override toString method for bike
     * @return values of variables
     */
    @Override
    public String toString() {
        return super.toString() +
                "\nnumGears=" + numGears;
    }
}
