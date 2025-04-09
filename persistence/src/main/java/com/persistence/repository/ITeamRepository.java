package com.persistence.repository;

import com.model.model.Team;

import java.util.Optional;

public interface ITeamRepository extends IRepository<Long, Team> {
    Optional<Team> getTeamByName(String teamName);
}
