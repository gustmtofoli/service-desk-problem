package org.ubots.application.ports.input;

import org.ubots.domain.models.attendee.assign.RespondRequest;
import org.ubots.domain.models.attendee.finish.FinishRequest;

public interface AttendeePort {
    void assign(RespondRequest respondRequest) throws Exception;

    void finish(FinishRequest finishRequest) throws Exception;
}
