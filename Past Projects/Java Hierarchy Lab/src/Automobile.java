/**
 * 3/25/2022
 *
 * CSC-331 003
 *
 * Class is for automobile specific variables
 */
public class Automobile extends Land_Transportation{

    private String wheelType; // wheel type of automobile

    /**
     * constructor for automobile
     * @param quality quality of automobile
     * @param color color of automobile
     * @param speed speed of automobile
     * @param price price of automobile
     * @param capacityPeople capacity of people for automobile
     * @param sizeInFeet size in feet of automobile
     * @param age age of automobile
     * @param capacityCargo capacity of cargo for automobile
     * @param capacityWeight capacity in weight of automobile
     * @param powerSource power source of automobile
     * @param materialType material type of automobile
     * @param usage usage of automobile
     * @param terrain terrain for automobile
     * @param numberWheels number of wheels for automobile
     * @param wheelType wheel type for automobile
     * @param ticketOrRental ticker or rental for automobile
     * @param location location of automobile
     * @param time time for automobile
     */
    public Automobile(String quality, String color, double speed, double price, int capacityPeople, int sizeInFeet,
                      int age, double capacityCargo, double capacityWeight, String powerSource, String materialType,
                      String usage, String terrain, int numberWheels, String wheelType, String ticketOrRental,
                      String location, String time) {
        super(quality, color, speed, price, capacityPeople, sizeInFeet, age, capacityCargo, capacityWeight,
                powerSource, materialType, usage, terrain, numberWheels, ticketOrRental, location, time);
        // assignment
        this.wheelType = wheelType;
    }

    /**
     * get wheel type
     * @return wheel type
     */
    public String getWheelType() {
        return wheelType;
    }

    /**
     * set wheel type
     * @param wheelType wheel type
     */
    public void setWheelType(String wheelType) {
        this.wheelType = wheelType;
    }

    /**
     * override toString method for automobile
     * @return values of variables
     */
    @Override
    public String toString() {
        return super.toString() +
                "\nwheelType='" + wheelType + '\'';
    }
}
