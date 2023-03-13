package com.challenge.ranking.utils.constants;

public class ExceptionConstants {

    public static final String ERROR = "ERROR";
    public static final String MESSAGE_INEXISTENT_SERIE = "Serie INEXISTENT - Serie not found";
    public static final String MESSAGE_INEXISTENT_USER = "USER INEXISTENT - User not found";
    public static final String INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR - An internal server error has ocurred";
    public static final String INVALID_SCORE_MESSAGE = "The score must be beetwen 0 and 10";

    private ExceptionConstants() {
        throw new IllegalStateException("Utility Class");
    }
}
