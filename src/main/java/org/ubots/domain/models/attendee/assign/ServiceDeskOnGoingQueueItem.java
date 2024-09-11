package org.ubots.domain.models.attendee.assign;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.ubots.domain.models.attendee.Attendee;

@AllArgsConstructor
public class ServiceDeskOnGoingQueueItem {

    @Getter
    private String issueId;

    @Getter
    private Attendee attendee;
}
