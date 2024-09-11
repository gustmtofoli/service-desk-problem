package org.ubots.domain.models.attendee.assign;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class RespondRequest {

    @Getter
    private String issueId;

    @Getter
    private String issueType;

    @Getter
    private String attendeeId;
}
