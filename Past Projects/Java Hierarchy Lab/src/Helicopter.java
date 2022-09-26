/**
 * 3/25/2022
 *
 * CSC-331 003
 *
 * Class is for helicopter specific variables
 */
public class Helicopter extends Air_Transportation{

    private int numBlades; // number of blades for heli

    /**
     * constructor for helicopter
     * @param quality quality of heli
     * @param color color of heli
     * @param speed speed of heli
     * @param price price of heli
     * @param capacityPeople capacity of people for heli
     * @param sizeInFeet size in feet of heli
     * @param age age of heli
     * @param capacityCargo capacity of cargo for heli
     * @param capacityWeight capacity of weight of heli
     * @param powerSource power source of heli
     * @param materialType material type of heli
     * @param usage usage of heli
     * @param altitude altitude of heli
     * @param numBlades number of blades of heli
     * @param ticketOrRental ticket or rental for heli
     * @param location location of heli
     * @param time time of heli
     */
    public Helicopter(String quality, String color, double speed, double price, int capacityPeople, int sizeInFeet,
                      int age, double capacityCargo, double capacityWeight, String powerSource, String materialType,
                      String usage, double altitude, int numBlades, String ticketOrRental, String location,
                      String time ) {
        super(quality, color, speed, price, capacityPeople, sizeInFeet, age, capacityCargo, capacityWeight,
                powerSource, materialType, usage, altitude, ticketOrRental, location, time);
        // assignment
        this.numBlades = numBlades;
    }

    /**
     * get number of blade
     * @return number of blades
     */
    public int getNumBlades() {
        return numBlades;
    }

    /**
     * set number of blades
     * @param numBlades number of blades
     */
    public void setNumBlades(int numBlades) {
        this.numBlades = numBlades;
    }

    /**
     * override toString method for helicopter
     * @return values of variables
     */
    @Override
    public String toString() {
        return super.toString() +
                "\nnumBlades=" + numBlades;
    }
}
