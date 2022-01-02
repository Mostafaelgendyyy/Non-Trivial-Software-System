package NonTrivialSoftwareSystem;

public class DiscountSpecificArea implements Discount{

    @Override
    public double calPrice(double total) {
        return 0.9*total;
    }
}
