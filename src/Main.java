public class Main {


    public static void main(String[] args) throws Exception {

        // Start the elevator server
        ElevatorServer server = new ElevatorServer() ;
        new Thread(server).start() ;

        // Get the instance of Elevator
        Elevator elevator = Elevator.getElevator();

        // Move Elevator
        ElevatorHandler.goToFloor(elevator, 2);
        ElevatorHandler.goToFloor(elevator, 5);
        ElevatorHandler.goToFloor(elevator, 9);

        Thread.sleep(6000);
        ElevatorHandler.goToFloor(elevator, 4);

        Thread.sleep(2000);
        ElevatorHandler.goToFloor(elevator, 2);
        ElevatorHandler.goToFloor(elevator, 3);
        ElevatorHandler.goToFloor(elevator, 3);
    }

}



        