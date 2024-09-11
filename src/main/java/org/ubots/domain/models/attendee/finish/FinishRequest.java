package org.ubots.domain.models.attendee.finish;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class FinishRequest {

    @Getter
    private String issueId;

    @Getter
    private String issueType;

    @Getter
    private String attendeeId;

}
