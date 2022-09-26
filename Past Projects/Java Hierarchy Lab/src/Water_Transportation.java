/**
 * 3/25/2022
 *
 * CSC-331 003
 *
 * Class is for water transportation specific variables
 */
public class Water_Transportation extends Transportation {

    private boolean submerged; // submerged for water transportation
    private boolean propeller; // propeller for water transportation
    private String typeOfWater; // type of water for water transportation

    /**
     * constructor for water transportation
     * @param quality quality of water transportation
     * @param color color of water transportation
     * @param speed speed of water transportation
     * @param price price of water transportation
     * @param capacityPeople capacity of people for water transportation
     * @param sizeInFeet size in feet of water transportation
     * @param age age of water transportation
     * @param capacityCargo capacity of cargo for water transportation
     * @param capacityWeight capacity in weight of water transportation
     * @param powerSource power source of water transportation
     * @param materialType material type of water transportation
     * @param usage usage of water transportation
     * @param submerged submerged of water transportation
     * @param propeller propeller of water transportation
     * @param typeOfWater type of water for water transportation
     * @param ticketOrRental ticket or rental of water transportation
     * @param location location of water transportation
     * @param time time of water transportation
     */
    public Water_Transportation(String quality, String color, double speed, double price, int capacityPeople,
                                int sizeInFeet, int age, double capacityCargo, double capacityWeight,
                                String powerSource, String materialType, String usage, boolean submerged,
                                boolean propeller, String typeOfWater, String ticketOrRental, String location,
                                String time) {
        super(quality, color, speed, price, capacityPeople, sizeInFeet, age, capacityCargo,
                capacityWeight, powerSource, materialType, usage, ticketOrRental, location, time);
        // assignment
        this.submerged = submerged;
        this.propeller = propeller;
        this.typeOfWater = typeOfWater;
    }

    /**
     * get submerged
     * @return submerged
     */
    public boolean isSubmerged() {
        return submerged;
    }

    /**
     * set submerged
     * @param submerged submerged
     */
    public void setSubmerged(boolean submerged) {
        this.submerged = submerged;
    }

    /**
     * get propeller
     * @return propeller
     */
    public boolean isPropeller() {
        return propeller;
    }

    /**
     * set propeller
     * @param propeller propeller
     */
    public void setPropeller(boolean propeller) {
        this.propeller = propeller;
    }

    /**
     * get type of water
     * @return type of water
     */
    public String getTypeOfWater() {
        return typeOfWater;
    }

    /**
     * set type of water
     * @param typeOfWater type of water
     */
    public void setTypeOfWater(String typeOfWater) {
        this.typeOfWater = typeOfWater;
    }

    /**
     * override toString method for water transportation
     * @return values of variables
     */
    @Override
    public String toString() {
        return super.toString() + "\nsubmerged=" + submerged +
                "\npropeller=" + propeller +
                "\ntypeOfWater='" + typeOfWater + '\'';
    }
}
