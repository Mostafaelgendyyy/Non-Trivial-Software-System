package NonTrivialSoftwareSystem;

public class DiscountPassenger implements Discount {

    @Override
    public double calPrice(double total) {
        return 0.95*total;
    }
}
