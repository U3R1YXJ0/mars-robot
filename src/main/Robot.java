package main;

public class Robot {
    public Position getPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    private Position position;
    private Orientation orientation;

    public Robot(int intialX, int initialY, Orientation orientation){
        this.position= new Position(intialX, initialY);
        this.orientation = orientation;
    }

    public void turnLeft(){
        switch (orientation) {
            case N -> orientation = Orientation.W;
            case W -> orientation = Orientation.S;
            case S -> orientation = Orientation.E;
            case E -> orientation = Orientation.N;
            default -> throw new IllegalStateException("Unexpected state when turning left");
        }
    }

    public void turnRight(){
        switch (orientation) {
            case N -> orientation = Orientation.E;
            case W -> orientation = Orientation.N;
            case S -> orientation = Orientation.W;
            case E -> orientation = Orientation.S;
            default -> throw new IllegalStateException("Unexpected state when turning right");
        }
    }

    public void moveForward(){
        switch (orientation) {
            case N -> position.setY(position.getY() + 1);
            case W -> position.setX(position.getX() - 1);
            case S -> position.setY(position.getY() - 1);
            case E -> position.setX(position.getX() + 1);
            default -> throw new IllegalStateException("Unexpected state when turning right");
        }
    }
}
