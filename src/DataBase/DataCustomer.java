package DataBase;

import NonTrivialSoftwareSystem.Customer;

import java.util.LinkedList;

public class DataCustomer { //
    private LinkedList<Customer> Customers = new LinkedList<Customer>();
    static DataCustomer customer= new DataCustomer();
    private DataCustomer () {

    }
    public static DataCustomer getDataCustomer()
    {
        return customer;
    }
    public void addCustomer(Customer cust)
    {
        Customers.add(cust);
    }

    public boolean searchCustomer(String usN, String password)
    {
        for(int i = 0 ; i <Customers.size();i++)
        {
            if(Customers.get(i).getUserName().equals(usN)&& Customers.get(i).getPassWord().equals(password))
            {
                return true;
            }
        }
        return false;
    }
    public Customer search(String usN)
    {
        for(int i = 0 ; i <Customers.size();i++)
        {
            if(Customers.get(i).getUserName().equals(usN))
            {
                return Customers.get(i);
            }
        }
        return null;
    }
    public boolean checkCustomername(String usN)
    {
        for(int i = 0 ; i <Customers.size();i++)
        {
            if(Customers.get(i).getUserName().equals(usN))
            {
                return true;
            }
        }
        return false;
    }
    public void suspendCustomer(String CustomerName)
    {
        for(int i = 0 ; i<Customers.size();i++){
            if(Customers.get(i).getUserName().equals(CustomerName))
            {
                System.out.println("Customer "+ CustomerName + " Was Deleted Successfully.");
                System.out.println("");
                Customers.remove(i);
                return;
            }
        }
        System.out.println("Customer " + CustomerName + " Was not found in the System.");
        System.out.println("");
    }
}
