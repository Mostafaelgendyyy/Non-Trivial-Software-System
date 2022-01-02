package NonTrivialSoftwareSystem;

import java.util.Date;

public class PuttingPricetoRideEvent extends Event {
    double price;
    String Captainname;

    public PuttingPricetoRideEvent( Date eventtime, double price, String captainname) {
        super("Captain put a price to the ride", eventtime);
        this.price = price;
        Captainname = captainname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCaptainname() {
        return Captainname;
    }

    public void setCaptainname(String captainname) {
        Captainname = captainname;
    }

    @Override
    public String  ShowEvent() {
        return ("Event Name: "+ super.getEventname() + " Event Time: "+super.getEventtime()+ "Captain Name: "+this.Captainname + "Price: "+ this.price);
    }
}
