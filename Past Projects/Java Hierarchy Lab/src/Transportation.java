/**
 * 3/25/2022
 *
 * CSC-331 003
 *
 * Class is for transportation specific variables
 */
public class Transportation {

    private String quality; // quality of transportation
    private String color; // color of transportation
    private double speed; // speed of transportation
    private double price; // price of transportation
    private int capacityPeople; // capacity of people for transportation
    private int sizeInFeet; // size in feet of transportation
    private int age; // age of transportation
    private double capacityCargo; // capacity of cargo of transportation
    private double capacityWeight; // capacity of weight for transportation
    private String powerSource; // power source of transportation
    private String materialType; // material type of transportation
    private String usage; // usage of transportation
    private String ticketOrRental; // ticket or rental of transportation
    private String location; // location of transportation
    private String time; // time of transportation

    /**
     * constructor for transportation
     * @param quality quality of transportation
     * @param color color of transportation
     * @param speed speed of transportation
     * @param price price of transportation
     * @param capacityPeople capacity of people for transportation
     * @param sizeInFeet size in feet of transportation
     * @param age age of the transportation
     * @param capacityCargo capacity of cargo for transportation
     * @param capacityWeight capacity in weight of transportation
     * @param powerSource power source of transportation
     * @param materialType material of transportation
     * @param usage usage of transportation
     * @param ticketOrRental ticket or rental for transportation
     * @param location location of transportation
     * @param time time for transportation
     */
    public Transportation(String quality, String color, double speed, double price, int capacityPeople,
                          int sizeInFeet, int age, double capacityCargo, double capacityWeight,
                          String powerSource, String materialType, String usage, String ticketOrRental,
                          String location, String time) {
        // assignment
        this.quality = quality;
        this.color = color;
        this.speed = speed;
        this.price = price;
        this.capacityPeople = capacityPeople;
        this.sizeInFeet = sizeInFeet;
        this.age = age;
        this.capacityCargo = capacityCargo;
        this.capacityWeight = capacityWeight;
        this.powerSource = powerSource;
        this.materialType = materialType;
        this.usage = usage;
        this.ticketOrRental = ticketOrRental;
        this.location = location;
        this.time = time;

    }

    /**
     * gets the quality
     * @return quality
     */
    public String getQuality() {
        return quality;
    }

    /**
     * sets the quality
     * @param quality quality of transportation
     */
    public void setQuality(String quality) {
        this.quality = quality;
    }

    /**
     * gets the color
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * sets the color
     * @param color color of transportation
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * gets the speed
     * @return speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * sets the speed
     * @param speed speed of transportation
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * gets the price
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * sets the price
     * @param price price of transportation
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * gets the capacity of people
     * @return capacity of people
     */
    public int getCapacityPeople() {
        return capacityPeople;
    }

    /**
     * sets the capacity of people
     * @param capacityPeople capacity of people for transportation
     */
    public void setCapacityPeople(int capacityPeople) {
        this.capacityPeople = capacityPeople;
    }

    /**
     * gets the size in feet
     * @return size in feet
     */
    public int getSizeInFeet() {
        return sizeInFeet;
    }

    /**
     * sets the size in feet
     * @param sizeInFeet size in feet of the transportation
     */
    public void setSizeInFeet(int sizeInFeet) {
        this.sizeInFeet = sizeInFeet;
    }

    /**
     * gets the age
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * sets the age
     * @param age age of transportation
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * gets the capacity of people
     * @return capacity of people
     */
    public double getCapacityCargo() {
        return capacityCargo;
    }

    /**
     * sets the capacity of people
     * @param capacityCargo capacity of people for transportation
     */
    public void setCapacityCargo(double capacityCargo) {
        this.capacityCargo = capacityCargo;
    }

    /**
     * gets the capacity of cargo
     * @return capacity of cargo
     */
    public double getCapacityWeight() {
        return capacityWeight;
    }

    /**
     * sets the capacity of cargo
     * @param capacityWeight capacity of cargo for transportation
     */
    public void setCapacityWeight(double capacityWeight) {
        this.capacityWeight = capacityWeight;
    }

    /**
     * gets the power source
     * @return power source
     */
    public String getPowerSource() {
        return powerSource;
    }

    /**
     * sets the power source
     * @param powerSource power source of transportation
     */
    public void setPowerSource(String powerSource) {
        this.powerSource = powerSource;
    }

    /**
     * gets the material
     * @return material
     */
    public String getMaterialType() {
        return materialType;
    }

    /**
     * sets the material
     * @param materialType material of transportation
     */
    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    /**
     * gets usage
     * @return usage
     */
    public String getUsage() {
        return usage;
    }

    /**
     * sets usage
     * @param usage usage of transportation
     */
    public void setUsage(String usage) {
        this.usage = usage;
    }

    /**
     * get ticket or rental
     * @return ticket or rental
     */
    public String getTicketOrRental() {return ticketOrRental; }

    /**
     * set ticket or rental
     * @param ticketOrRental if ticket or rental
     */
    public void setTicketOrRental(String ticketOrRental) {this.ticketOrRental = ticketOrRental; }

    /**
     * get location
     * @return location
     */
    public String getLocation() {return location;}

    /**
     * set location
     * @param location location of transportation
     */
    public void setLocation(String location) {this.location = location; }

    /**
     * get time
     * @return time
     */
    public String getTime() {
        return time;
    }

    /**
     * set time
     * @param time time of transportation
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * override toString method for Transportation
     * @return values of variables
     */
    @Override
    public String toString() {
        return "quality='" + quality + '\'' +
                "\ncolor='" + color + '\'' +
                "\nspeed=" + speed +
                "\nprice=" + price +
                "\ncapacityPeople=" + capacityPeople +
                "\nsizeInFeet=" + sizeInFeet +
                "\nage=" + age +
                "\ncapacityCargo=" + capacityCargo +
                "\ncapacityWeight=" + capacityWeight +
                "\npowerSource='" + powerSource + '\'' +
                "\nmaterialType='" + materialType + '\'' +
                "\nusage='" + usage + '\'' +
                "\nticketOrRental='" + ticketOrRental + '\'' +
                "\nlocation='" + location + '\'' +
                "\ntime='" + time + '\'';
    }
}
