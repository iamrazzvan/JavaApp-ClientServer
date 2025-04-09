package com.networking.response;

import com.model.model.Race;

public class RaceByNameResponse implements Response {
    private final Race race;

    public RaceByNameResponse(Race race) {
        this.race = race;
    }

    public Race getRace() {
        return race;
    }
}
