package com.services.service;

import com.model.model.Team;

import java.util.Optional;

public interface ITeamService extends IService<Long, Team> {
    Optional<Team> getTeamByName(String teamName);
}
