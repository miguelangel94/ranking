package com.challenge.ranking.utils.constants;

public class ExceptionConstants {


    public static final String ERROR = "ERROR";

    public static final String MESSAGE_INEXISTENT_SEASON = "SEASON INEXISTENT - Season does not exist";
    public static final String MESSAGE_INEXISTENT_CHAPTER = "CHAPTER INEXISTENT - Chapter does not exist";

    public static final String INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR - An internal server error has ocurred";

    public static final String INVALID_SCORE_MESSAGE = "The score must be beetwen 0 and 10";

    private ExceptionConstants() {
        throw new IllegalStateException("Utility Class");
    }
}
