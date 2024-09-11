package org.ubots.domain.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;
import org.ubots.domain.models.team.ServiceDeskTeam;
import org.ubots.domain.models.team.Team;
import org.ubots.application.ports.input.TeamPort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class TeamService implements TeamPort {

    private final TeamManager teamManager;

    public TeamService() {
        this.teamManager = TeamManager.getInstance();
    }

    @Override
    public String all() {
        HashMap<String, HashMap<String, Integer>> teamDetails = new HashMap<>();
        List<Team> teamTypes = Arrays.asList(Team.CARDS, Team.LOAN, Team.GENERAL);
        teamTypes.forEach(teamType -> {
            HashMap<String, Integer> queues = new HashMap<>();
            ServiceDeskTeam team = teamManager.getTeam(teamType);
            queues.put("NumberOfWaitingItems", team.getWaitingQueue().size());
            queues.put("NumberOfOngoingItems", team.getOnGoingQueue().size());
            queues.put("NumberOfDoneItems", team.getDoneQueue().size());
            teamDetails.put(teamType.getDescription(), queues);
        });
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(teamDetails);
    }
}
