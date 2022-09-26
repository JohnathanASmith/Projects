/**
 * 3/25/2022
 *
 * CSC-331 003
 *
 * Class is for air transportation specific variables
 */
public class Air_Transportation extends Transportation{

    private double altitude; // altitude of air transportation

    /**
     * Constructor for Air transportation
     * @param quality quality of air transportation
     * @param color color of air transportation
     * @param speed speed of air transportation
     * @param price price of air transportation
     * @param capacityPeople capacity of people for air transportation
     * @param sizeInFeet size in feet of air transportation
     * @param age age of the air transportation
     * @param capacityCargo capacity of cargo for air transportation
     * @param capacityWeight capacity in weight of air transportation
     * @param powerSource power source of air transportation
     * @param materialType material of air transportation
     * @param usage usage of air transportation
     * @param altitude altitude of air transportation
     * @param ticketOrRental ticket or rental for air transportation
     * @param location location of aor transportation
     * @param time time for air transportation
     */
    public Air_Transportation(String quality, String color, double speed, double price, int capacityPeople,
                              int sizeInFeet, int age, double capacityCargo, double capacityWeight, String powerSource,
                              String materialType, String usage, double altitude, String ticketOrRental, String location,
                              String time) {
        super(quality, color, speed, price, capacityPeople, sizeInFeet, age, capacityCargo,
                capacityWeight, powerSource, materialType, usage , ticketOrRental, location, time);
        // assignment
        this.altitude = altitude;
    }

    /**
     * get altitude
     * @return altitude
     */
    public double getAltitude() {
        return altitude;
    }

    /**
     * set altitude
     * @param altitude altitude of air transportation
     */
    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    /**
     * override toString method for air transportation
     * @return values of variables
     */
    @Override
    public String toString() {
        return super.toString() +
                "\naltitude=" + altitude;
    }
}