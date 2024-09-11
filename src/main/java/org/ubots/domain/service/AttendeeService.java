package org.ubots.domain.service;

import org.springframework.stereotype.Service;
import org.ubots.domain.validator.RequestValidator;
import org.ubots.application.ports.output.exception.ExceptionTeamNotFound;
import org.ubots.infrastructure.adapters.persistence.AttendeeRepository;
import org.ubots.domain.models.team.ServiceDeskTeam;
import org.ubots.domain.models.team.Team;
import org.ubots.domain.models.attendee.assign.RespondRequest;
import org.ubots.domain.models.attendee.finish.FinishRequest;
import org.ubots.application.ports.input.AttendeePort;


@Service
public class AttendeeService implements AttendeePort {

    final private TeamManager teamManager;

    final private RequestValidator validator;

    final private AttendeeRepository attendeeRepository;

    public AttendeeService(RequestValidator validator, AttendeeRepository attendeeRepository) {
        this.validator = validator;
        this.attendeeRepository = attendeeRepository;
        this.teamManager = TeamManager.getInstance();
    }

    @Override
    public void assign(RespondRequest respondRequest) {
        String issueType = respondRequest.getIssueType();
        validator.validateIssueType(issueType);

        String attendeeId = respondRequest.getAttendeeId();
        validator.validateAttendeeId(attendeeId);

        validateTeam(issueType);

        ServiceDeskTeam team = teamManager.getTeam(Team.valueOf(issueType));

        attendeeRepository.getAttendee(team, attendeeId).assignTask(team);
    }

    @Override
    public void finish(FinishRequest finishRequest) {
        String issueType = finishRequest.getIssueType();
        validator.validateIssueType(issueType);

        String attendeeId = finishRequest.getAttendeeId();
        validator.validateAttendeeId(attendeeId);

        ServiceDeskTeam team = teamManager.getTeam(Team.valueOf(issueType));

        validateTeam(issueType);

        attendeeRepository.getAttendee(team, attendeeId).finishTask(team);
    }

    private void validateTeam(String issueType) {
        if (!teamManager.getAllTeams().contains(issueType)) {
            throw new ExceptionTeamNotFound();
        }
    }

}
