package BookMyShow.model;

public class Seat {
    
    private final String id;
    private final int row;
    private final int number;
    private final SeatType type;

    public Seat(String id, int row, int number, SeatType type) {
        this.id = id;
        this.row = row;
        this.number = number;
        this.type = type;
    }

    public String getId(){
        return id;
    }
    
    public SeatType getType(){
        return type;
    }
}
