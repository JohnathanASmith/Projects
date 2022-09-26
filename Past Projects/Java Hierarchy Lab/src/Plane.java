/**
 * 3/25/2022
 *
 * CSC-331 003
 *
 * Class is for plane specific variables
 */
public class Plane extends Air_Transportation{

    private boolean needCopilot; // need copilot of plane

    /**
     * constructor for plane
     * @param quality quality of plane
     * @param color color of plane
     * @param speed speed of plane
     * @param price price of plane
     * @param capacityPeople capacity of people for plane
     * @param sizeInFeet size on feet of plane
     * @param age age of plane
     * @param capacityCargo capacity of cargo for plane
     * @param capacityWeight capacity in weight of plane
     * @param powerSource power source of plane
     * @param materialType material type of plane
     * @param usage usage of plane
     * @param altitude altitude of plane
     * @param needCopilot need copilot of plane
     * @param ticketOrRental ticket or rental of plane
     * @param location location of plane
     * @param time time of plane
     */
    public Plane(String quality, String color, double speed, double price, int capacityPeople, int sizeInFeet,
                 int age, double capacityCargo, double capacityWeight, String powerSource, String materialType,
                 String usage, double altitude, boolean needCopilot, String ticketOrRental, String location,
                 String time) {
        super(quality, color, speed, price, capacityPeople, sizeInFeet, age, capacityCargo, capacityWeight,
                powerSource, materialType, usage, altitude, ticketOrRental, location, time);
        // assignment
        this.needCopilot = needCopilot;
    }

    /**
     * get need copilot
     * @return need copilot
     */
    public boolean isNeedCopilot() {
        return needCopilot;
    }

    /**
     * set need copilot
     * @param needCopilot need copilot
     */
    public void setNeedCopilot(boolean needCopilot) {
        this.needCopilot = needCopilot;
    }

    /**
     * override toString method for plane
     * @return values of variables
     */
    @Override
    public String toString() {
        return super.toString() +
                "\nneedCopilot=" + needCopilot;
    }
}
