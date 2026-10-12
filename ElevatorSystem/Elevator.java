package ElevatorSystem;

import java.util.Comparator;
import java.util.PriorityQueue;

import ElevatorSystem.model.Direction;
import ElevatorSystem.model.Door;
import ElevatorSystem.model.ElevatorState;

public class Elevator {
    
    private final int id;

    private int currentFloor;

    private Direction direction;

    private ElevatorState state;

    private final Door door;

    private  final PriorityQueue<Integer> upRequests;

    private  final PriorityQueue<Integer> downRequests;

    public Elevator(int id, int initialFloor){

        this.id = id;
        this.currentFloor = initialFloor;

        this.direction = Direction.IDLE;
        this.state = ElevatorState.IDLE;

        this.door =  new Door();

        this.upRequests = new PriorityQueue<>();

        this.downRequests = new PriorityQueue<>(Comparator.reverseOrder());

    }


    

    public int getId() {
        return id;
    }




    public int getCurrentFloor() {
        return currentFloor;
    }




    public Direction getDirection() {
        return direction;
    }




    public ElevatorState getState() {
        return state;
    }




    public Door getDoor() {
        return door;
    }




    public PriorityQueue<Integer> getUpRequests() {
        return upRequests;
    }




    public PriorityQueue<Integer> getDownRequests() {
        return downRequests;
    }




    public void addDestination(int floor){
          if(floor == currentFloor){
            return;
          }

          if(floor > currentFloor){
            upRequests.offer(floor);
          } else {
            downRequests.offer(floor);
          }
    }

    public void move(){
        state = ElevatorState.MOVING;

        while(!upRequests.isEmpty()){
            direction = Direction.UP;

            int destination = upRequests.poll();

            moveToFloor(destination);
        }

        while(!downRequests.isEmpty()){
            direction = Direction.DOWN;

            int destination = downRequests.poll();

            moveToFloor(destination);
        }
    }

    private void moveToFloor(int destination){

        System.out.println(
            "Elevator " + id +
            " moving from floor " +
            currentFloor +
            " to floor " +
            destination
        );

        currentFloor = destination;

            System.out.println(
            "Elevator " + id +
            " reached floor " +
            currentFloor
        );

        openDoor();
        closeDoor();
    }

    public void openDoor(){
        door.open();
    }

    public void closeDoor(){
        door.close();
    }
}
