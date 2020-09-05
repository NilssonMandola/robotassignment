package com.nalisso.robotassignment.service.internal.model;

public class Position {

    private final int xPosition;
    private final int yPosition;

    public Position(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return xPosition == position.xPosition &&
                yPosition == position.yPosition;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", xPosition, yPosition);
    }
}
