package com.nalisso.robotassignment.unittest;

import com.nalisso.robotassignment.service.internal.model.Direction;
import com.nalisso.robotassignment.service.internal.model.Position;
import com.nalisso.robotassignment.service.internal.model.TurnCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class RobotServiceMoveAndTurnTests extends RobotServiceTests {

    @Test
    void testTurnRightAndMove() {
        Direction initialDirection = Direction.NORTH;
        Direction expectedDirection = Direction.WEST;
        Position initialPosition = new Position(4, 4);
        Position expectedPosition = new Position(3, 4);
        Direction currentDirection = turn(initialDirection, TurnCommand.LEFT);
        Position currentPosition = move(initialPosition, 10, currentDirection);
        assertEquals(expectedDirection, currentDirection);
        assertEquals(expectedPosition, currentPosition);
    }

    @Test
    void testWalkAroundCorners() {
        Direction initialDirection = Direction.WEST;
        Direction expectedDirection = Direction.WEST;
        Position initialPosition = new Position(2, 0);
        Position expectedPosition = new Position(2, 0);
        Direction currentDirection = initialDirection;
        Position currentPosition = move(initialPosition, 5, currentDirection, 2);
        currentDirection = turn(currentDirection, TurnCommand.LEFT);
        currentPosition = move(currentPosition, 5, currentDirection, 4);
        currentDirection = turn(currentDirection, TurnCommand.LEFT);
        currentPosition = move(currentPosition, 5, currentDirection, 4);
        currentDirection = turn(currentDirection, TurnCommand.LEFT);
        currentPosition = move(currentPosition, 5, currentDirection, 4);
        currentDirection = turn(currentDirection, TurnCommand.LEFT);
        currentPosition = move(currentPosition, 5, currentDirection, 2);
        assertEquals(expectedDirection, currentDirection);
        assertEquals(expectedPosition, currentPosition);
    }

}
