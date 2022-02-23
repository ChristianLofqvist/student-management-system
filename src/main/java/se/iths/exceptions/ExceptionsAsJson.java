package se.iths.exceptions;

import java.time.LocalDateTime;

public class ExceptionsAsJson {

    LocalDateTime localDateTime;
    String errorMessage;
    int errorCode;

    public ExceptionsAsJson(String errorMessage, int errorCode) {
        this.localDateTime = LocalDateTime.now();
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }
}
