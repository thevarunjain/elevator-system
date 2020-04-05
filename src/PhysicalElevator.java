public interface PhysicalElevator {

    public void startMovingUp(Elevator e);

    public void startMovingDown(Elevator e);

    public boolean isApproachingFloor(Elevator e, int floor);
}
