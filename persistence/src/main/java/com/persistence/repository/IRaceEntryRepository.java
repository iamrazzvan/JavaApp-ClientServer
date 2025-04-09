package com.persistence.repository;

import com.model.model.Race;
import com.model.model.RaceEntry;

import java.util.Collection;

public interface IRaceEntryRepository extends IRepository<Long, RaceEntry> {
    Collection<RaceEntry> getEntriesByRace(Long raceID);

    void deleteByIds(Long participantID, Long raceID);

    Collection<Race> getRacesWhereNotRegisteredAndEngineCapacity(Long participantID, Integer engineCc);
}
