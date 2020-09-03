package com.nalisso.robotassignment.unittest;

import com.nalisso.robotassignment.service.api.RobotService;
import com.nalisso.robotassignment.service.internal.model.Direction;
import com.nalisso.robotassignment.service.internal.model.MovementResult;
import com.nalisso.robotassignment.service.internal.model.Position;
import com.nalisso.robotassignment.service.internal.RobotServiceImpl;
import com.nalisso.robotassignment.service.internal.model.TurnCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class RobotServiceTests {

    private static final Logger logger = LoggerFactory.getLogger(RobotServiceTurnTests.class);
    private static final RobotService robotService = new RobotServiceImpl();

    MovementResult executeCommands(Position initialPosition, int matrixSize, Direction direction, char[] commands) {
        return robotService.executeCommands(initialPosition, matrixSize, direction, commands);
    }

    Direction turn(Direction initialDirection, TurnCommand turnCommand) {
        return turn(initialDirection, turnCommand, 1);
    }

    Direction turn(Direction initialDirection, TurnCommand turnCommand, int amountOfTurns) {
        Direction currentDirection = initialDirection;
        logger.info("Began facing {}", currentDirection);
        for (int i = 0; i < amountOfTurns; i++) {
            currentDirection = robotService.turn(currentDirection, turnCommand);
            logger.info("Currently facing {}", currentDirection);
        }
        logger.info("Ended up facing {}", currentDirection);
        return currentDirection;
    }

    Position move(Position initialPosition, int matrixSize, Direction direction) {
        return move(initialPosition, matrixSize, direction, 1);
    }

    Position move(Position initialPosition, int matrixSize, Direction direction, int amountOfMoves) {
        Position currentPosition = initialPosition;
        logger.info("Began on ({},{})", currentPosition.getXPosition(), currentPosition.getYPosition());
        for (int i = 0; i < amountOfMoves; i++) {
            currentPosition = robotService.move(currentPosition, matrixSize, direction);
            logger.info("Currently on ({},{})", currentPosition.getXPosition(), currentPosition.getYPosition());
        }
        logger.info("Ended up on ({},{})", currentPosition.getXPosition(), currentPosition.getYPosition());
        return currentPosition;
    }

}
