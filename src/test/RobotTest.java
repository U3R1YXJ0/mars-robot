package test;

import main.Orientation;
import main.Robot;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotTest {

    @org.junit.jupiter.api.Test
    void command_forward_north() {
        Robot robot = new Robot(0,0, Orientation.N);
        robot.moveForward();
        assertEquals(0,robot.getPosition().getX(), () -> "Robot X position should be 0");
        assertEquals(1,robot.getPosition().getY(), () -> "Robot Y position should be 1");
        assertEquals(Orientation.N,robot.getOrientation(), () -> "Robot Orientation should be North");
    }

    @org.junit.jupiter.api.Test
    void command_left_forward_west() {
        Robot robot = new Robot(1,1, Orientation.N);
        robot.turnLeft();
        robot.moveForward();
        assertEquals(0,robot.getPosition().getX(), () -> "Robot X position should be 0");
        assertEquals(1,robot.getPosition().getY(), () -> "Robot Y position should be 1");
        assertEquals(Orientation.W,robot.getOrientation(), () -> "Robot Orientation should be West");
    }

    @org.junit.jupiter.api.Test
    void command_right_forward_east() {
        Robot robot = new Robot(1,1, Orientation.N);
        robot.turnRight();
        robot.moveForward();
        assertEquals(2,robot.getPosition().getX(), () -> "Robot X position should be 2");
        assertEquals(1,robot.getPosition().getY(), () -> "Robot Y position should be 1");
        assertEquals(Orientation.E,robot.getOrientation(), () -> "Robot Orientation should be East");
    }

    @org.junit.jupiter.api.Test
    void commands_case_one() {
        Robot robot = new Robot(1,1, Orientation.E);
        robot.turnRight();
        robot.moveForward();
        robot.turnRight();
        robot.moveForward();
        robot.turnRight();
        robot.moveForward();
        robot.turnRight();
        robot.moveForward();
        assertEquals(1,robot.getPosition().getX(), () -> "Robot X position should be 1");
        assertEquals(1,robot.getPosition().getY(), () -> "Robot Y position should be 1");
        assertEquals(Orientation.E,robot.getOrientation(), () -> "Robot Orientation should be East");
    }


}
