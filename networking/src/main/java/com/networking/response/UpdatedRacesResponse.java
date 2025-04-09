package com.networking.response;

import com.model.dto.RaceDTO;

import java.util.List;

public class UpdatedRacesResponse implements UpdateResponse {
    private final List<RaceDTO> races;

    public UpdatedRacesResponse(List<RaceDTO> races) {
        this.races = races;
    }

    public List<RaceDTO> getRaces() {
        return races;
    }
}
