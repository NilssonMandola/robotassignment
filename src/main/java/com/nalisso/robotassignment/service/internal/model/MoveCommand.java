package com.nalisso.robotassignment.service.internal.model;


import com.nalisso.robotassignment.service.internal.util.ConversionUtility;

public enum MoveCommand {
    FORWARD("F");

    private static final ConversionUtility<MoveCommand> conversionUtility = new ConversionUtility<>();

    private String stringValue;

    MoveCommand(String stringValue) {
        this.stringValue = stringValue;
    }

    public MoveCommand getMoveCommand(String stringMoveCommand) {
        return conversionUtility.convert(moveCommand -> moveCommand.stringValue.equals(stringMoveCommand), values());
    }

    public static boolean isMoveCommand(char charCommand) {
        return FORWARD.stringValue.equals(String.valueOf(charCommand));
    }

}
