package com.nalisso.robotassignment.unittest;

import com.nalisso.robotassignment.service.internal.model.Direction;
import com.nalisso.robotassignment.service.internal.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
final class RobotServiceMoveTests extends RobotServiceTests {

    @Test
    void testMoveNorthOnce() {
        Position initialPosition = new Position(49, 49);
        Position expectedPosition = new Position(49, 48);
        Position positionAfterMovement = move(initialPosition, 100, Direction.NORTH, 1);
        Assertions.assertEquals(expectedPosition, positionAfterMovement);
    }

    @Test
    void testMoveSouthTwice() {
        Position initialPosition = new Position(14, 14);
        Position expectedPosition = new Position(14, 16);
        Position positionAfterMovement = move(initialPosition, 30, Direction.SOUTH, 2);
        Assertions.assertEquals(expectedPosition, positionAfterMovement);
    }

    @Test
    void testMoveEastOnce() {
        Position initialPosition = new Position(9, 9);
        Position expectedPosition = new Position(10, 9);
        Position positionAfterMovement = move(initialPosition, 20, Direction.EAST, 1);
        Assertions.assertEquals(expectedPosition, positionAfterMovement);
    }

    @Test
    void testMoveWestTwice() {
        Position initialPosition = new Position(4, 4);
        Position expectedPosition = new Position(2, 4);
        Position positionAfterMovement = move(initialPosition, 10, Direction.WEST, 2);
        Assertions.assertEquals(expectedPosition, positionAfterMovement);
    }

    @Test
    void testMoveIntoWall() {
        Position initialPosition = new Position(2, 2);
        Position expectedPosition = new Position(0, 2);
        Position positionAfterMovement = move(initialPosition, 5, Direction.WEST, 5);
        Assertions.assertEquals(expectedPosition, positionAfterMovement);
    }


}
