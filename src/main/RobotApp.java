package main;

import java.util.*;

public class RobotApp {

    //TODO This could be a set of positions
    static ArrayList<Position> scentedPositions = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Initialise Mars using two numbers separated by a space: ");
        String marsInitLine = scanner.nextLine();
        parseMarsInitLine(marsInitLine);
        System.out.println("Mars has successfully been created.");

        //TODO We could do with a program exit option
        while (true){
            System.out.println("Enter a Robot Starting position e.g. '1 1 E'");
            String robotInitLine = scanner.nextLine();
            Robot r = parseRobotInitLine(robotInitLine);

            System.out.println("Enter a Robot Command string without spaces e.g. 'FLFRF'");
            String robotCommandLine = scanner.nextLine();
            parseRobotCommandLine(robotCommandLine, r);
        }
    }

    private static void parseMarsInitLine(String marsInitLine){
        //TODO This method needs more input validation, and some tests
        String [] parts = marsInitLine.split("\\s+");
        Integer marsX = Integer.valueOf(parts[0]);
        Integer marsY = Integer.valueOf(parts[1]);
        Mars.getInstance(marsX,marsY);
    }

    private static Robot parseRobotInitLine(String robotInitLine){
        //TODO This method needs more input validation, and some tests
        String [] parts = robotInitLine.split("\\s+");
        Integer robotX = Integer.valueOf(parts[0]);
        Integer robotY = Integer.valueOf(parts[1]);
        Orientation robotOrientation = Orientation.valueOf(parts[2]);
        return new Robot(robotX, robotY, robotOrientation);
    }

    private static void parseRobotCommandLine(String robotCommandLine, Robot r){
        //TODO This method needs more input validation, and some tests
        boolean lost = false;
        loop: for (int i = 0; i < robotCommandLine.length(); i++) {
                Character c = robotCommandLine.charAt(i);
                switch (c) {
                    case 'F':
                        r.moveForward();
                        if (!validNewPosition(r)) {
                            r.moveBackward();
                            if (!scentedPosition(r)) {
                                lost = true;
                                scentedPositions.add(r.getPosition());
                                break loop;
                            }
                        }
                        break;
                    case 'R':
                        r.turnRight();
                        break;
                    case 'L':
                        r.turnLeft();
                        break;
                    default:
                        System.out.println("Command '" + c + "' was ignored");
                }

            }

        String basicOut = r.getPosition().getX() + " " + r.getPosition().getY() + " " + r.getOrientation();
        if (lost){
            System.out.println(basicOut + " LOST");
        } else {
            System.out.println(basicOut);
        }

    }

    private static boolean validNewPosition(Robot r){
        boolean valid = true;
        Mars mars = Mars.getInstance();
        if (r.getPosition().getX() > mars.getEastEdge()){
            valid = false;
        }
        if (r.getPosition().getX() < Mars.WESTEDGE){
            valid = false;
        }
        if (r.getPosition().getY() > mars.getNorthEdge()){
            valid = false;
        }
        if (r.getPosition().getY() < Mars.SOUTHEDGE){
            valid = false;
        }

        return valid;
    }

    private static boolean scentedPosition(Robot r){
        boolean scentedPosition = false;
        for (Position p : scentedPositions){
            if (p.getX() == r.getPosition().getX() && p.getY() == r.getPosition().getY()){
                scentedPosition = true;
            }
        }
        return scentedPosition;
    }
}
