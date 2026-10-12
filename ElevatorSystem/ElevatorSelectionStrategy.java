package ElevatorSystem;

import ElevatorSystem.model.Request;

import java.util.List;

public interface ElevatorSelectionStrategy {
    
    Elevator selecElevator(
        List<Elevator> elevator,
        Request request
    );
}
