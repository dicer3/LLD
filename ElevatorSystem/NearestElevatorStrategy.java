package ElevatorSystem;

import java.util.List;

import ElevatorSystem.model.Request;
import ElevatorSystem.model.ElevatorState;

public class NearestElevatorStrategy implements ElevatorSelectionStrategy {

    @Override
    public Elevator selecElevator(List<Elevator> elevators, Request request) {
        // TODO Auto-generated method stub
        Elevator bestElevator =  null;

        int minDist = Integer.MAX_VALUE;

        for(Elevator elevator: elevators){
            if(elevator.getState() == ElevatorState.MAINTENANCE){
                continue;
            }

            int dist = Math.abs(
                elevator.getCurrentFloor()-request.getSourceFloor()
            );

            if(dist<minDist){
                minDist=dist;
                bestElevator=elevator;
            }
        }

        return bestElevator;
    }
    
}
