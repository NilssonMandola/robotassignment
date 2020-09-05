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
            } else {
                //Do nothing if faulty command? Check with stakeholders
                logger.warn("An unknown command was provided \"{}\", ignore it.", command);
            }
        }
        return new MovementResult(currentPosition, currentDirecton);
    }

    public Direction turn(Direction currentDirection, TurnCommand turnCommand) {
        if (TurnCommand.LEFT == turnCommand) {
            return turn(currentDirection.getIntValue() - 1);
        }
        return turn(currentDirection.getIntValue() + 1);
    }

    public Position move(Position currentPosition, int matrixSize, Direction direction) {
        switch (direction) {
            case NORTH:
                if ((currentPosition.getYPosition() > 0))
                    return new Position(currentPosition.getXPosition(), currentPosition.getYPosition() - 1);
                break;
            case EAST:
                if ((currentPosition.getXPosition() < matrixSize))
                    return new Position(currentPosition.getXPosition() + 1, currentPosition.getYPosition());
                break;
            case SOUTH:
                if (currentPosition.getYPosition() < matrixSize)
                    return new Position(currentPosition.getXPosition(), currentPosition.getYPosition() + 1);
                break;
            case WEST:
                if (currentPosition.getXPosition() > 0)
                    return new Position(currentPosition.getXPosition() - 1, currentPosition.getYPosition());
                break;
        }
        //Do nothing if moving out of matrix? Check with stakeholders
        logger.warn("The robot tried moving out of the matrix, ignore it and stay in position.");
        return currentPosition;
    }


    private Direction turn(int direction) {
        return Direction.getDirection(Math.floorMod(direction, 4));
    }
}
