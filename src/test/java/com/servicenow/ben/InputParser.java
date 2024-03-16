package com.servicenow.ben;

public class InputParser {

    public static String parse(String input) {
        if (input.startsWith("$")) {
            String envVarName = input.replaceAll("(\\$\\{)(.*)(})", "$2");
            return System.getenv(envVarName);
        }
        return input;
    }
}
