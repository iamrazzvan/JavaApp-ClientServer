package com.services.service;

import com.model.model.Team;
import com.persistence.repository.ITeamRepository;
import com.services.validation.IValidator;
import com.services.validation.TeamValidator;

import java.util.Collection;
import java.util.Optional;

public class TeamService implements ITeamService {
    private final ITeamRepository teamRepository;
    private final IValidator<Team> validator;

    public TeamService(final ITeamRepository teamRepository) {
        this.teamRepository = teamRepository;
        validator = new TeamValidator();
    }

    @Override
    public Optional<Team> findById(Long id) {
        return teamRepository.findById(id);
    }

    @Override
    public Collection<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public void save(Team newEntity) {
        validator.validateEntity(newEntity);
        teamRepository.save(newEntity);
    }

    @Override
    public void delete(Long id) {
        teamRepository.delete(id);
    }

    @Override
    public void update(Team updatedEntity) {
        teamRepository.update(updatedEntity);
    }

    @Override
    public Optional<Team> getTeamByName(String teamName) {
        return teamRepository.getTeamByName(teamName);
    }
}
