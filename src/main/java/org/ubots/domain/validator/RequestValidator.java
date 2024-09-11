package org.ubots.domain.validator;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.ubots.application.ports.output.exception.ExceptionBadRequest;

@NoArgsConstructor
@Component
public class RequestValidator {

    public void validateIssueId(String issueId) {
        if ( issueId == null) {
            throw new ExceptionBadRequest();
        }
    }

    public void validateIssueType(String issueType) {
        if (issueType.isEmpty()) {
            throw new ExceptionBadRequest();
        }
    }

    public void validateAttendeeId(String attendeeId) {
        if (attendeeId.isEmpty()) {
            throw new ExceptionBadRequest();
        }
    }

}
