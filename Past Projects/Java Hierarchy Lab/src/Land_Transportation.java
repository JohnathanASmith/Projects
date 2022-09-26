/**
 * 3/25/2022
 *
 * CSC-331 003
 *
 * Class is for land transportation specific variables
 */
public class Land_Transportation extends Transportation{

    private String terrain; // terrain capability of land transportation
    private int numberWheels; // number of wheels of land transportation

    /**
     * constructor for land transportation
     * @param quality quality of land transportation
     * @param color color of land transportation
     * @param speed speed of land transportation
     * @param price price of land transportation
     * @param capacityPeople capacity of people for land transportation
     * @param sizeInFeet size in feet of land transportation
     * @param age age of the land transportation
     * @param capacityCargo capacity of cargo for land transportation
     * @param capacityWeight capacity in weight of land transportation
     * @param powerSource power source of land transportation
     * @param materialType material of land transportation
     * @param usage usage of land transportation
     * @param ticketOrRental ticket or rental for land transportation
     * @param location location of land transportation
     * @param time time for land transportation
     * @param terrain terrain for land transportation
     * @param numberWheels wheels for land transportation
     */
    public Land_Transportation(String quality, String color, double speed, double price, int capacityPeople,
                               int sizeInFeet, int age, double capacityCargo, double capacityWeight,
                               String powerSource, String materialType, String usage, String terrain,
                               int numberWheels, String ticketOrRental, String location, String time) {
        super(quality, color, speed, price, capacityPeople, sizeInFeet, age, capacityCargo, capacityWeight,
                powerSource, materialType, usage, ticketOrRental, location, time);
        // assignment
        this.terrain = terrain;
        this.numberWheels = numberWheels;
    }

    /**
     * gets terrain
     * @return terrain
     */
    public String getTerrain() {
        return terrain;
    }

    /**
     * sets terrain
     * @param terrain terrain of land transportation
     */
    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    /**
     * gets number of wheels
     * @return number of wheels
     */
    public int getNumberWheels() {
        return numberWheels;
    }

    /**
     * sets number of wheels
     * @param numberWheels number of wheels for land transportation
     */
    public void setNumberWheels(int numberWheels) {
        this.numberWheels = numberWheels;
    }

    /**
     * override toString method for land transportation
     * @return values of variables
     */
    @Override
    public String toString() {
        return  super.toString() +
                "\nterrain='" + terrain + '\'' +
                "\nnumberWheels=" + numberWheels;
    }
}
