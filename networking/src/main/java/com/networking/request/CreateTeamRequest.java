package com.networking.request;

import com.model.model.Team;

public class CreateTeamRequest implements Request {
    private final Team team;

    public CreateTeamRequest(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }
}
