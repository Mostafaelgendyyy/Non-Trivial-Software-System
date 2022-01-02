package NonTrivialSoftwareSystem;
import DataBase.DataRide;
import DataBase.DiscountArea;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class CustomerRideActions {
   public void requestaAride(String source, String destination , Customer c, DataRide dr, DiscountArea ar) {
        Date cur = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(cur);
        LocalDate currentDate = LocalDate.parse(strDate);

        int daycur = currentDate.getDayOfMonth();

        Month monthcur = currentDate.getMonth();
        
        LocalDate birthdate = LocalDate.parse(c.getBirthday());

        int daybirth = birthdate.getDayOfMonth();

        Month monthbirth = birthdate.getMonth();
       
        Date x = new Date();
        String dayWeekText = new SimpleDateFormat("EEEE").format(x);

        if ( c.getCustomerRide().getRide()==null ||c.getCustomerRide().getRide().getRideControl().getrate()==true)
        {
            c.getCustomerRide().setRide(new Ride(source, destination, c));
            if (!dr.hasFirstRide(c))
            {
                //c.getCustomerRide().getRide().DefineDiscount("FirstRide");
                c.getCustomerRide().getRide().setDisType("FirstRide");
            }
            else if (ar.searcharea( c.getCustomerRide().getRide().getSource()))
            {
                //c.getCustomerRide().getRide().DefineDiscount("DiscountSpecificArea");
                c.getCustomerRide().getRide().setDisType("DiscountSpecificArea");
            }
            else if (daycur==daybirth && monthcur==monthbirth)
            {
                //c.getCustomerRide().getRide().DefineDiscount("BirthDate");
                c.getCustomerRide().getRide().setDisType("BirthDate");

            }
            else if (c.getCustomerRide().getRide().isAcceptother()|| c.getCustomerRide().getRide().getRideControl().getDriver().isCanaccept())
            {
                //c.getCustomerRide().getRide().DefineDiscount("DiscountPassenger");
                c.getCustomerRide().getRide().setDisType("DiscountPassenger");
            }

            else if (dayWeekText.equalsIgnoreCase("friday") || dayWeekText.equalsIgnoreCase("saturday"))
            {
                c.getCustomerRide().getRide().setDisType("HolidayRide");
            }
            else
            {
                //c.getCustomerRide().getRide().DefineDiscount("NoDiscount");
                c.getCustomerRide().getRide().setDisType("NoDiscount");
            }
            System.out.println("Ride was Successfully requested.");
            System.out.println("");
        }
        else {
            System.out.println("You are often on a ride or booked a ride");

        }
    }

    public void showRideInfo(Customer c) {
        System.out.println(c.getCustomerRide().getRide().printRideInfo());
    }

    public void seenotificationonride(Customer c)
    {
        if (c.getCustomerRide().getRide()==null || c.getCustomerRide().getRide().getSuggestedDrivers().getSuggesteddriver().size()==0)
        {
            System.out.println("There is no notification.");
            System.out.println();
        }
        else {
            c.getCustomerRide().getRide().getSuggestedDrivers().returnsuggesteddrivers();
        }
    }

    public void choosedriver(Customer c, Admin x) {
        this.seenotificationonride(c);
        if (c.getCustomerRide().getRide() ==null || c.getCustomerRide().getRide().getSuggestedDrivers().getSuggesteddriver().size()==0)
        {
            return;
        }
        System.out.print("Choose the name of Driver you want: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();

        for (Map.Entry me : c.getCustomerRide().getRide().getSuggestedDrivers().getSuggesteddriver().entrySet() )
        {
            Driver d= (Driver) me.getKey();
            if (d.getUserName().equals(name) && d.isAvailable()==true)
            {
                c.getCustomerRide().getRide().getRideControl().setDriver(d);
                if (!c.getCustomerRide().getRide().isAcceptother())
                {
                    d.setAvailable(false);
                }
                else {
                    d.setAvailable(true);
                }
                c.getCustomerRide().getRide().getRideControl().getDriver().getDriverRide().setCurrentRide(c.getCustomerRide().getRide());
                Event e = new AcceptingCapPriceEvent(new Date(),c.getUserName());
                c.getCustomerRide().getRide().getRideEvents().AddEvent(e);
                x.AddNoti(e.ShowEvent());
                Event s = new LocationEvent(new Date(), d.getUserName(),c.getUserName());
                c.getCustomerRide().getRide().getRideEvents().AddEvent(s);
                x.AddNoti(s.ShowEvent());
                if (c.getCustomerRide().getRide().isAcceptother())
                {
                    c.getCustomerRide().getRide().getRideControl().getDriver().setSource(c.getCustomerRide().getRide().getSource());
                    c.getCustomerRide().getRide().getRideControl().getDriver().setCanaccept(true);
                }
                System.out.println("Done!");
                System.out.println("");
                c.getCustomerRide().getRide().getSuggestedDrivers().getSuggesteddriver().clear();
                d.setBalance(c.getCustomerRide().getRide().getPrice());
                Event w = new DestinationEvent(new Date(), d.getUserName(),c.getUserName());
                c.getCustomerRide().getRide().getRideEvents().AddEvent(w);
                x.AddNoti(w.ShowEvent());
                return;
            }
            else if (d.getUserName().equals(name))
            {
                System.out.println("This Driver was in a ride or Unavailable.");
                System.out.println("Please delete the ride and make another one");
                System.out.println("");
                c.getCustomerRide().getRide().getSuggestedDrivers().getSuggesteddriver().remove(d);
            }
        }
    }

    public void deleteride(Customer c, DataRide r){
        if (c.getCustomerRide().getRide()==null)
        {
            System.out.println("You don't have any ride to delete.");
            return;
        }
        else if (c.getCustomerRide().getRide().getRideControl().getDriver()==null || (c.getCustomerRide().getRide().getRideControl().getrate()==true))
        {
            System.out.println("The Ride was Deleted.");
            r.DeleteRide(c.getCustomerRide().getRide());
            c.getCustomerRide().setRide(null);
            return;
        }
        System.out.println("You Can't delete this Ride.");
    }
}
