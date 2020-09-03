package com.nalisso.robotassignment.resource.internal;

import com.nalisso.robotassignment.resource.api.RobotResource;
import com.nalisso.robotassignment.resource.api.dto.RobotMovementResponseDTO;
import com.nalisso.robotassignment.resource.api.dto.DirectionDTO;
import com.nalisso.robotassignment.resource.api.dto.PositionDTO;
import com.nalisso.robotassignment.resource.api.dto.RobotMovementSpecificationDTO;
import com.nalisso.robotassignment.service.api.RobotService;
import com.nalisso.robotassignment.service.internal.model.Direction;
import com.nalisso.robotassignment.service.internal.model.MovementResult;
import com.nalisso.robotassignment.service.internal.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/move")
public class RobotResourceImpl implements RobotResource {

    private final RobotService robotService;

    @Autowired
    public RobotResourceImpl(RobotService robotService) {
        this.robotService = robotService;
    }

    public RobotMovementResponseDTO moveRobot(RobotMovementSpecificationDTO robotMovementSpecificationDTO) {
        Position position = getPosition(robotMovementSpecificationDTO.initialPosition);
        Direction direction = getDirection(robotMovementSpecificationDTO.initialPosition);
        char[] commands = getCommands(robotMovementSpecificationDTO.movementInstructions);
        int matrixSize = getMatrixSize(robotMovementSpecificationDTO);
        MovementResult movementResult = robotService.executeCommands(position, matrixSize, direction, commands);
        return getResponse(movementResult);
    }

    private Direction getDirection(PositionDTO initialPosition) {
        return Direction.getDirection(initialPosition.direction.toString());
    }

    private Position getPosition(PositionDTO positionDTO) {
        return new Position(positionDTO.xPosition, positionDTO.yPosition);
    }

    private char[] getCommands(String movementInstructions) {
        return movementInstructions.toCharArray();
    }

    private int getMatrixSize(RobotMovementSpecificationDTO robotMovementSpecificationDTO) {
        int xPosition = robotMovementSpecificationDTO.initialPosition.xPosition;
        int yPosition = robotMovementSpecificationDTO.initialPosition.yPosition;
        int matrixSize = robotMovementSpecificationDTO.matrixSize;
        if (xPosition < matrixSize && yPosition < matrixSize) {
            return matrixSize;
        }
        throw new IllegalArgumentException("Matrix is too small.");
    }

    private RobotMovementResponseDTO getResponse(MovementResult movementResult) {
        Position finalPosition = movementResult.getPosition();
        Direction finalDirection = movementResult.getDirection();
        return new RobotMovementResponseDTO(new PositionDTO(finalPosition.getXPosition(),
                finalPosition.getYPosition(),
                DirectionDTO.valueOf(finalDirection.getStringValue())));
    }

}
