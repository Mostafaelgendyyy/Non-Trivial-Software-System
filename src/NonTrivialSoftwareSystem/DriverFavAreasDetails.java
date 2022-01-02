package NonTrivialSoftwareSystem;

import java.util.LinkedList;

public class DriverFavAreasDetails {
    private LinkedList<String> favareas = new LinkedList<String>();

    public void addFavarea(String area) {
        favareas.add(area);
        System.out.println(area+ " is added to Favorite Areas.");
        System.out.println();
        // Collections.sort(favareas);
    }

    public boolean SearchFavarea(String ridesource) {
        for (String A : favareas) {
            if (ridesource.equalsIgnoreCase(A)) {
                //this.getRequests.getRequests().add(ride);
                return true;
            }
        }
        return false;
    }

    public void deleteFavaArea(String area) {
        if (favareas.size()==0)
        {
            return;
        }
        for (String a : favareas) {
            if (a.equalsIgnoreCase(area)) {
                favareas.remove(a);
                System.out.println(area+ " is deleted from Favorite Areas.");
                System.out.println();
                return;
            }
        }
        System.out.println(area+ " isn't found in Favorite Areas.");
        System.out.println();
    }

    public void printFavarea() {
        if (favareas.size()==0)
        {
            System.out.println("There is no Area to Show.");
            return;
        }
        for (String A : favareas) {
            System.out.println("Place: "+A);
        }
    }

    public int getsize()
    {
        return favareas.size();
    }

}
