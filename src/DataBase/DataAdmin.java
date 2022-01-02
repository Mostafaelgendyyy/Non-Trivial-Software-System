package DataBase;
import NonTrivialSoftwareSystem.*;
import java.util.LinkedList;
//
public class DataAdmin {
    private LinkedList<Admin> admins = new LinkedList<Admin>();

    private static DataAdmin DataBase = new DataAdmin();
    private DataAdmin()
    {

    }
    public static DataAdmin getAllData ()
    {
        return DataBase;
    }

    public boolean searchAdmin(String usN, String password)
    {
        for(int i = 0 ; i <admins.size();i++)
        {
            if(admins.get(i).getUserName().equals(usN) &&admins.get(i).getPassWord().equals(password))
            {
                return true;
            }
        }
        return false;
    }

    ////////////////////////////////////////////////////////

    public void addadmin(Admin x) {
        admins.add(x);
    }
}