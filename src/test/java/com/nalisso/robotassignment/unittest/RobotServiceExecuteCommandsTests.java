package com.nalisso.robotassignment.unittest;

import com.nalisso.robotassignment.service.internal.model.Direction;
import com.nalisso.robotassignment.service.internal.model.MovementResult;
import com.nalisso.robotassignment.service.internal.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
final class RobotServiceExecuteCommandsTests extends RobotServiceTests {

    @Test
    void testSeriesOfCommands() {
        Position initialPosition = new Position(2, 2);
        Position expectedPosition = new Position(2, 2);
        Direction initialDirection = Direction.NORTH;
        Direction expectedDirection = Direction.NORTH;
        char[] commands = "LFRRFL".toCharArray();
        MovementResult movementResult = executeCommands(initialPosition, 5, initialDirection, commands);
        Assertions.assertEquals(expectedDirection, movementResult.getDirection());
        Assertions.assertEquals(expectedPosition, movementResult.getPosition());
    }
}
