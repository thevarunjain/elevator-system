

public class ElevatorServer implements Runnable, PhysicalElevator {

	final static Elevator elevator = Elevator.getElevator();

	/**
	 * Method is continuously serving the lift request
	 */
	@Override
	public void run() {
		while (true) {
			try {
				// sleep for 5 seconds
				try { Thread.sleep( 2000 ); } catch ( Exception e ) { }

				// Check for request
				// updates an new target location
				// Based on direction it will update the next upcoming floor
				if(elevator.direction == Direction.UP){
					if(!elevator.queueUp.isEmpty()){
						elevator.targetFloor = elevator.queueUp.peek();
					}
				}else if(elevator.direction == Direction.DOWN){
					if(!elevator.queueDown.isEmpty()){
						elevator.targetFloor = elevator.queueDown.peek();
					}
				}else{
					if(!elevator.queueUp.isEmpty()){
						elevator.targetFloor = elevator.queueUp.peek();
					}else if(!elevator.queueDown.isEmpty()){
						elevator.targetFloor = elevator.queueDown.peek();
					}
				}

				// When the target is set, it wil update the direction
				// This will help elevator to know where lift is going
				// and help goTOFloor to which queue to add the
				// upcoming request in

				if(elevator.currentfloor < elevator.targetFloor){
					elevator.direction = Direction.UP;
				}else if(elevator.currentfloor > elevator.targetFloor){
					elevator.direction = Direction.DOWN;
				}else{
					elevator.direction = Direction.STOP;
				}


				// below code will check am i on target floor
				if(elevator.queueDown.isEmpty() && elevator.queueUp.isEmpty()){
					System.out.println("Lift is Stationary "+elevator.currentfloor);
				}else{
					// handle up
					if(elevator.currentfloor < elevator.targetFloor){
						startMovingUp(elevator);
						elevator.currentfloor++;
					}
					else if(elevator.currentfloor > elevator.targetFloor){
						startMovingDown(elevator);
						elevator.currentfloor--;
					}
						// Reached to Floor
					if(elevator.currentfloor == elevator.targetFloor){
						if(!elevator.queueDown.isEmpty() &&
								elevator.queueDown.peek() == elevator.targetFloor)
						{
							elevator.queueDown.poll();		// request served
						}
						else if(!elevator.queueUp.isEmpty() &&
								elevator.queueUp.peek() == elevator.targetFloor)
						{
							elevator.queueUp.poll();		// request served
						}
						System.out.println("*** Elevator Reached at "+elevator.targetFloor+" ***\nDoor Opening...\n");
					}
//
//					System.out.println( "Elevator{" +
//							" \n currentfloor=	" + elevator.currentfloor +
//							",\n targetFloor=	" + elevator.targetFloor +
//							",\n direction=		" + elevator.direction +
//							",\n queueUp=		" + elevator.queueUp +
//							",\n queueDown=		" + elevator.queueDown +
//							"\n");

					System.out.println("Elevator at "+elevator.currentfloor +" and going "+elevator.direction);
				}
			} catch (Exception e) {
				System.out.println( e ) ;
			}			
		}
	}


	@Override
	public void startMovingUp(Elevator e) {

	}

	@Override
	public void startMovingDown(Elevator e) {

	}

	@Override
	public boolean isApproachingFloor(Elevator e, int floor) {
		if((e.currentfloor < floor && e.direction == Direction.UP) ||
				(e.currentfloor > floor && e.direction == Direction.DOWN)){
			return true;
		}
		return false;
	}
}


