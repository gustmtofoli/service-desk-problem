package org.ubots.application.ports.output.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ExceptionBadRequest.class)
    public ResponseEntity<String> handleBadRequest(ExceptionBadRequest ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExceptionAttendeeNotFound.class)
    public ResponseEntity<String> handleAttendeeNotFound(ExceptionAttendeeNotFound ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExceptionTeamNotFound.class)
    public ResponseEntity<String> handleTeamNotFound(ExceptionTeamNotFound ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExceptionExceededTasksLimit.class)
    public ResponseEntity<String> handleExceptionLimit(ExceptionExceededTasksLimit ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler(ExceptionEmptyQueue.class)
    public ResponseEntity<String> handleExceptionLimit(ExceptionEmptyQueue ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.PRECONDITION_FAILED);
    }
}
