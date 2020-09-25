package com.youreonyaron.teamservice.service;


import com.youreonyaron.teamservice.entity.Team;
import com.youreonyaron.teamservice.repository.TeamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Optional<Team> list(Long id) {
        return teamRepository.findById(id);
    }

}