import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class ElevatorHandler {

    public static void goToFloor(Elevator elevator, int floor){

        System.err.println("*** Call for "+floor+" floor");

        if(elevator.currentfloor == floor){
            System.out.println("Lift is already at floor...Door Opening");
        }

        if(elevator.direction == Direction.UP){
            if(elevator.currentfloor < floor){
                elevator.queueUp.add(floor);
            }else{
                elevator.queueDown.add(floor);
            }
        }else if(elevator.direction == Direction.DOWN){
            if(elevator.currentfloor > floor){
                elevator.queueDown.add(floor);
            }else{
                elevator.queueUp.add(floor);
            }
        }else{          // Lift is stationary
            if(elevator.currentfloor > floor){
                elevator.queueDown.add(floor);
            }else if(elevator.currentfloor < floor){
                elevator.queueUp.add(floor);
            }
        }


    }

}

