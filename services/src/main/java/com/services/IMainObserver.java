package com.services;

import com.services.exceptions.ContestDataException;
import com.model.model.Participant;
import com.model.dto.RaceDTO;

import java.util.List;

public interface IMainObserver {
    void raceAdded(RaceDTO race) throws ContestDataException;
    void participantAdded(Participant participant) throws ContestDataException;
    void raceEntriesAdded(List<RaceDTO> races) throws ContestDataException;
}
