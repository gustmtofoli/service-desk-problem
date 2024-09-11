package org.ubots.domain.models.attendee;

import lombok.Getter;
import org.ubots.domain.models.attendee.assign.ServiceDeskOnGoingQueueItem;
import org.ubots.domain.models.attendee.finish.ServiceDeskDoneQueueItem;
import org.ubots.domain.models.issue.deliver.ServiceDeskWaitingQueueItem;
import org.ubots.domain.models.team.ServiceDeskTeam;
import org.ubots.application.ports.output.exception.ExceptionEmptyQueue;
import org.ubots.application.ports.output.exception.ExceptionExceededTasksLimit;
import org.ubots.domain.models.team.Team;

public class Attendee {

    static final int MAX_CONCURRENT_CAPACITY = 3;

    @Getter
    private int id;

    @Getter
    private Team team;

    private int currentAmountOfOngoingCalls = 0;

    public Attendee(int id, Team team) {
        this.id = id;
        this.team = team;
    }

    public void assignTask(ServiceDeskTeam team) {
        if (currentAmountOfOngoingCalls < MAX_CONCURRENT_CAPACITY) {
            ServiceDeskWaitingQueueItem item = team.getWaitingQueue().poll();
            if (item != null) {
                ServiceDeskOnGoingQueueItem onGoingQueueItem = new ServiceDeskOnGoingQueueItem(item.getId(), this);
                team.getOnGoingQueue().add(onGoingQueueItem);
                currentAmountOfOngoingCalls += 1;
                return;
            }
            throw new ExceptionEmptyQueue();
        }
        throw new ExceptionExceededTasksLimit();
    }

    public void finishTask(ServiceDeskTeam team) {
        ServiceDeskOnGoingQueueItem onGoingQueueItem = team.getOnGoingQueue().poll();
        if (onGoingQueueItem != null) {
            ServiceDeskDoneQueueItem doneQueueItem = new ServiceDeskDoneQueueItem(onGoingQueueItem.getIssueId(), onGoingQueueItem.getAttendee());
            team.getDoneQueue().add(doneQueueItem);
            currentAmountOfOngoingCalls -= 1;
            return;
        }
        throw new ExceptionEmptyQueue();
    }

}
