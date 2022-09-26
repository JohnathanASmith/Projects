/**
 * 3/25/2022
 *
 * CSC-331 003
 *
 * Class is for balloon specific variables
 */public class Hot_Air_Baloon extends Air_Transportation{

    private String baloonPatternDesign; // pattern design of balloon

    /**
     * constructor for hot air balloon
     * @param quality quality of balloon
     * @param color color of balloon
     * @param speed speed of balloon
     * @param price price of balloon
     * @param capacityPeople capacity of people for balloon
     * @param sizeInFeet size in feet of balloon
     * @param age age of balloon
     * @param capacityCargo capacity of cargo for balloon
     * @param capacityWeight capacity in weight for balloon
     * @param powerSource power source of balloon
     * @param materialType material type of balloon
     * @param usage usage of balloon
     * @param altitude altitude of balloon
     * @param baloonPatternDesign pattern of balloon
     * @param ticketOrRental ticket or rental of balloon
     * @param location location of balloon
     * @param time time of balloon
     */
    public Hot_Air_Baloon(String quality, String color, double speed, double price, int capacityPeople,
                          int sizeInFeet, int age, double capacityCargo, double capacityWeight, String powerSource,
                          String materialType, String usage, double altitude, String baloonPatternDesign,
                          String ticketOrRental, String location, String time) {
        super(quality, color, speed, price, capacityPeople, sizeInFeet, age, capacityCargo, capacityWeight,
                powerSource, materialType, usage, altitude, ticketOrRental, location, time);
        // assignment
        this.baloonPatternDesign = baloonPatternDesign;
    }

    /**
     * get pattern
     * @return pattern
     */
    public String getBaloonPatternDesign() {
        return baloonPatternDesign;
    }

    /**
     * set pattern
     * @param baloonPatternDesign pattern
     */
    public void setBaloonPatternDesign(String baloonPatternDesign) {
        this.baloonPatternDesign = baloonPatternDesign;
    }

    /**
     * override toString method for balloon
     * @return values of variables
     */
    @Override
    public String toString() {
        return super.toString() +
                "\nbaloonPatternDesign='" + baloonPatternDesign + '\'';
    }
}
