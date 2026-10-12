package BookMyShow.model;

import java.time.LocalDateTime;

public class Show {
    
    private final String id;
    private final Movie movie;
    private final Screen screen;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    public Show(String id, Movie movie, Screen screen, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    public String getId(){
        return id;
    }

    public Screen getScreen(){
        return screen;
    }
    
}
