package ElevatorSystem;

import java.util.List;

import ElevatorSystem.model.Request;


public class ElevatorController {

    private final List<Elevator> elevators;

    private final ElevatorSelectionStrategy strategy;

    public ElevatorController(List<Elevator> elevators, ElevatorSelectionStrategy strategy) {
        this.elevators = elevators;
        this.strategy = strategy;
    }

    public Elevator requestElevator(Request request){
        Elevator elevator = strategy.selecElevator(elevators, request);

        if(elevator == null){
            throw new RuntimeException(
                    "No elevator available"
            );
        }

        elevator.addDestination(request.getSourceFloor());

        return elevator;
    }




}
