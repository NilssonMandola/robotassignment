package com.nalisso.robotassignment.service.api;

import com.nalisso.robotassignment.service.internal.model.Direction;
import com.nalisso.robotassignment.service.internal.model.MovementResult;
import com.nalisso.robotassignment.service.internal.model.Position;
import com.nalisso.robotassignment.service.internal.model.TurnCommand;

public interface RobotService {

    /**
     * Moves the robot inside the matrix. If the robot is facing a wall and moving in the same direction, the robot
     * will stay in the same position.
     *
     * @param currentPosition the current position of the robot in the matrix
     * @param matrixSize      the size of the matrix, a 5x5 matrix has the size 5
     * @param direction       the current direction the robot is facing
     * @param commands        an array of commands to be executed by the robot
     * @return a position and direction after a series of moves has been made
     */
    MovementResult executeCommands(Position currentPosition, int matrixSize, Direction direction, char[] commands);

    /**
     * Turns the robot in the specified direction
     *
     * @param currentDirection the current direction the robot is facing
     * @param turnCommand      the direction to turn
     * @return a new direction after a turn has been made
     */
    Direction turn(Direction currentDirection, TurnCommand turnCommand);

    /**
     * Moves the robot inside the matrix. If the robot is facing a wall and moving in the same direction, the robot
     * will stay in the same position
     *
     * @param currentPosition the current position of the robot in the matrix
     * @param matrixSize      the size of the matrix, a 5x5 matrix has the size 5
     * @param direction       the current direction the robot is facing
     * @return a new position after a move has been made
     */
    Position move(Position currentPosition, int matrixSize, Direction direction);

}
