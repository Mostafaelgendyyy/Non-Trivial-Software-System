package NonTrivialSoftwareSystem;

public class RideControl {
    private Customer cust;
    private Driver driver;
    private int rateDriver;
    private Boolean rated=false;


    boolean getrate (){return rated;}
    public int getRateDriver() {
        return rateDriver;
    }

    public void setRateDriver(int rateDriver) {
        if (rateDriver <=5 && rateDriver>=1)
        {
            this.rateDriver= rateDriver;
            driver.getRatingsInfo().addratebycust(driver);
            this.rated=true;
        }
        else {
            System.out.println("The rate is from 1 to 5 only");
        }
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    public Driver getDriver() {
        return driver;
    }

    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }
}
