package org.ubots.application.ports.output.exception;

public class ExceptionEmptyQueue extends RuntimeException {
    private static final String EMPTY_QUEUE = "Empty queue";

    public ExceptionEmptyQueue() {
        super(EMPTY_QUEUE);
    }
}
