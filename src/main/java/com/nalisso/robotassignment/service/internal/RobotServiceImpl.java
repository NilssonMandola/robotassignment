package com.nalisso.robotassignment.service.internal;

import com.nalisso.robotassignment.service.api.RobotService;
import com.nalisso.robotassignment.service.internal.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RobotServiceImpl implements RobotService {

    private static final Logger logger = LoggerFactory.getLogger(RobotServiceImpl.class);

    @Override
    public MovementResult executeCommands(Position position, int matrixSize, Direction direction, char[] commands) {
        Position currentPosition = position;
        Direction currentDirecton = direction;
        for (char command : commands) {
            if (TurnCommand.isTurnCommand(command)) {
                currentDirecton = turn(currentDirecton, TurnCommand.getTurnCommand(command));
            } else if (MoveCommand.isMoveCommand(command)) {
                currentPosition = move(currentPosition, matrixSize, currentDirecton);
            }
            //Do nothing if faulty command?
        }
        return new MovementResult(currentPosition, currentDirecton);
    }

    public Direction turn(Direction currentDirection, TurnCommand turnCommand) {
        if (TurnCommand.LEFT == turnCommand) {
            return turn(currentDirection.getIntValue() - 1);
        } else if (TurnCommand.RIGHT == turnCommand) {
            return turn(currentDirection.getIntValue() + 1);
        }
        throw new IllegalArgumentException("Only TurnCommand.LEFT and TurnCommand.RIGHT are supported.");
    }

    public Position move(Position currentPosition, int matrixSize, Direction direction) {
        switch (direction) {
            case NORTH:
                if ((currentPosition.getYPosition() > 0))
                    return new Position(currentPosition.getXPosition(), currentPosition.getYPosition() - 1);
            case EAST:
                if ((currentPosition.getXPosition() < matrixSize))
                    return new Position(currentPosition.getXPosition() + 1, currentPosition.getYPosition());
            case SOUTH:
                if (currentPosition.getYPosition() < matrixSize)
                    return new Position(currentPosition.getXPosition(), currentPosition.getYPosition() + 1);
            case WEST:
                if (currentPosition.getXPosition() > 0)
                    return new Position(currentPosition.getXPosition() - 1, currentPosition.getYPosition());

        }
        logger.warn("The robot tried to move but hit the wall, ouch!");
        return currentPosition;
    }


    private Direction turn(int direction) {
        return Direction.getDirection(Math.floorMod(direction, 4));
    }
}
