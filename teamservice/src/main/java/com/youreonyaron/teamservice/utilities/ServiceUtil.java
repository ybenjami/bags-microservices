package com.youreonyaron.teamservice.utilities;

import com.youreonyaron.teamservice.exceptions.InvalidInputException;

public class ServiceUtil {
    public static final String UNABLE_TO_PARSE_INPUT_VALUES = "Unable to parse input values";

    public static long parseInput(final String input){
        try{
            return Long.parseLong(input);
        }catch (NumberFormatException e){
            throw new InvalidInputException(UNABLE_TO_PARSE_INPUT_VALUES);
        }
    }

}
