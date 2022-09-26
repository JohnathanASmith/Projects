/**
 * 3/25/2022
 *
 * CSC-331 003
 *
 * Class is for bus specific variables
 */
public class Bus extends Land_Transportation{

    private int numLevels; // number of levels for bus

    /**
     * constructor for bus
     * @param quality quality of bus
     * @param color color of bus
     * @param speed speed of bus
     * @param price price of bus
     * @param capacityPeople capacity of people for bus
     * @param sizeInFeet size in feet of bus
     * @param age age of bus
     * @param capacityCargo capacity of cargo for bus
     * @param capacityWeight capacity in weight of bus
     * @param powerSource power source of bus
     * @param materialType material type of bus
     * @param usage usage of bus
     * @param terrain terrain for bus
     * @param numberWheels number of wheels for bus
     * @param numLevels number iof levels of bus
     * @param ticketOrRental ticket or rental of bus
     * @param location location of bus
     * @param time time of bus
     */
    public Bus(String quality, String color, double speed, double price, int capacityPeople, int sizeInFeet, int age,
               double capacityCargo, double capacityWeight, String powerSource, String materialType, String usage,
               String terrain, int numberWheels, int numLevels, String ticketOrRental, String location, String time) {
        super(quality, color, speed, price, capacityPeople, sizeInFeet, age, capacityCargo, capacityWeight,
                powerSource, materialType, usage, terrain, numberWheels, ticketOrRental, location, time);
        // assignment
        this.numLevels = numLevels;
    }

    /**
     * get number of levels
     * @return number of levels
     */
    public int getNumLevels() {
        return numLevels;
    }

    /**
     * set number of levels
     * @param numLevels number of levels
     */
    public void setNumLevels(int numLevels) {
        this.numLevels = numLevels;
    }

    /**
     * override toString method for bus
     * @return values of variables
     */
    @Override
    public String toString() {
        return super.toString() +
                "\nnumLevels=" + numLevels;
    }
}
