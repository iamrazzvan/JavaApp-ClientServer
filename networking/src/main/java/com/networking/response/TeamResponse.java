package com.networking.response;

import com.model.model.Team;

public class TeamResponse implements Response {
    private final Team team;

    public TeamResponse(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }
}
