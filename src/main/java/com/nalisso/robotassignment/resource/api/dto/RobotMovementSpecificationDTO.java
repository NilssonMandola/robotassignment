package com.nalisso.robotassignment.resource.api.dto;

import javax.validation.constraints.NotNull;

public class RobotMovementSpecificationDTO {

    @NotNull
    public final String movementInstructions;
    @NotNull
    public final int matrixSize;
    @NotNull
    public final PositionDTO initialPosition;

    public RobotMovementSpecificationDTO(String movementInstructions, int matrixSize, PositionDTO initialPosition) {
        this.movementInstructions = movementInstructions;
        this.matrixSize = matrixSize;
        this.initialPosition = initialPosition;
    }

}
