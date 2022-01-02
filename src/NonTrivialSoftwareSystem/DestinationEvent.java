package NonTrivialSoftwareSystem;

import java.util.Date;

public class DestinationEvent extends RouteEvent{
    public DestinationEvent(Date eventtime, String cap, String cust) {
        super("Captain arrived to user destination", eventtime, cap, cust);
    }

    @Override
    public String  ShowEvent() {
        return ("Event Name: " + this.getEventname() + "Event Time: " + this.getEventtime() + "Customer Name: " + this.getCustomer_name() + "Captain Name: " + this.getCaptain_name());
    }
}
