package NonTrivialSoftwareSystem;

import java.util.HashMap;
import java.util.Map;

//
public class DriverRatingsInfo {
    private HashMap<String, Integer> rating = new HashMap<String, Integer>();
    private double avgrate;

    public void addratebycust(Driver d) {
        rating.put(d.getDriverRide().getCurrentRide().getRideControl().getCust().getUserName(),
                d.getDriverRide().getCurrentRide().getRideControl().getRateDriver());
        avragRate();
    }

    public double getAvgrate() {
        return avgrate;
    }

    public void viewratings() {
        if (rating.size() == 0) {
            System.out.println("There is no Ratings.");
            System.out.println("");
            return;
        }
        for (Map.Entry me : rating.entrySet()) {
            System.out.println("Customer: " + me.getKey() + " has rated you by " + me.getValue() + " stars");
        }
    }

    private void avragRate() {
        int avg = 0;
        for (int i : rating.values()) {
            avg += i;
        }
        avgrate = avg / rating.size();
    }
}
