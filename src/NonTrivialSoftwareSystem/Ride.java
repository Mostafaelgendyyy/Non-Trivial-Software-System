package NonTrivialSoftwareSystem;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ride {
    private static int count=1;
    private int id ;
    private String source;
    private String destination;
    private double price;
    private double PriceDis;
    private RideSuggestedDrivers suggestedDrivers= new RideSuggestedDrivers();
    private RideControl rideControl = new RideControl();
    private RideEvents rideEvents = new RideEvents();
    private Discount discount;
    private String DisType;
    private boolean acceptother= false;

    public Ride(String source, String des, Customer cu) {
        this.source = source;
        this.destination = des;
        this.rideControl.setCust(cu);
        this.id = count;
        ++count;
        this.canAccept();
    }
    public void canAccept() {
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("Do you want to share your Ride with another Passenger? ");
            System.out.println("1-Yes ");
            System.out.println("2-No");

            int n = input.nextInt();
            if (n == 1) {
                acceptother = true;
                break;
            } else if (n == 2) {
                acceptother = false;
                break;
            } else {
                System.out.println("Wrong output, Try again");
            }
        }
    }

    public boolean isAcceptother() {
        return acceptother;
    }

    public double getPrice() {
        return price;
    }

    public double getPriceDis() {
        return PriceDis;
    }

    public String getDisType() {
        return DisType;
    }

    public void setDisType(String disType) {
        DisType = disType;
    }

    public Discount getDiscount() {
        return discount;
    }
    public double DefineDiscount(String type)
    {
        if (type.equalsIgnoreCase("BirthDate"))
        {
            discount= new DiscountBirthdate();
            this.PriceDis = discount.calPrice(price);
            this.price=PriceDis;
        }
        else if (type.equalsIgnoreCase("FirstRide"))
        {
            discount= new FirstRideDiscount();
            this.PriceDis = discount.calPrice(price);
            this.price=PriceDis;
        }
        else if (type.equalsIgnoreCase("NoDiscount"))
        {
            discount= new NoDiscount();
            this.PriceDis = discount.calPrice(price);
        }
        else if (type.equalsIgnoreCase("DiscountPassenger"))
        {
            discount= new DiscountPassenger();
            this.PriceDis = discount.calPrice(price);
            this.price=PriceDis;
        }
        else if (type.equalsIgnoreCase("DiscountSpecificArea"))
        {
            discount= new DiscountSpecificArea();
            this.PriceDis= discount.calPrice(price);
        }
        else if (type.equalsIgnoreCase("HolidayRide"))
        {
                discount= new HolidayDiscount();
                this.PriceDis = discount.calPrice(price);
                this.price=PriceDis;

        }
        return this.PriceDis;
    }


    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public RideEvents getRideEvents() {
        return rideEvents;
    }

    public int getId() {
        return id;
    }

    public RideSuggestedDrivers getSuggestedDrivers() {
        return suggestedDrivers;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public RideControl getRideControl() {
        return rideControl;
    }

    public String printRideInfo() {

        return this.rideControl.getDriver().printDriverInfo() + ("price:" + this.PriceDis);
    }

    public void setPrice(double price) {
        this.price = price;
    }



}