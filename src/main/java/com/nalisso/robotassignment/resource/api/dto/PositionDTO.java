package com.nalisso.robotassignment.resource.api.dto;

import javax.validation.constraints.PositiveOrZero;

public class PositionDTO {

    @PositiveOrZero
    public final int xPosition;
    @PositiveOrZero
    public final int yPosition;
    public final DirectionDTO direction;

    public PositionDTO(int xPosition, int yPosition, DirectionDTO direction) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.direction = direction;
    }
}
