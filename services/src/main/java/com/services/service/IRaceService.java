package com.services.service;

import com.model.model.Race;
import com.model.model.RaceEntry;
import com.model.dto.RaceDTO;

import java.util.Collection;
import java.util.Optional;

public interface IRaceService extends IService<Long, Race> {
    Optional<Race> getRaceByName(String name);

    Collection<RaceEntry> getEntriesByRace(Long raceID);

    void deleteByIds(Long participantID, Long raceID);

    Collection<Race> getRacesByEngineCapacity(Integer engineCapacity);

    Collection<RaceDTO> getRacesWithParticipantCount();

    void saveRaceEntry(RaceEntry newEntity);

    Collection<Race> getRacesWhereNotRegisteredAndEngineCapacity(Long participantID, Integer engineCapacity);
}
