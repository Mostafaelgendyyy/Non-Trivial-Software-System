package NonTrivialSoftwareSystem;
////////////////////////////////
public class CustomerRideRating {

    public void rateRide(int rate,Customer c) {

        if (c.getCustomerRide().getRide().getRideControl().getrate()==true)
        {
            System.out.println("You rated this ride before.");
            System.out.println("");
        }
        else
        {
            c.getCustomerRide().getRide().getRideControl().setRateDriver(rate);
            System.out.println("Done!");
            System.out.println("");
        }
    }


}
