package com.nalisso.robotassignment.resource.api.dto;

public class RobotMovementResponseDTO {

    public final PositionDTO position;

    public RobotMovementResponseDTO() {
        this(null);
    }

    public RobotMovementResponseDTO(PositionDTO position) {
        this.position = position;
    }

}
