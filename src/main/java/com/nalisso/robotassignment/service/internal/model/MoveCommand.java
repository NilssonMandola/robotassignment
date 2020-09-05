package com.nalisso.robotassignment.service.internal.model;

public enum MoveCommand {

    FORWARD("F");

    private String stringValue;

    MoveCommand(String stringValue) {
        this.stringValue = stringValue;
    }

    public static boolean isMoveCommand(char charCommand) {
        return FORWARD.stringValue.equals(String.valueOf(charCommand));
    }

}
