package NonTrivialSoftwareSystem;

public class FirstRideDiscount implements Discount{
    @Override
    public double calPrice(double total) {
        return 0.9*total;
    }
}
