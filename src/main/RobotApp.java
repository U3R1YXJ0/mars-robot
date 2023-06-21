package main;

import java.util.Scanner;

public class RobotApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Initialise Mars using two numbers separated by a space: ");
        String marsInitLine = scanner.nextLine();
        parseMarsInitLine(marsInitLine);
        System.out.println("Mars has successfully been created.");

        while (true){
            System.out.println("Enter a Robot Starting position e.g. '1 1 E'");
            String robotInitLine = scanner.nextLine();
            Robot r = parseRobotInitLine(robotInitLine);

            System.out.println("Enter a Robot Command string without spaces e.g. 'FLFRF'");
            String robotCommandLine = scanner.nextLine();
            parseRobotCommandLine(robotCommandLine, r);

            System.out.println(r.getPosition().getX() + " " + r.getPosition().getY() + " " + r.getOrientation());
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
        for (int i = 0; i < robotCommandLine.length(); i++) {
            Character c = robotCommandLine.charAt(i);
            switch (c) {
                case 'F':
                    r.moveForward();
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
    }
}
