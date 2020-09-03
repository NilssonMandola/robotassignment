package com.nalisso.robotassignment.resource.api.dto;

public class RobotMovementSpecificationDTO {

    public final String movementInstructions;
    public final int matrixSize;
    public final PositionDTO initialPosition;

    public RobotMovementSpecificationDTO(String movementInstructions, int matrixSize, PositionDTO initialPosition) {
        this.movementInstructions = movementInstructions;
        this.matrixSize = matrixSize;
        this.initialPosition = initialPosition;
    }

}
