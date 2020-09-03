package com.nalisso.robotassignment.resource.api.dto;

public class PositionDTO {

    public final int xPosition;
    public final int yPosition;
    public final DirectionDTO direction;

    public PositionDTO(int xPosition, int yPosition, DirectionDTO direction) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.direction = direction;
    }
}
