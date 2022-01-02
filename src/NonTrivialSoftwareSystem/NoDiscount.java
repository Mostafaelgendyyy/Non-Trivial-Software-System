package NonTrivialSoftwareSystem;

public class NoDiscount implements Discount{
    @Override
    public double calPrice(double total) {
        return total;
    }
}
