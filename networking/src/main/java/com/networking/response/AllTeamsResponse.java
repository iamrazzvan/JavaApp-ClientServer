package com.networking.response;

import com.model.model.Team;

import java.util.Collection;

public class AllTeamsResponse implements Response {
    private final Collection<Team> teams;

    public AllTeamsResponse(Collection<Team> teams) {
        this.teams = teams;
    }

    public Collection<Team> getTeams() {
        return teams;
    }
}
