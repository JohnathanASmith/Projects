/**
 * 3/25/2022
 *
 * CSC-331 003
 *
 * Class is for air boat specific variables
 */
public class Boat extends Water_Transportation{

    private String propellerType; // propeller type for boat
    private boolean availableRoof; // available roof for boat

    /**
     * constructor for boat
     * @param quality quality for boat
     * @param color color of boat
     * @param speed speed of boat
     * @param price price of boat
     * @param capacityPeople capacity of people for boat
     * @param sizeInFeet size in feet of boat
     * @param age age of boat
     * @param capacityCargo capacity of cargo for boat
     * @param capacityWeight capacity in weight of boat
     * @param powerSource power source of boat
     * @param materialType material type of boat
     * @param usage usage of boat
     * @param submerged submerged of boat
     * @param propeller propeller of boat
     * @param typeOfWater type of water of boat
     * @param propellerType propeller type of boat
     * @param availableRoof available roof of boat
     * @param ticketOrRental ticket or rental for boat
     * @param location location of boat
     * @param time time of boat
     */
    public Boat(String quality, String color, double speed, double price, int capacityPeople, int sizeInFeet,
                int age, double capacityCargo, double capacityWeight, String powerSource, String materialType,
                String usage, boolean submerged, boolean propeller, String typeOfWater, String propellerType,
                boolean availableRoof, String ticketOrRental, String location, String time) {
        super(quality, color, speed, price, capacityPeople, sizeInFeet, age, capacityCargo, capacityWeight,
                powerSource, materialType, usage, submerged, propeller, typeOfWater, ticketOrRental, location, time);
        // assignment
        this.propellerType = propellerType;
        this.availableRoof = availableRoof;
    }

    /**
     * fet propeller type
     * @return propeller type
     */
    public String getPropellerType() {
        return propellerType;
    }

    /**
     * set propeller type
     * @param propellerType propeller type
     */
    public void setPropellerType(String propellerType) {
        this.propellerType = propellerType;
    }

    /**
     * get available roof
     * @return available roof
     */
    public boolean isAvailableRoof() {
        return availableRoof;
    }

    /**
     * set available roof
     * @param availableRoof available roof
     */
    public void setAvailableRoof(boolean availableRoof) {
        this.availableRoof = availableRoof;
    }

    /**
     * override toString method for boat
     * @return values of variables
     */
    @Override
    public String toString() {
        return super.toString() +
                "\npropellerType='" + propellerType + '\'' +
                "\navailableRoof=" + availableRoof;
    }
}
