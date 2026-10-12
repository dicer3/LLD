package ElevatorSystem;

import java.util.ArrayList;
import java.util.List;

import ElevatorSystem.model.Direction;
import ElevatorSystem.model.Request;

public class ElevatorSystem {
    
    private final ElevatorController elevatorController;

    
    public ElevatorSystem(
            int numberOfElevators,
            int initialFloor) {

               List<Elevator> elevators = new ArrayList<>();

               for(int i=1;i<= numberOfElevators; i++){
                 elevators.add(
                    new Elevator(i, initialFloor)
                 );
               }

               ElevatorSelectionStrategy selectionStrategy = new NearestElevatorStrategy();

               elevatorController = new ElevatorController(elevators, selectionStrategy);
            }

    public Elevator requestElevetor(
        int floor,
        Direction direction
    ) {
        Request request = new Request(floor, direction);

        return elevatorController.requestElevator(request);
    }
}
