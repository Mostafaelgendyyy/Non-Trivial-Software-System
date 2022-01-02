package NonTrivialSoftwareSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

//
public class Customer extends User {

    private CustomerRide customerRide = new CustomerRide();
    private CustomerRideRating rideRating = new CustomerRideRating();
    private CustomerRideActions rideActions = new CustomerRideActions();
    private String Birthday = "";

    public Customer(String userName, String mobileNum, String email, String passWord, String date)
            throws ParseException {
        super(userName, mobileNum, email, passWord);
        this.Birthday = date;

    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public CustomerRide getCustomerRide() {
        return customerRide;
    }

    public CustomerRideActions getRideActions() {
        return rideActions;
    }

    public CustomerRideRating getRideRating() {
        return rideRating;
    }

}
