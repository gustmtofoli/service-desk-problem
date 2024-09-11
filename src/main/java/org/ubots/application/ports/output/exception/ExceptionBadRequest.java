package org.ubots.application.ports.output.exception;

public class ExceptionBadRequest extends RuntimeException {
    private static final String BAD_REQUEST = "Bad Request";

    public ExceptionBadRequest() {
        super(BAD_REQUEST);
    }
}
