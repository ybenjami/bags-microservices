package com.youreonyaron.teamservice.service;


import com.youreonyaron.teamservice.entity.Player;
import com.youreonyaron.teamservice.repository.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Optional<Player> playerByID(Long id) {
        return playerRepository.findById(id);
    }

}