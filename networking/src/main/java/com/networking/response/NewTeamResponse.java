package com.networking.response;

import com.model.model.Team;

public class NewTeamResponse implements UpdateResponse {
    private final Team team;

    public NewTeamResponse(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }
}
