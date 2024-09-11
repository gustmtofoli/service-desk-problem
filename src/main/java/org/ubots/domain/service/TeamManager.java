package org.ubots.domain.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.ubots.domain.models.attendee.Attendee;
import org.ubots.domain.models.team.ServiceDeskTeam;
import org.ubots.domain.models.team.Team;

import java.util.*;

@NoArgsConstructor
public class TeamManager {

    @Getter
    final private static ServiceDeskTeam teamCards = new ServiceDeskTeam();

    @Getter
    final private static ServiceDeskTeam teamLoan = new ServiceDeskTeam();

    @Getter
    final private static ServiceDeskTeam teamOthers = new ServiceDeskTeam();

    @Getter
    final private static HashMap<Team, ServiceDeskTeam> teamsDistributions = new HashMap<Team, ServiceDeskTeam>() {{
        put(Team.CARDS, getTeamCards());
        put(Team.LOAN, getTeamLoan());
        put(Team.GENERAL, getTeamOthers());
    }};

    private static TeamManager teamManager;

    static public TeamManager getInstance() {
        if (teamManager == null) {
            teamCards.setAttendees(Collections.singletonList(new Attendee(1, Team.CARDS)));
            teamLoan.setAttendees(Collections.singletonList(new Attendee(2, Team.LOAN)));
            teamOthers.setAttendees(Arrays.asList(new Attendee(3, Team.GENERAL), new Attendee(4, Team.GENERAL)));

            teamManager = new TeamManager();
        }
        return teamManager;
    }

    public ServiceDeskTeam getTeam(Team teamType) {
        return getTeamsDistributions().get(teamType);
    }

    public List<String> getAllTeams() {
        return Arrays.asList(Team.CARDS.getDescription(), Team.LOAN.getDescription(), Team.GENERAL.getDescription());
    }

}
