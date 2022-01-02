package NonTrivialSoftwareSystem;
import DataBase.DataAdmin;
import DataBase.DataDriver;

import java.util.HashMap;
import java.util.Map;

public class RideSuggestedDrivers {

    private HashMap<Driver, Double> suggesteddriver= new HashMap<Driver, Double>();
    public void addsuggesteddriver(Driver d, double p)
    {
        suggesteddriver.put(d,p);
    }

    public void returnsuggesteddrivers()  {
        for (Map.Entry me : suggesteddriver.entrySet())
        {
            Driver d= (Driver) me.getKey();
            System.out.print(d.printDriverInfo());
            System.out.println("Offer price:" + me.getValue());
            System.out.println("");
        }
    }

    public HashMap<Driver, Double> getSuggesteddriver() {
        return suggesteddriver;
    }
    public void searchDriverForRide(DataDriver ob, Ride r) {
        ob.searchavailable(r);
    }
}
