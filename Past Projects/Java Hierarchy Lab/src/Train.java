/**
 * 3/25/2022
 *
 * CSC-331 003
 *
 * Class is for train specific variables
 */
public class Train extends Land_Transportation{

    private int numCarts; // number of carts for train

    /**
     * constructor for train
     * @param quality quality of train
     * @param color color of train
     * @param speed speed of train
     * @param price price of train
     * @param capacityPeople capacity of people for train
     * @param sizeInFeet size in feet of train
     * @param age age of train
     * @param capacityCargo capacity of cargo for train
     * @param capacityWeight capacity on weight for train
     * @param powerSource power source of train
     * @param materialType material type of train
     * @param usage usage of train
     * @param terrain terrain for train
     * @param numberWheels number of wheels for train
     * @param numCarts number of carts for train
     * @param ticketOrRental ticket or rental for train
     * @param location location of train
     * @param time time of train
     */
    public Train(String quality, String color, double speed, double price, int capacityPeople, int sizeInFeet, int age,
                 double capacityCargo, double capacityWeight, String powerSource, String materialType, String usage,
                 String terrain, int numberWheels, int numCarts, String ticketOrRental, String location, String time) {
        super(quality, color, speed, price, capacityPeople, sizeInFeet, age, capacityCargo, capacityWeight,
                powerSource, materialType, usage, terrain, numberWheels, ticketOrRental,location, time);
        // assignment
        this.numCarts = numCarts;
    }

    /**
     * get number of carts
     * @return number of carts
     */
    public int getNumCarts() {
        return numCarts;
    }

    /**
     * set number of carts
     * @param numCarts number of carts
     */
    public void setNumCarts(int numCarts) {
        this.numCarts = numCarts;
    }

    /**
     * override toString method for train
     * @return values of variables
     */
    @Override
    public String toString() {
        return super.toString()+
                "\nnumCarts=" + numCarts;
    }
}
