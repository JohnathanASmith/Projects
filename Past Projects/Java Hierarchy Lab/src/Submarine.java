/**
 * 3/25/2022
 *
 * CSC-331 003
 *
 * Class is for submarine specific variables
 */
public class Submarine extends Water_Transportation{

    private double depthDistance; // depth distance for sub
    private boolean stealthCapability; // stealth capability distance of sub
    private double visionDistance;  // vision distance of sub
    private String sonarType; // sonar type of sub

    /**
     * constructor for submarine
     * @param quality quality of sub
     * @param color color of sub
     * @param speed speed of sub
     * @param price price of sub
     * @param capacityPeople capacity of people for sub
     * @param sizeInFeet size inf feet of sub
     * @param age age of sub
     * @param capacityCargo capacity of cargo for sub
     * @param capacityWeight capacity in weight if sub
     * @param powerSource power source of sub
     * @param materialType material type of sub
     * @param usage usage of sub
     * @param submerged submerge of sub
     * @param propeller propeller for sub
     * @param typeOfWater type of water of sub
     * @param depthDistance depth distance od sub
     * @param stealthCapability stealth capability of sub
     * @param visionDistance vision distance of sub
     * @param sonarType sonar type of sub
     * @param ticketOrRental ticket or rental for sub
     * @param location location of sub
     * @param time time of sub
     */
    public Submarine(String quality, String color, double speed, double price, int capacityPeople, int sizeInFeet,
                     int age, double capacityCargo, double capacityWeight, String powerSource, String materialType,
                     String usage, boolean submerged, boolean propeller, String typeOfWater, double depthDistance,
                     boolean stealthCapability, double visionDistance, String sonarType, String ticketOrRental,
                     String location, String time) {
        super(quality, color, speed, price, capacityPeople, sizeInFeet, age, capacityCargo, capacityWeight,
                powerSource, materialType, usage, submerged, propeller, typeOfWater, ticketOrRental, location, time);
        // assignment
        this.depthDistance = depthDistance;
        this.stealthCapability = stealthCapability;
        this.visionDistance = visionDistance;
        this.sonarType = sonarType;
    }

    /**
     * get depth distance
     * @return depth distance
     */
    public double getDepthDistance() {
        return depthDistance;
    }

    /**
     * set depth distance
     * @param depthDistance depth distance
     */
    public void setDepthDistance(double depthDistance) {
        this.depthDistance = depthDistance;
    }

    /**
     * get stealth capability
     * @return stealth capability
     */
    public boolean isStealthCapability() {
        return stealthCapability;
    }

    /**
     * set stealth capability
     * @param stealthCapability stealth capability
     */
    public void setStealthCapability(boolean stealthCapability) {
        this.stealthCapability = stealthCapability;
    }

    /**
     * get vision distance
     * @return vision distance
     */
    public double getVisionDistance() {
        return visionDistance;
    }

    /**
     * set vision distance
     * @param visionDistance vision distance
     */
    public void setVisionDistance(double visionDistance) {
        this.visionDistance = visionDistance;
    }

    /**
     * get sonar type
     * @return sonar type
     */
    public String getSonarType() {
        return sonarType;
    }

    /**
     * set sonar type
     * @param sonarType sonar type
     */
    public void setSonarType(String sonarType) {
        this.sonarType = sonarType;
    }

    /**
     * override toString method for sub
     * @return values of variables
     */
    @Override
    public String toString() {
        return super.toString() +
                "\ndepthDistance=" + depthDistance +
                "\nstealthCapability=" + stealthCapability +
                "\nvisionDistance=" + visionDistance +
                "\nsonarType='" + sonarType + '\'';
    }
}
