package DataBase;

import NonTrivialSoftwareSystem.Discount;

import java.util.LinkedList;

public class DiscountArea {
    LinkedList<String> Area= new LinkedList<String>();
    private static DiscountArea areas = new DiscountArea();
    private DiscountArea(){}
    public static DiscountArea getDiscountArea()
    {
        return areas;
    }
    public void addArea(String x)
    {
        Area.add(x);
    }
    public void DeleteArea(String x)
    {
        for (String y : Area)
        {
            if (x.equalsIgnoreCase(y))
            {
                Area.remove(x);
                return;
            }
        }
    }
    public boolean searcharea(String x)
    {
        for (String y : Area)
        {
            if (x.equalsIgnoreCase(y))
            {
                return true;
            }
        }
        return false;
    }

}
