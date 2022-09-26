/**
 * 3/25/2022
 *
 * CSC-331 003
 *
 * Class is for drigible specific variables
 */
public class Drigible extends Air_Transportation{

    private String frameType; // frame type of drig

    /**
     * constructor for drig
     * @param quality quality of drig
     * @param color color of drig
     * @param speed speed of drig
     * @param price price of drig
     * @param capacityPeople capacity of people for drig
     * @param sizeInFeet size in feet of drig
     * @param age age of drig
     * @param capacityCargo capacity of cargo for drig
     * @param capacityWeight capacity in weight of drig
     * @param powerSource power source of drig
     * @param materialType material type of drig
     * @param usage usage of drig
     * @param altitude altitude of drig
     * @param frameType frame type of drig
     * @param ticketOrRental ticket or rental of drig
     * @param location location of drig
     * @param time time of drig
     */
    public Drigible(String quality, String color, double speed, double price, int capacityPeople, int sizeInFeet,
                    int age, double capacityCargo, double capacityWeight, String powerSource, String materialType,
                    String usage, double altitude, String frameType, String ticketOrRental, String location,
                    String time) {
        super(quality, color, speed, price, capacityPeople, sizeInFeet, age, capacityCargo, capacityWeight,
                powerSource, materialType, usage, altitude, ticketOrRental, location, time);
        // assignment
        this.frameType = frameType;
    }

    /**
     * get frame type
     * @return frame type
     */
    public String getFrameType() {
        return frameType;
    }

    /**
     * set frame type
     * @param frameType frame type
     */
    public void setFrameType(String frameType) {
        this.frameType = frameType;
    }

    /**
     * override toString method for drigible
     * @return values of variables
     */
    @Override
    public String toString() {
        return super.toString() +
                "\nframeType='" + frameType + '\'';
    }
}
