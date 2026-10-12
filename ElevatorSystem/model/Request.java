package ElevatorSystem.model;

public class Request {
    private final int sourceFloor;
    private final Direction direction;
    
    public Request(int sourceFloor, Direction direction) {
        this.sourceFloor = sourceFloor;
        this.direction = direction;
    }

    public int getSourceFloor() {
        return sourceFloor;
    }

    public Direction getDirection() {
        return direction;
    }
}
