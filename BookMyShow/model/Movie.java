package BookMyShow.model;

public class Movie {
    private final String id;
    private final String name;
    private final int durationInMintues;


    public Movie(String id, String name, int durationInMintues) {
        this.id = id;
        this.name = name;
        this.durationInMintues = durationInMintues;
    }


    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public int getDurationInMintues() {
        return durationInMintues;
    }

    
    
}
