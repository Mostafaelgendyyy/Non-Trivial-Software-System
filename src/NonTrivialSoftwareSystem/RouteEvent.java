package NonTrivialSoftwareSystem;

import java.util.Date;

public abstract class RouteEvent extends Event {
    String Customer_name;
    String Captain_name;

    public RouteEvent(String eventname, Date eventtime , String cap, String cust) {
        super(eventname, eventtime);
        this.Captain_name= cap;
        this.Customer_name=cust;
    }

    public String getCustomer_name() {
        return Customer_name;
    }

    public void setCustomer_name(String customer_name) {
        Customer_name = customer_name;
    }

    public String getCaptain_name() {
        return Captain_name;
    }

    public void setCaptain_name(String captain_name) {
        Captain_name = captain_name;
    }
}
