/**
 * 3/25/2022
 *
 * CSC-331 003
 *
 * purpose of this program is to get the user to choose a type of transportation
 * and from that give them a price for that transportation
 */

import java.util.Arrays; // program uses array
import java.util.Scanner; // program uses scanner

/**
 * class DriverPorcherSmithUriarte uses the classes and creates the interaction
 * with the user
 */
public class DriverPorcherSmithUriarte {
    /**
     * main to execute the java application
     */
    public static void main(String[] args) {

        //Land Transportation
        Automobile AutoObject = new Automobile("Nice","Black",55,70,
                4, 36, 5, 12, 6000, "Battery", "Silicone",
                "Transportation", "Land", 4, "4 wheel drive", "Rental", "Greenville NC", "9:15am");

        Train TrainObject = new Train("Mid", "Blue", 80, 45,
                90, 1200, 9,300, 13000,"Gas",
                "Metal", "Transportation", "Land", 50, 30, "Ticket", "Charlotte NC", "8:30am");

        Bike BikeObject = new Bike("Mid", "Red", 13, 20,
                1, 3, 3,0,250, "Kinetic", "Metal",
                "Transportation", "Land", 2, 9, "Rental", "Rocky Mount NC", "11:00am");

        Bus BusObject = new Bus("High", "Yellow", 55, 9, 30, 180,
                7, 50, 15000,"Gas", "Steel",
                "Transportation", "Land", 4, 2,"Ticket", "Raleigh NC", "4:50pm");

        //Air Transportation
        Helicopter HelicopterObject = new Helicopter("High", "White", 125, 200,
                6, 91,3, 6,12000, "Gas", "Metal",
                "Transportation", 100, 6, "Ticket", "Fayetteville NC", "1:00pm");

        Plane PlaneObject = new Plane("High", "White", 220,125,
                150,450,7, 200, 25000, "Gas", "Metal",
                "Transportation", 300,true, "Ticket", "Wilmington NC", "8:00pm");

        Hot_Air_Baloon AirBalloonObject = new Hot_Air_Baloon("High", "Red", 30, 35,
                6,45, 3,2, 2500,"Propane", "Cloth",
                "Transportation", 125, "Checkered", "Ticket", "Washington NC", "5:20pm");

        Drigible DrigibleObject = new Drigible("low","Blue", 35, 60,
                50, 3000, 7, 200, 19000, "hydrogen", "polyester",
                "transportation", 200, "Rigid", "Ticket", "Fairmont NC", "11:00am");

        //Water Transportation
        Ship ShipObject = new Ship("High", "Black", 50, 175,
                300, 17000, 11, 1000, 30000, "Electric Motor", "Steel",
                "Transportation", false,true, "Salt", true, "Ticket", "Jacksonville NC", "6:00am");

        Boat BoatObject = new Boat("Mid", "Silver", 80, 25,
                9, 50, 2, 20, 4000,"Propeller", "Steel",
                "Transportation", false,true, "Salt", "Chopper-Style", true,
                "Rental", "Carolina Beach NC", "2:30pm");

        Submarine SubmarineObject = new Submarine("Low", "Navy Blue", 120, 250,
                10,300, 5, 25, 6000, "Nuclear Power", "Steel",
                "Transportation", true,true, "Salt", 500, false, 500,
                "Radar", "Ticket", "Myrtle Beach NC", "10:15am");



        //user enters which type of transportation to use
        int transType = 0;
        int modeType = 0;
        int modeType2 = 0;
        int modeType3 = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("What type of transportation would you like to use? (Land=1, Air=2, Water=3): ");
        transType = input.nextInt();
        if(transType == 1) {
            System.out.println("Land Transportation ");

            //Automobile2
            System.out.printf("%s %10s %15s %s %5s ", "Type", "Cost", "Ticket/Rental", "Speed", "Number of Passengers");

            System.out.printf("%nAutomobile%5s %10s %10.2f %8s",
                    AutoObject.getPrice(), AutoObject.getTicketOrRental(),
                    AutoObject.getSpeed(), AutoObject.getCapacityPeople());
            //System.out.print(AutoObject);

            //Train
            System.out.printf("%nTrain%10s %10s %10.2f %9s",
                    TrainObject.getPrice(), TrainObject.getTicketOrRental(),
                    TrainObject.getSpeed(), TrainObject.getCapacityPeople());
            //System.out.print(TrainObject);

            //Bike
            System.out.printf("%nBike%11s %10s %10.2f %8s",
                    BikeObject.getPrice(), BikeObject.getTicketOrRental(),
                    BikeObject.getSpeed(), BikeObject.getCapacityPeople());
            //System.out.print(BikeObject);

            //Bus
            System.out.printf("%nBus%11s %11s %10.2f %9s%n",
                    BusObject.getPrice(), BusObject.getTicketOrRental(),
                    BusObject.getSpeed(), BusObject.getCapacityPeople());
            //System.out.print(BusObject);

            //User chooses which mode of land transportation
            System.out.print("What type of mode transportation would you like to use? "
                    + "(Automobile=1 Train=2 Bike=3 Bus=4): ");
            modeType = input.nextInt();


            //This part should print the overriden string
            while(true) {
                //if user enters the number 1 it will print automobile info
                //Automobile
                if(modeType == 1) {
                    System.out.print("Automobile Information: \n");
                    System.out.print(AutoObject);
                    break;
                }
                //Train
                else if(modeType == 2) {
                    System.out.print("Train Information: \n");
		        				/*TrainObject.getQuality(), TrainObject.getColor(),
		        				TrainObject.getSpeed(), TrainObject.getPrice(),
		        				TrainObject.getCapacityPeople(), TrainObject.getSizeInFeet(),
		        				TrainObject.getAge(), TrainObject.getCapacityCargo(),
		        				TrainObject.getCapacityWeight(),
		        				TrainObject.getPowerSource(), TrainObject.getMaterialType(),
		        				TrainObject.getUsage(), TrainObject.getTerrain(),
		        				TrainObject.getNumberWheels(), TrainObject.getNumCarts(),
		        				TrainObject.getLocation(), TrainObject.getTicketOrRental());*/
                    System.out.print(TrainObject);
                    break;
                }
                //Bike
                else if(modeType == 3) {
                    System.out.print("Bike Information: \n");
		        				/*BikeObject.getQuality(), BikeObject.getColor(),
		        				BikeObject.getSpeed(), BikeObject.getPrice(),
		        				BikeObject.getCapacityPeople(), BikeObject.getSizeInFeet(),
		        				BikeObject.getAge(), BikeObject.getCapacityCargo(),
		        				BikeObject.getCapacityWeight(),
		        				BikeObject.getPowerSource(), BikeObject.getMaterialType(),
		        				BikeObject.getUsage(), BikeObject.getTerrain(),
		        				BikeObject.getNumberWheels(), BikeObject.getNumGears(),
		        				BikeObject.getLocation(), BikeObject.getTicketOrRental());*/
                    System.out.print(BikeObject);
                    break;
                }
                //Bus
                else if(modeType == 4) {
                    System.out.print("Bus Information: \n");
		        			/*	BusObject.getQuality(), BusObject.getColor(),
		        				BusObject.getSpeed(), BusObject.getPrice(),
		        				BusObject.getCapacityPeople(), BusObject.getSizeInFeet(),
		        				BusObject.getAge(), BusObject.getCapacityCargo(), BusObject.getCapacityWeight(),
		        				BusObject.getPowerSource(), BusObject.getMaterialType(),
		        				BusObject.getUsage(), BusObject.getTerrain(),
		        				BusObject.getNumberWheels(), BusObject.getNumLevels(),
		        				BusObject.getLocation(), BusObject.getTicketOrRental());*/
                    System.out.print(BusObject);
                    break;
                }
                else {
                    System.out.print("Could not find");
                    break;
                }
            }
        }
        //ending overall Land
        //overall Air
        else if(transType == 2) {
            System.out.print("Air Transportation");
            //Helicopter
            System.out.printf("%n%s %15s %15s %s %5s ", "Type", "Cost", "Ticket/Rental", "Speed", "Number of Passengers");

            System.out.printf("%nHelicopter %10s %10s %9.2f %8s",
                    HelicopterObject.getPrice(), HelicopterObject.getTicketOrRental(),
                    HelicopterObject.getSpeed(), HelicopterObject.getCapacityPeople());
            //System.out.print(HelicopterObject);

            //Plane
            System.out.printf("%nPlane %15s %10s %10.2f %7s",
                    PlaneObject.getPrice(), PlaneObject.getTicketOrRental(),
                    PlaneObject.getSpeed(), PlaneObject.getCapacityPeople());
            //System.out.print(PlaneObject);

            //Hot Air Balloon
            System.out.printf("%nHot Air Balloon%6s %10s %9.2f %8s",
                    AirBalloonObject.getPrice(), AirBalloonObject.getTicketOrRental(),
                    AirBalloonObject.getSpeed(), AirBalloonObject.getCapacityPeople());
            //System.out.print(AirBalloonObject);

            //Dirgible
            System.out.printf("%nDrigible%13s %10s %9.2f %8s%n",
                    DrigibleObject.getPrice(), DrigibleObject.getTicketOrRental(),
                    DrigibleObject.getSpeed(), DrigibleObject.getCapacityPeople());
            //System.out.print(DrigibleObject);

            //User chooses which mode of land transportation
            System.out.print("What type of mode transportation would you like to use? "
                    + "(Helicopter=1 Plane=2 Hot Air Balloon=3 Drigible=4): ");
            modeType2 = input.nextInt();

            //User chooses which mode type of Air Transportation
            while(true) {
                //Helicopter
                if(modeType2 == 1) {
                    System.out.print("Helicopter Information: ");
		        				/*HelicopterObject.getQuality(), HelicopterObject.getColor(),
		        				HelicopterObject.getSpeed(), HelicopterObject.getPrice(),
		        				HelicopterObject.getCapacityPeople(), HelicopterObject.getSizeInFeet(),
		        				HelicopterObject.getAge(), HelicopterObject.getCapacityCargo(),
		        				HelicopterObject.getCapacityWeight(),
		        				HelicopterObject.getPowerSource(), HelicopterObject.getMaterialType(),
		        				HelicopterObject.getUsage(), HelicopterObject.getAltitude(),
		        				HelicopterObject.getNumBlades(),
		        				HelicopterObject.getTicketOrRental(), HelicopterObject.getLocation());*/
                    System.out.print(HelicopterObject);
                    break;
                }
                //Plane
                else if(modeType2 == 2) {
                    System.out.print("Plane Information: \n");
		        			/*	PlaneObject.getQuality(), PlaneObject.getColor(),
		        				PlaneObject.getSpeed(), PlaneObject.getPrice(),
		        				PlaneObject.getCapacityPeople(), PlaneObject.getSizeInFeet(),
		        				PlaneObject.getAge(), PlaneObject.getCapacityCargo(),
		        				PlaneObject.getCapacityWeight(),
		        				PlaneObject.getPowerSource(), PlaneObject.getMaterialType(),
		        				PlaneObject.getUsage(), PlaneObject.getAltitude(),
		        				PlaneObject.isNeedCopilot(),
		        				PlaneObject.getLocation(), PlaneObject.getTicketOrRental());*/
                    System.out.print(PlaneObject);
                    break;
                }
                //Hot Air Balloon
                else if(modeType2 == 3) {
                    System.out.print("Hot Air Balloon Information: \n");
		        				/*AirBalloonObject.getQuality(), AirBalloonObject.getColor(),
		        				AirBalloonObject.getSpeed(), AirBalloonObject.getPrice(),
		        				AirBalloonObject.getCapacityPeople(), AirBalloonObject.getSizeInFeet(),
		        				AirBalloonObject.getAge(), AirBalloonObject.getCapacityCargo(),
		        				AirBalloonObject.getCapacityWeight(),
		        				AirBalloonObject.getPowerSource(), AirBalloonObject.getMaterialType(),
		        				AirBalloonObject.getUsage(), AirBalloonObject.getAltitude(),
		        				AirBalloonObject.getBaloonPatternDesign(),
		        				AirBalloonObject.getLocation(), AirBalloonObject.getTicketOrRental());*/
                    System.out.print(AirBalloonObject);
                    break;
                }
                //Bus
                else if(modeType2 == 4) {
                    System.out.print("Drigible Information: \n");
		        			/*	DrigibleObject.getQuality(), DrigibleObject.getColor(),
		        				DrigibleObject.getSpeed(), DrigibleObject.getPrice(),
		        				DrigibleObject.getCapacityPeople(), DrigibleObject.getSizeInFeet(),
		        				DrigibleObject.getAge(), DrigibleObject.getCapacityCargo(),
		        				DrigibleObject.getCapacityWeight(),
		        				DrigibleObject.getPowerSource(), DrigibleObject.getMaterialType(),
		        				DrigibleObject.getUsage(), DrigibleObject.getAltitude(),
		        				DrigibleObject.getFrameType(),
		        				DrigibleObject.getLocation(), DrigibleObject.getTicketOrRental());*/
                    System.out.print(DrigibleObject);
                    break;

                }
                else {
                    System.out.print("Could not find");
                    break;
                }
            }
        }
        //ending overall Air


        //overall Water
        else if(transType == 3) {
            System.out.print("Water Transportation");
            //Ship
            System.out.printf("%n%s %10s %15s %s %5s ", "Type", "Cost", "Ticket/Rental", "Speed", "Number of Passengers");

            System.out.printf("%nShip %11s %9s %13.2f %7s",
                    ShipObject.getPrice(), ShipObject.getTicketOrRental(),
                    ShipObject.getSpeed(), ShipObject.getCapacityPeople());
            //System.out.print(ShipObject);

            //Boat
            System.out.printf("%nBoat %11s %9s %13.2f %7s",
                    BoatObject.getPrice(), BoatObject.getTicketOrRental(),
                    BoatObject.getSpeed(), BoatObject.getCapacityPeople());
            //System.out.print(BoatObject);

            //Submarine
            System.out.printf("%nSubmarine%7s %9s %13.2f %7s%n",
                    SubmarineObject.getPrice(), SubmarineObject.getTicketOrRental(),
                    SubmarineObject.getSpeed(), SubmarineObject.getCapacityPeople());
            //System.out.print(SubmarineObject);

            //User chooses which mode of land transportation
            System.out.print("What type of mode transportation would you like to use? "
                    + "(Ship=1 Boat=2 Submarine=3): ");
            modeType3 = input.nextInt();

            //user chooses mode type of water transportation
            while(true) {
                //Ship
                if(modeType3 == 1) {
                    System.out.print("Ship Information: \n");
		        				/*ShipObject.getQuality(), ShipObject.getColor(),
		        				ShipObject.getSpeed(), ShipObject.getPrice(),
		        				ShipObject.getCapacityPeople(), ShipObject.getSizeInFeet(),
		        				ShipObject.getAge(), ShipObject.getCapacityCargo(),
		        				ShipObject.getCapacityWeight(),
		        				ShipObject.getPowerSource(), ShipObject.getMaterialType(),
		        				ShipObject.getUsage(), ShipObject.isSubmerged(),
		        				ShipObject.isPropeller(),
		        				ShipObject.getTypeOfWater(), ShipObject.isSail(),
		        				ShipObject.getTicketOrRental(), ShipObject.getLocation());*/
                    System.out.print(ShipObject);
                    break;
                }
                //Boat
                else if(modeType3 == 2) {
                    System.out.print("Boat Information: \n");
		        				/*BoatObject.getQuality(), BoatObject.getColor(),
		        				BoatObject.getSpeed(), BoatObject.getPrice(),
		        				BoatObject.getCapacityPeople(), BoatObject.getSizeInFeet(),
		        				BoatObject.getAge(), BoatObject.getCapacityCargo(),
		        				BoatObject.getCapacityWeight(),
		        				BoatObject.getPowerSource(), BoatObject.getMaterialType(),
		        				BoatObject.getUsage(), BoatObject.isSubmerged(),
		        				BoatObject.isPropeller(), BoatObject.getTypeOfWater(),
		        				BoatObject.getPropellerType(), BoatObject.isAvailableRoof(),
		        				BoatObject.getTicketOrRental(), BoatObject.getLocation());*/
                    System.out.print(BoatObject);
                    break;
                }
                //Submarine
                else if(modeType3 == 3) {
                    System.out.print("Submarine Information: \n");
		        				/*SubmarineObject.getQuality(), SubmarineObject.getColor(),
		        				SubmarineObject.getSpeed(), SubmarineObject.getPrice(),
		        				SubmarineObject.getCapacityPeople(), SubmarineObject.getSizeInFeet(),
		        				SubmarineObject.getAge(), SubmarineObject.getCapacityCargo(),
		        				SubmarineObject.getCapacityWeight(),
		        				SubmarineObject.getPowerSource(), SubmarineObject.getMaterialType(),
		        				SubmarineObject.getUsage(), SubmarineObject.isSubmerged(),
		        				SubmarineObject.isPropeller(), SubmarineObject.getTypeOfWater(),
		        				SubmarineObject.getDepthDistance(), SubmarineObject.isStealthCapability(),
		        				SubmarineObject.getSonarType(),
		        				SubmarineObject.getTicketOrRental(), SubmarineObject.getLocation());*/
                    System.out.print(SubmarineObject);
                    break;
                }

                else {
                    System.out.print("Could not find");
                    break;
                }
            }
        }
        //ending overall water
        //if user enters anything else
        else {
            System.out.print("Could not find");
        }



        // Switch from input of numbers above to strings
        String modeTypeString = "None"; // mode of transportation variable creation

        // Switch to specify type of transportation and then nested switch statements to get specific
        switch (transType) {
            // Land
            case 1: switch (modeType) {
                case 1:
                    modeTypeString = "Automobile";
                    break;
                case 2:
                    modeTypeString = "Train";
                    break;
                case 3:
                    modeTypeString = "Bike";
                    break;
                case 4:
                    modeTypeString = "Bus";
                    break;
            }
            break;
            // Air
            case 2: switch (modeType2) {
                case 1:
                    modeTypeString = "Helicopter";
                    break;
                case 2:
                    modeTypeString = "Plane";
                    break;
                case 3:
                    modeTypeString = "Hot Air Balloon";
                    break;
                case 4:
                    modeTypeString = "Drigible";
                    break;
            }
            break;
            // Water
            case 3: switch (modeType3) {
                case 1:
                    modeTypeString = "Ship";
                    break;
                case 2:
                    modeTypeString = "Boat";
                    break;
                case 3:
                    modeTypeString = "Submarine";
                    break;
            }
            break;
        }

        // check and verify mode of transportation
        System.out.printf("\n%s%s%s", "Is ", modeTypeString, " the correct mode of transportation you want? (Y/N)\n");
        String answer = input.next();
        // Switch to handle yes or no
        switch (answer) {
            case "Y":
                break;
            case "N": // handles if NO
                System.out.print("Input the correct mode of transportation from the list below:\n");
                System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n", "Automobile", "Train", "Bike", "Bus",
                        "Helicopter", "Plane", "Hot Air Balloon", "Drigible", "Ship", "Boat", "Submarine");
                modeTypeString = input.next();
                // array of transportations available
                String[] modeTypeArray = {"Automobile", "Train", "Bike", "Bus",
                        "Helicopter", "Plane", "Hot Air Balloon", "Drigible", "Ship", "Boat", "Submarine"};
                // loop to check if transportation typed in is an option
                while (true) {
                    // if in array break loop and continue program
                    if (Arrays.asList(modeTypeArray).contains(modeTypeString)){
                        break;
                    }
                    // Notifies user to try again if not an option
                    else{
                        System.out.print("Not an option. Try again\n");
                        System.out.print("Input the correct mode of transportation from the list below:\n");
                        System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n", "Automobile", "Train", "Bike", "Bus",
                                "Helicopter", "Plane", "Hot Air Balloon", "Drigible", "Ship", "Boat", "Submarine");
                    }
                }
        }
        // variables to be assigned things needed later after switch (initialization)
        double totalCost = 0.00;
        String location = null;
        String ticketOrRent = null;
        String time = null;
        int passengerCount = 0;
        // Switch to access and assign the variable with the data of the specific transportation selected.
        switch (modeTypeString) {
            case "Automobile" -> {
                totalCost = AutoObject.getPrice();
                location = AutoObject.getLocation();
                ticketOrRent = AutoObject.getTicketOrRental();
                time = AutoObject.getTime();
                passengerCount = AutoObject.getCapacityPeople();
            }
            case "Train" -> {
                totalCost = TrainObject.getPrice();
                location = TrainObject.getLocation();
                ticketOrRent = TrainObject.getTicketOrRental();
                time = TrainObject.getTime();
                passengerCount = TrainObject.getCapacityPeople();
            }
            case "Bike" -> {
                totalCost = BikeObject.getPrice();
                location = BikeObject.getLocation();
                ticketOrRent = BikeObject.getTicketOrRental();
                time = BikeObject.getTime();
                passengerCount = BikeObject.getCapacityPeople();
            }
            case "Bus" -> {
                totalCost = BusObject.getPrice();
                location = BusObject.getLocation();
                ticketOrRent = BusObject.getTicketOrRental();
                time = BusObject.getTime();
                passengerCount = BusObject.getCapacityPeople();
            }
            case "Helicopter" -> {
                totalCost = HelicopterObject.getPrice();
                location = HelicopterObject.getLocation();
                ticketOrRent = HelicopterObject.getTicketOrRental();
                time = HelicopterObject.getTime();
                passengerCount = HelicopterObject.getCapacityPeople();
            }
            case "Plane" -> {
                totalCost = PlaneObject.getPrice();
                location = PlaneObject.getLocation();
                ticketOrRent = PlaneObject.getTicketOrRental();
                time = PlaneObject.getTime();
                passengerCount = PlaneObject.getCapacityPeople();
            }
            case "Hot Air Balloon" -> {
                totalCost = AirBalloonObject.getPrice();
                location = AirBalloonObject.getLocation();
                ticketOrRent = AirBalloonObject.getTicketOrRental();
                time = AirBalloonObject.getTime();
                passengerCount = AirBalloonObject.getCapacityPeople();
            }
            case "Drigible" -> {
                totalCost = DrigibleObject.getPrice();
                location = DrigibleObject.getLocation();
                ticketOrRent = DrigibleObject.getTicketOrRental();
                time = DrigibleObject.getTime();
                passengerCount = DrigibleObject.getCapacityPeople();
            }
            case "Ship" -> {
                totalCost = ShipObject.getPrice();
                location = ShipObject.getLocation();
                ticketOrRent = ShipObject.getTicketOrRental();
                time = ShipObject.getTime();
                passengerCount = ShipObject.getCapacityPeople();
            }
            case "Boat" -> {
                totalCost = BoatObject.getPrice();
                location = BoatObject.getLocation();
                ticketOrRent = BoatObject.getTicketOrRental();
                time = BoatObject.getTime();
                passengerCount = BoatObject.getCapacityPeople();
            }
            case "Submarine" -> {
                totalCost = SubmarineObject.getPrice();
                location = SubmarineObject.getLocation();
                ticketOrRent = SubmarineObject.getTicketOrRental();
                time = SubmarineObject.getTime();
                passengerCount = SubmarineObject.getCapacityPeople();
            }
        }

        // gets passenger count
        System.out.print("How many passengers need to travel? Max is " + passengerCount + ".\n");
        int passengers = input.nextInt();
        // loop to verify passenger amount
        while (true) {
            // if passenger amount is below minimum
            if (passengers < 1) {
                System.out.print("Passenger capacity of 1 or more is required. Try again.\n");
                passengers = input.nextInt();
                continue;
            }
            // notifies user of exceeding the passenger limit and asks for them to try again
            if (passengers > passengerCount) {
                System.out.print("Exceeding passenger capacity of " + passengerCount +  ". Try again.\n");
                passengers = input.nextInt();
                continue;
            }
            break; // leave loop
        }
        // displays total cost
        System.out.printf("%s$%.2f%n", "Total cost will be ", totalCost*passengers);
        // displays where, when, and what
        System.out.printf("%s%s%s%s%s%s%n", "Your ", ticketOrRent, " is located at ", location, " for ", time);

    }






} // end
