package NonTrivialSoftwareSystem;

public class DriverRide {
    private Ride currentRide;
    public void setCurrentRide(Ride ride) {
        this.currentRide=ride;
    }
    public Ride getCurrentRide() {
        return currentRide;
    }
}
