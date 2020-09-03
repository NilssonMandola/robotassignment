package com.nalisso.robotassignment.service.internal.model;

import com.nalisso.robotassignment.service.internal.util.ConversionUtility;

public enum Direction {
    NORTH("N", 0),
    EAST("E", 1),
    SOUTH("S", 2),
    WEST("W", 3);

    private static final ConversionUtility<Direction> conversionUtility = new ConversionUtility<>();
    private int intValue;
    private String stringValue;

    Direction(String stringValue, int intValue) {
        this.intValue = intValue;
        this.stringValue = stringValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public static Direction getDirection(int intDirection) {
        return conversionUtility.convert(direction -> direction.intValue == intDirection, values());
    }

    public static Direction getDirection(String stringDirection) {
        return conversionUtility.convert(direction -> direction.stringValue.equals(stringDirection), values());
    }
}
