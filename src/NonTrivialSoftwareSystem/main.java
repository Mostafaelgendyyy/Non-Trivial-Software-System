package NonTrivialSoftwareSystem;

import DataBase.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

//
public class main {
    static Admin x = new Admin("admin", "01178", "a1@gmail.com", "124563");

    public static void signup() throws ParseException {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("1-SignUp as Customer.");
            System.out.println("2-SignUp as Driver.");
            System.out.println("3-Exit");
            int choice2 = input.nextInt();
            if (choice2 == 1) {
                System.out.print("*Enter Your E-mail: ");
                String em = input.next();
                System.out.print("*Enter Your Mobile Number: ");
                String mobile = input.next();
                System.out.print("*Enter Your password: ");
                String pass = input.next();
                System.out.print("*Confirm Your password: ");
                String pass2 = input.next();
                if (!pass.equals(pass2)) {
                    while (true) {
                        System.out.println("Not Match");
                        System.out.print("Enter Your password again: ");
                        pass = input.next();
                        System.out.print("Confirm Your password: ");
                        pass2 = input.next();
                        if (pass.equals(pass2)) {
                            break;
                        }
                    }
                }
                System.out.print("*Enter Your Username: ");
                String name = input.next();
                if (dataCustomer.checkCustomername(name)) {
                    while (true) {
                        System.out.println("This Username was taken");
                        System.out.print("Enter another Username: ");
                        name = input.next();
                        if (!dataCustomer.checkCustomername(name)) {
                            break;
                        }
                    }
                }
                System.out.print("*Enter Your BirthDate: in format \"year-month-day\"");
                String date = input.next();
                Customer customer = new Customer(name, mobile, em, pass, date);
                dataCustomer.addCustomer(customer);
                break;
            } else if (choice2 == 2) {
                System.out.print("*Enter Your E-mail: ");
                String em = input.next();
                System.out.print("*Enter Your Mobile Number: ");
                String mobile = input.next();
                System.out.print("*Enter Your password: ");
                String pass = input.next();
                System.out.print("*Confirm Your password: ");
                String pass2 = input.next();
                if (!pass.equals(pass2)) {
                    while (true) {
                        System.out.println("Not Match");
                        System.out.print("Enter Your password again: ");
                        pass = input.next();
                        System.out.print("Confirm Your password: ");
                        pass2 = input.next();
                        if (pass.equals(pass2)) {
                            break;
                        }
                    }
                }
                System.out.print("*Enter Your Username: ");
                String name = input.next();
                if (dataDriver.checkdrivername(name)) {
                    while (true) {
                        System.out.println("This Username was taken");
                        System.out.print("Enter another Username: ");
                        name = input.next();
                        if (!dataDriver.checkdrivername(name)) {
                            break;
                        }
                    }
                }
                System.out.print("*Enter Your License: ");
                String li = input.next();
                System.out.print("*Enter Your National ID: ");
                String nid = input.next();
                Driver driver = new Driver(name, mobile, em, pass, li, nid);
                dataDriver.addpenders(driver);
                break;
            }
            if (choice2 == 3) {
                break;
            } else {
                System.out.println("Please Enter Right Choice");
            }
        }
    }

    public static void login() {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("1-Login as Admin.");
            System.out.println("2-Login as Customer.");
            System.out.println("3-Login as Driver.");
            System.out.println("4-Exit");
            int choice2 = input.nextInt();
            if (choice2 == 1) // login as admin
            {

                System.out.println("Enter Username:");
                String name = input.next();
                System.out.println("Enter password:");
                String pass = input.next();

                if (dataAdmin.searchAdmin(name, pass)) {
                    while (true) {
                        System.out.println("1-Delete Customer.");
                        System.out.println("2-Suspend Driver.");
                        System.out.println("3-Verify pending Drivers.");
                        System.out.println("4-Verify Suspended Drivers.");
                        System.out.println("5-Show Events Notifications");
                        System.out.println("6-Logout");
                        int choice = input.nextInt();
                        if (choice == 1) {
                            System.out.print("Enter username: ");
                            String n = input.next();
                            dataCustomer.suspendCustomer(n);
                        } else if (choice == 2) {
                            System.out.print("Enter username: ");
                            String n = input.next();
                            dataDriver.SuspendDriver(n);
                        } else if (choice == 3) {
                            dataDriver.verifypenders();
                        } else if (choice == 4) {
                            System.out.print("Enter username: ");
                            String n = input.next();
                            dataDriver.verifysuspended(n);
                        } else if (choice == 5) {
                            x.See();
                        } else if (choice == 6) {
                            break;
                        } else {
                            System.out.println("Please Choose Right Choice.");
                        }
                    }
                } else {
                    System.out.println("Invalid Login");
                }

            } else if (choice2 == 2) // login as Customer
            {
                System.out.println("Enter Username:");
                String name = input.next();
                System.out.println("Enter password:");
                String pass = input.next();
                if (dataCustomer.searchCustomer(name, pass)) {
                    Customer cust = dataCustomer.search(name);
                    while (true) {
                        System.out.println("1-Request a ride.");
                        System.out.println("2-See notifications.");
                        System.out.println("3-Choose Driver for the Ride");
                        System.out.println("4-Rate Driver of the ride.");
                        System.out.println("5-Show Driver's info of your current ride.");
                        System.out.println("6-Delete ride");
                        System.out.println("7-LogOut");
                        int choice = input.nextInt();
                        if (choice == 1) {
                            System.out.println("*Enter Source of the ride: ");
                            String s = input.next();
                            System.out.println("*Enter Destination of the ride: ");
                            String d = input.next();
                            cust.getRideActions().requestaAride(s, d, cust, dataRide, discountArea);
                            Ride ride = cust.getCustomerRide().getRide();
                            dataRide.AddRide(ride);
                            ride.getSuggestedDrivers().searchDriverForRide(dataDriver, ride);
                        } else if (choice == 2) {
                            cust.getRideActions().seenotificationonride(cust);
                        } else if (choice == 3) {
                            cust.getRideActions().choosedriver(cust, x);
                        } else if (choice == 4) {
                            if (cust.getCustomerRide().getRide() == null) {
                                System.out.println("There is no ride to rate driver.");
                                System.out.println("");
                                return;
                            }
                            System.out.print("*Enter the Rate of driver: ");
                            int rate = input.nextInt();
                            cust.getRideRating().rateRide(rate, cust);
                        } else if (choice == 5) {
                            if (cust.getCustomerRide().getRide() == null
                                    || cust.getCustomerRide().getRide().getRideControl().getDriver() == null) {
                                System.out.println("Sorry,There is no driver to get his data.");
                            } else {
                                cust.getCustomerRide().getRide().printRideInfo();
                            }
                        } else if (choice == 6) {
                            cust.getRideActions().deleteride(cust, dataRide);
                        } else if (choice == 7) {
                            break;
                        } else {
                            System.out.println("Please Choose Right Choice.");
                        }
                    }
                } else {
                    System.out.println("Invalid Login");
                }
            } else if (choice2 == 3) {
                System.out.println("Enter Username:");
                String name = input.next();
                System.out.println("Enter password:");
                String pass = input.next();
                if (dataDriver.searchDriver(name, pass)) {
                    Driver driver = dataDriver.searchd(name);
                    while (true) {
                        System.out.println("1-Show User Ratings.");
                        System.out.println("2-See notifications.");
                        System.out.println("3-Suggest price for the Ride.");
                        System.out.println("4-Add Place to Favorites.");
                        System.out.println("5-Places in Favorites.");
                        System.out.println("6-Remove Place from Favorites.");
                        System.out.println("7-Enable Availability.");
                        System.out.println("8-Disable Availability.");
                        System.out.println("9-LogOut");
                        int choice = input.nextInt();
                        if (choice == 1) {
                            driver.getRatingsInfo().viewratings();
                        } else if (choice == 2) {
                            driver.getDriverRequests().viewnotification();
                        } else if (choice == 3) {
                            driver.getDriverRequests().checkrequest(driver, x);
                        } else if (choice == 4) {
                            System.out.print("Enter the Area's name: ");
                            String n = input.next();
                            driver.getFavs().addFavarea(n);
                        } else if (choice == 5) {
                            driver.getFavs().printFavarea();
                        } else if (choice == 6) {
                            if (driver.getFavs().getsize() == 0) {
                                System.out.println("There is no area to remove.");
                                System.out.println("");
                                return;
                            }
                            driver.getFavs().printFavarea();
                            System.out.print("Enter the Area's name: ");
                            String n = input.next();
                            driver.getFavs().deleteFavaArea(n);
                        } else if (choice == 7) {
                            driver.setAvailable(true);
                            System.out.println("Your Availability becomes True.");
                            System.out.println();

                        } else if (choice == 8) {
                            driver.setAvailable(false);
                            System.out.println("Your Availability becomes False.");
                            System.out.println();
                        } else if (choice == 9) {
                            break;
                        } else {
                            System.out.println("Please Choose Right Choice.");
                        }
                    }
                } else {
                    System.out.println("Invalid Login");
                }
            } else if (choice2 == 4) {
                break;
            } else {

            }
        }
    }

    static DataAdmin dataAdmin = DataAdmin.getAllData();
    static DataDriver dataDriver = DataDriver.getDataDriver();
    static DataCustomer dataCustomer = DataCustomer.getDataCustomer();
    static DataRide dataRide = DataRide.getRid();
    static DiscountArea discountArea = DiscountArea.getDiscountArea();

    public static void main(String[] args) throws ParseException {
        Admin x = new Admin("admin", "01178", "a1@gmail.com", "124563");
        dataAdmin.addadmin(x);
        Customer z = new Customer("mostafa", "454", "jkjkjk", "789", "2001-04-21");
        Driver zd = new Driver("farida", "454", "jkjkjk", "789", "jk", "30104212102878");
        Customer d = new Customer("ka", "kn", "ihi", "123", "2012-1-2");
        dataCustomer.addCustomer(d);
        dataCustomer.addCustomer(z);
        dataDriver.addpenders(zd);
        System.out.println("Welcome to Online Transportation System.");
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("1-Login");
            System.out.println("2-SignUp");
            System.out.println("3-Exit");
            int c = input.nextInt();
            if (c == 1) {
                login();
            } else if (c == 2) {
                signup();
            } else if (c == 3) {
                break;
            } else {
                System.out.println("Please Enter Right Choice");
            }
        }
    }
}
/*
 * Driver d= new Driver("akm","kn","ihi","123","k","30104212102878");
 * alldata.addpenders(d);
 * Customer zd= new Customer("ka","kn","ihi","123");
 * alldata.addCustomer(zd);
 */