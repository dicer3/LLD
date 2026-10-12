package ElevatorSystem;

import ElevatorSystem.model.Direction;

public class Main {
    public static void main(String[] args) {
        ElevatorSystem system = new ElevatorSystem(3,0);

        Elevator elevator = system.requestElevetor(5, Direction.UP);

        elevator.addDestination(10);

        elevator.move();

    }
}
