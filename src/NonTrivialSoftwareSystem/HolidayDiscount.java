package NonTrivialSoftwareSystem;

public class HolidayDiscount implements Discount {
//
    @Override
    public double calPrice(double total) {
        return 0.95*total;
    }
}
