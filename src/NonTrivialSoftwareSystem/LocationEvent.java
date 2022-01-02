package NonTrivialSoftwareSystem;

import java.util.Date;

public class LocationEvent extends RouteEvent {
    public LocationEvent(Date eventtime, String cap, String cust) {
        super("Captain arrived to user location", eventtime, cap, cust);
    }

    @Override
    public String  ShowEvent() {
       return ("Event Name: " + this.getEventname() + "Event Time: " + this.getEventtime() + "Customer Name: " + this.getCustomer_name() + "Captain Name: " + this.getCaptain_name());
    }
}
