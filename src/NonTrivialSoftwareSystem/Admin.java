package NonTrivialSoftwareSystem;

import DataBase.*;
import java.util.LinkedList;

//
public class Admin extends User {
    private LinkedList<String> ridesEvents = new LinkedList<String>();

    public Admin(String userName, String mobileNum, String email, String passWord) {
        super(userName, mobileNum, email, passWord);
    }

    //
    public void See() {
        if (ridesEvents.size() == 0) {
            System.out.println("There is No Events Done!");
            return;
        }
        for (String s : ridesEvents) {
            System.out.println(s);
        }
        ridesEvents.clear();
    }

    public void AddNoti(String e) {
        ridesEvents.add(e);
    }

    public void suspendcustomer(String customer, DataCustomer data) {
        data.suspendCustomer(customer);
    }

    public void suspenddriver(String driver, DataDriver data) {
        data.SuspendDriver(driver);
    }

    public void verifysuspendeddriver(String driver, DataDriver data) {
        data.verifysuspended(driver);
    }

    public void verifypendingdriver(DataDriver data) {
        data.verifypenders();
    }
}