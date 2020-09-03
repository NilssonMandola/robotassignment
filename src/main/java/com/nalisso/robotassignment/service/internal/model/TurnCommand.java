package com.nalisso.robotassignment.service.internal.model;

import com.nalisso.robotassignment.service.internal.util.ConversionUtility;

public enum TurnCommand {
    LEFT("L"),
    RIGHT("R");

    private static final ConversionUtility<TurnCommand> conversionUtility = new ConversionUtility<>();
    private String stringValue;

    TurnCommand(String stringValue) {
        this.stringValue = stringValue;
    }

    public static TurnCommand getTurnCommand(char stringTurnCommand) {
        return conversionUtility.convert(turnCommand -> turnCommand.stringValue.equals(String.valueOf(stringTurnCommand)), values());
    }

    public static boolean isTurnCommand(char charCommand) {
        String command = String.valueOf(charCommand);
        return LEFT.stringValue.equals(command) || RIGHT.stringValue.equals(command);
    }

}
