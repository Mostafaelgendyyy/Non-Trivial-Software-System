package NonTrivialSoftwareSystem;
import java.util.*;


public class Driver extends User {
    private String Licence="";
    private String nID="";
    private boolean permission;
    private boolean available;
    private DriverRequests requests= new DriverRequests();
    private DriverFavAreasDetails favs= new DriverFavAreasDetails();
    private DriverRatingsInfo ratingsInfo =new DriverRatingsInfo();
    private DriverRide driverRide = new DriverRide();
    private boolean canaccept= false;
    private String source="";
    private double balance;

    public boolean isCanaccept() {
        return canaccept;
    }

    public void setCanaccept(boolean canaccept) {
        this.canaccept = canaccept;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Driver(String userName, String mobileNum, String email, String passWord, String licence, String nID) {
        super(userName, mobileNum, email, passWord);
        this.Licence = licence;
        this.nID = nID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance += balance;
    }

    public DriverRide getDriverRide() {
        return driverRide;
    }

    public boolean isPermission() {
        return permission;
    }

    public DriverRequests getRequests() {
        return requests;
    }

    public DriverRatingsInfo getRatingsInfo() {
        return ratingsInfo;
    }

    public DriverRequests getDriverRequests() {
        return requests;
    }

    public DriverFavAreasDetails getFavs() {
        return favs;
    }

    public String getLicence() {
        return Licence;
    }

    public void setLicence(String licence) {
        Licence = licence;
    }

    public String getnID() { 
        return nID;
    }

    public void setnID(String nID) {
        this.nID = nID;
    }

    public boolean Permission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String printDriverInfo() {
        return "Name:" + this.getUserName() + "\n" + "Mobile:" + this.getMobileNum() + "\n" + "E-mail:" + this.getEmail() + "\n" + "avrage Rate:" + this.ratingsInfo.getAvgrate()+ "\n";
    }

//    @Override
//    public void add(Observer ob) {
//        observers.add(ob);
//    }
//
//    @Override
//    public void notify_any() {
//        this.getDriverRequests().viewnotification();
//        Scanner input = new Scanner(System.in);
//        System.out.println("Enter the number of the ride you want to suggest price");
//        int i = input.nextInt();
//        System.out.print("Enter price for ride #"+ (i) + ": ");
//        double price = input.nextDouble();
//        observers.get(i-1).Update( "Price : "+price +"\n"+ printDriverInfo());
//    }
}