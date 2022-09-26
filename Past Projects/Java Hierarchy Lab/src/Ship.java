/**
 * 3/25/2022
 *
 * CSC-331 003
 *
 * Class is for ship specific variables
 */
public class Ship extends Water_Transportation{

    private boolean sail; // sail for ship

    /**
     * constructor for ship
     * @param quality quality of ship
     * @param color color of ship
     * @param speed speed of ship
     * @param price price of ship
     * @param capacityPeople capacity of people for ship
     * @param sizeInFeet size in feet of ship
     * @param age age of ship
     * @param capacityCargo capacity of cargo for ship
     * @param capacityWeight capacity in weight if ship
     * @param powerSource power source of ship
     * @param materialType material type of ship
     * @param usage usage of ship
     * @param submerged submerged for ship
     * @param propeller propeller for ship
     * @param typeOfWater type of water for ship
     * @param sail sail of ship
     * @param ticketOrRental ticket or rental for ship
     * @param location location of ship
     * @param time time of ship
     */
    public Ship(String quality, String color, double speed, double price, int capacityPeople, int sizeInFeet,
                int age, double capacityCargo, double capacityWeight, String powerSource, String materialType,
                String usage, boolean submerged, boolean propeller, String typeOfWater, boolean sail,
                String ticketOrRental, String location, String time) {
        super(quality, color, speed, price, capacityPeople, sizeInFeet, age, capacityCargo, capacityWeight,
                powerSource, materialType, usage, submerged, propeller, typeOfWater, ticketOrRental, location, time);
        // assignment
        this.sail = sail;
    }

    /**
     * get sail
     * @return sail
     */
    public boolean isSail() {
        return sail;
    }

    /**
     * set sail
     * @param sail sail
     */
    public void setSail(boolean sail) {
        this.sail = sail;
    }

    /**
     * override toString method for ship
     * @return values of variables
     */
    @Override
    public String toString() {
        return super.toString() + "\nsail=" + sail;
    }
}
