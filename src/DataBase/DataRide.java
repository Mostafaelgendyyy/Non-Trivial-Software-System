package DataBase;

import NonTrivialSoftwareSystem.Customer;
import NonTrivialSoftwareSystem.Ride;

import java.util.LinkedList;

public class DataRide {
    private LinkedList<Ride> rides= new LinkedList<Ride>();
    private static DataRide rid = new DataRide();
    private DataRide()
    {}

    public LinkedList<Ride> getRides() {
        return rides;
    }

    public static DataRide getRid() {
        return rid;
    }

    public void AddRide(Ride r)
    {
        rides.add(r);
    }
    public Ride searchrides(Ride r)
    {
        for (Ride ri : rides)
        {
            if(r.getId()== ri.getId())
            {
                return ri;
            }
        }
        return null;
    }
    public void DeleteRide(Ride r)
    {
        if (rides.size()==0)
        {
            return;
        }
        for (Ride ride : rides)
        {
            if (ride.getId()==r.getId())
            {
                rides.remove(r);
            }
        }
    }
    public Boolean hasFirstRide(Customer c)
    {
        for (Ride ri : rides)
        {
            if(ri.getRideControl().getCust()== c)
            {
                return true;
            }
        }
        return false;
    }
}
