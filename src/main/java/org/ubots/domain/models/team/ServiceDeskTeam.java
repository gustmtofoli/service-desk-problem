package org.ubots.domain.models.team;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ubots.domain.models.attendee.Attendee;
import org.ubots.domain.models.attendee.assign.ServiceDeskOnGoingQueueItem;
import org.ubots.domain.models.issue.deliver.ServiceDeskWaitingQueueItem;
import org.ubots.domain.models.attendee.finish.ServiceDeskDoneQueueItem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@NoArgsConstructor
public class ServiceDeskTeam {
    @Getter
    private Queue<ServiceDeskWaitingQueueItem> waitingQueue = new LinkedList<>();

    @Getter
    private Queue<ServiceDeskOnGoingQueueItem> onGoingQueue = new LinkedList<>();

    @Getter
    private Queue<ServiceDeskDoneQueueItem> doneQueue = new LinkedList<>();

    @Getter
    @Setter
    private List<Attendee> attendees = new ArrayList<>();
}
