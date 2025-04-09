package com.networking.response;

import com.model.model.Participant;

import java.util.Collection;

public class GetParticipantsByTeamResponse implements Response {
    private final Collection<Participant> teamParticipants;

    public GetParticipantsByTeamResponse(Collection<Participant> teamParticipants) {
        this.teamParticipants = teamParticipants;
    }

    public Collection<Participant> getTeamParticipants() {
        return teamParticipants;
    }
}
