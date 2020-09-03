package com.nalisso.robotassignment.service.internal.model;

public class MovementResult {

    private final Position position;
    private final Direction direction;

    public MovementResult(Position position, Direction direction){
        this.position = position;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public Position getPosition() {
        return position;
    }

}
