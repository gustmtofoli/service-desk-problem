package org.ubots.application.ports.output.exception;

public class ExceptionTeamNotFound extends RuntimeException {
    private static final String TEAM_NOT_FOUND = "Team not found";

    public ExceptionTeamNotFound() {
        super(TEAM_NOT_FOUND);
    }
}
