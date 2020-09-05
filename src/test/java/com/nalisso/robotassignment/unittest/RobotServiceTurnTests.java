package com.nalisso.robotassignment.unittest;

import com.nalisso.robotassignment.service.internal.model.Direction;
import com.nalisso.robotassignment.service.internal.model.TurnCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class RobotServiceTurnTests extends RobotServiceTests {

    @Test
    void turnLeft() {
        Direction initialDirection = Direction.NORTH;
        Direction expectedDirection = Direction.WEST;
        assertEquals(expectedDirection, turn(initialDirection, TurnCommand.LEFT, 1));
    }

    @Test
    void turnRight() {
        Direction initialDirection = Direction.NORTH;
        Direction expectedDirection = Direction.EAST;
        assertEquals(expectedDirection, turn(initialDirection, TurnCommand.RIGHT, 1));
    }

    @Test
    void turnRightTwice() {
        Direction initialDirection = Direction.NORTH;
        Direction expectedDirection = Direction.SOUTH;
        assertEquals(expectedDirection, turn(initialDirection, TurnCommand.RIGHT, 2));
    }

    @Test
    void turnLeftTwice() {
        Direction initialDirection = Direction.NORTH;
        Direction expectedDirection = Direction.SOUTH;
        assertEquals(expectedDirection, turn(initialDirection, TurnCommand.LEFT, 2));
    }

    @Test
    void turnRightAllAround() {
        Direction initialDirection = Direction.NORTH;
        Direction expectedDirection = Direction.NORTH;
        assertEquals(expectedDirection, turn(initialDirection, TurnCommand.RIGHT, 4));
    }

    @Test
    void turnLeftAllAround() {
        Direction initialDirection = Direction.NORTH;
        Direction expectedDirection = Direction.NORTH;
        assertEquals(expectedDirection, turn(initialDirection, TurnCommand.LEFT, 4));
    }

    @Test
    void turnLeftALOT() {
        Direction initialDirection = Direction.NORTH;
        Direction expectedDirection = Direction.NORTH;
        assertEquals(expectedDirection, turn(initialDirection, TurnCommand.LEFT, 4 * 1000));
    }

    @Test
    void turnRightALOT() {
        Direction initialDirection = Direction.NORTH;
        Direction expectedDirection = Direction.NORTH;
        assertEquals(expectedDirection, turn(initialDirection, TurnCommand.RIGHT, 4 * 1000));
    }

    @Test
    void turnLeftThenRight() {
        Direction initialDirection = Direction.NORTH;
        Direction expectedDirection = Direction.NORTH;
        Direction currentDirection = turn(initialDirection, TurnCommand.LEFT, 1);
        assertEquals(expectedDirection, turn(currentDirection, TurnCommand.RIGHT, 1));
    }


}
