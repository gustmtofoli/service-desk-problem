package org.ubots.application.ports.output.exception;

public class ExceptionAttendeeNotFound extends RuntimeException {
    private static final String ATTENDEE_NOT_FOUND = "Attendee not found";

    public ExceptionAttendeeNotFound() {
        super(ATTENDEE_NOT_FOUND);
    }
}
