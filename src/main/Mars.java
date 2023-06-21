package main;

/**
 * The Mars class is a singleton, because there can be only one planet Mars.
 */
public final class Mars {

    private static Mars INSTANCE;

    static final Integer SOUTHEDGE = 0;
    static final Integer WESTEDGE = 0;
    Integer northEdge;
    Integer eastEdge;

    public Integer getNorthEdge() {
        return northEdge;
    }

    public void setNorthEdge(Integer northEdge) {
        this.northEdge = northEdge;
    }

    public Integer getEastEdge() {
        return eastEdge;
    }

    public void setEastEdge(Integer eastEdge) {
        this.eastEdge = eastEdge;
    }

    private Mars(Integer eastEdge, Integer northEdge) {
        this.eastEdge = eastEdge;
        this.northEdge = northEdge;
    }

    public static Mars getInstance(Integer eastEdge, Integer northEdge) {
        validateInputs(eastEdge,northEdge);
        if(INSTANCE == null) {
            INSTANCE = new Mars(eastEdge, northEdge);
        }

        return INSTANCE;
    }

    private static void validateInputs(Integer eastEdge, Integer northEdge){
        if(eastEdge == null){
            throw new IllegalArgumentException("The eastEdge of Mars cannot be Null.");
        }
        if(northEdge == null){
            throw new IllegalArgumentException("The northEdge of Mars cannot be Null.");
        }
        if(eastEdge < 1){
            throw new IllegalArgumentException("The eastEdge of Mars cannot be less than 1.");
        }
        if(northEdge < 1){
            throw new IllegalArgumentException("The northEdge of Mars cannot be less than 1.");
        }
        if(eastEdge > 50 || northEdge > 50){
            throw new IllegalArgumentException("Mars cannot be larger than 50 units in any direction.");
        }
    }

}
