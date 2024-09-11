package org.ubots.infrastructure.adapters.persistence;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import org.ubots.application.ports.output.exception.ExceptionAttendeeNotFound;
import org.ubots.domain.models.attendee.Attendee;
import org.ubots.domain.models.team.ServiceDeskTeam;

import java.util.Optional;

@NoArgsConstructor
@Repository
public class AttendeeRepository {
    public Attendee getAttendee(ServiceDeskTeam team, String attendeeId) {
        Optional<Attendee> attendee = team.getAttendees().stream().filter(att -> att.getId() == Integer.parseInt(attendeeId)).findFirst();

        if (!attendee.isPresent()) {
            throw new ExceptionAttendeeNotFound();
        }

        return attendee.get();
    }

}
