package org.ubots.domain.models.attendee.finish;

import lombok.AllArgsConstructor;
import org.ubots.domain.models.attendee.Attendee;

@AllArgsConstructor
public class ServiceDeskDoneQueueItem {
    private String issueId;
    private Attendee attendee;
}
