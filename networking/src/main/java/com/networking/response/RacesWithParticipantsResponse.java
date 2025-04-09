package com.networking.response;

import com.model.dto.RaceDTO;

import java.util.Collection;

public class RacesWithParticipantsResponse implements Response {
    private final Collection<RaceDTO> races;

    public RacesWithParticipantsResponse(Collection<RaceDTO> races) {
        this.races = races;
    }

    public Collection<RaceDTO> getRaces() {
        return races;
    }
}
