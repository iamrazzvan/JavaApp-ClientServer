package com.networking.response;

import com.model.model.Race;

import java.util.Collection;

public class RacesByCapacityResponse implements Response {
    private final Collection<Race> races;

    public RacesByCapacityResponse(Collection<Race> races) {
        this.races = races;
    }

    public Collection<Race> getRaces() {
        return races;
    }
}
