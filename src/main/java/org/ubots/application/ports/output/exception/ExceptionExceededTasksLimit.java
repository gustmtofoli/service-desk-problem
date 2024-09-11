package org.ubots.application.ports.output.exception;

public class ExceptionExceededTasksLimit extends RuntimeException {
    private static final String EXCEEDED_TASK_LIMIT = "Exceeded tasks limit";

    public ExceptionExceededTasksLimit() {
        super(EXCEEDED_TASK_LIMIT);
    }
}
