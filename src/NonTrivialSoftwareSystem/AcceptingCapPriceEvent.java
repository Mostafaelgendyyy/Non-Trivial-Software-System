package NonTrivialSoftwareSystem;

import java.util.Date;

public class AcceptingCapPriceEvent extends Event{
    String Cust_name;
    public AcceptingCapPriceEvent(Date etime,String cus)
    {
        super("User accepts the captain price",etime);
        this.Cust_name = cus;
    }

    @Override
    public String ShowEvent() {
        return ("Event Name: "+ super.getEventname() + " Event Time: "+super.getEventtime()+ "Customer Name: "+this.Cust_name);
    }
}
