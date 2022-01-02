package NonTrivialSoftwareSystem;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class DriverRequests {
    private LinkedList<Ride> requests = new LinkedList<Ride>();


    public void viewnotification()
    {
        if (requests.size()==0)
        {
            System.out.println("There is no notification.");
            System.out.println("");
            return;
        }
        for (int i = 0; i < requests.size(); i++) {
            System.out.println((i + 1) +" Source: "+ requests.get(i).getSource()+ " Destination: "+ requests.get(i).getDestination());
        }
    }

    public LinkedList<Ride> getRequests() {
        return requests;
    }

    public void checkrequest(Driver d, Admin a)
    {
        this.viewnotification();
        if (requests.size()==0)
        {
            return;
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of the ride you want to suggest price");
        int i = input.nextInt();
        System.out.print("Enter price for ride #"+ (i) + ": ");
        double price = input.nextDouble();
        requests.get(i-1).setPrice(price);
        double p = requests.get(i-1).DefineDiscount(requests.get(i-1).getDisType());
        requests.get(i-1).getSuggestedDrivers().addsuggesteddriver(d,p);
        Event e = new PuttingPricetoRideEvent(new Date(),price,d.getUserName());
        requests.get(i-1).getRideEvents().AddEvent(e);
        a.AddNoti(e.ShowEvent());
        requests.remove(i-1);
    }


}
