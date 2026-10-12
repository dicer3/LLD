package ElevatorSystem.model;

public class Door {
    private DoorState doorState;

    public Door(){
        this.doorState = DoorState.CLOSED;
    }

    public void open(){
        if(doorState == DoorState.OPEN){
            return;
        }

        this.doorState = DoorState.OPEN;
        System.out.println("Door opened");
    }

    public void close() {
        if(doorState == DoorState.CLOSED){
            return;
        }

        this.doorState = DoorState.CLOSED;
        System.out.println("Door closed");
    }    

    public DoorState getState(){
        return doorState;
    }
}
