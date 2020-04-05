import java.util.PriorityQueue;

class Elevator{

    private static Elevator _elevator;

    int currentfloor;
    int startFloor;
    int endFloor;
    int targetFloor;
    Direction direction;
    PriorityQueue<Integer> queueUp;
    PriorityQueue<Integer> queueDown;

    private Elevator(){
        this.currentfloor = 0;
        this.startFloor = 0;
        this.endFloor = 10;
        this.targetFloor = 0;
        this.direction = Direction.STOP;
        this.queueDown = new PriorityQueue<>((a,b)->(b-a));      // 4 3 2
        this.queueUp = new PriorityQueue<>();                       // 5 7 8

    }

    public synchronized static Elevator getElevator()
    {
        if ( _elevator == null ) {
            _elevator = new Elevator();
        }
        return _elevator;
    }

}

