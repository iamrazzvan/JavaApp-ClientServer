package com.networking.request;

import com.model.model.RaceEntry;

import java.util.List;

public class CreateRaceEntriesRequest implements Request {
    private final List<RaceEntry> raceEntries;

    public CreateRaceEntriesRequest(List<RaceEntry> raceEntries) {
        this.raceEntries = raceEntries;
    }

    public List<RaceEntry> getRaceEntries() {
        return raceEntries;
    }
}
