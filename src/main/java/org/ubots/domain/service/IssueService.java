package org.ubots.domain.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.ubots.domain.validator.RequestValidator;
import org.ubots.domain.models.issue.deliver.ServiceDeskRequest;
import org.ubots.domain.models.issue.deliver.ServiceDeskWaitingQueueItem;
import org.ubots.domain.models.team.ServiceDeskTeam;
import org.ubots.domain.models.team.Team;
import org.ubots.application.ports.input.IssuePort;

@Service
public class IssueService implements IssuePort {

    final private TeamManager teamManager;

    final private RequestValidator validator;

    public IssueService(RequestValidator validator) {
        this.validator = validator;
        this.teamManager = TeamManager.getInstance();
    }

    @Override
    public void deliver(ServiceDeskRequest request) {
        String issueId = request.getId();
        validator.validateIssueId(issueId);

        String issueType = request.getType();
        validator.validateIssueType(issueType);

        ServiceDeskTeam serviceDeskTeam = teamManager.getTeam(getTeam(issueType));

        serviceDeskTeam.getWaitingQueue().add(new ServiceDeskWaitingQueueItem(issueId));

        ResponseEntity.ok("Success");
    }

    private Team getTeam(String issueType) {
        if (!teamManager.getAllTeams().contains(issueType))
            return Team.GENERAL;
        return Team.valueOf(issueType);
    }

}
