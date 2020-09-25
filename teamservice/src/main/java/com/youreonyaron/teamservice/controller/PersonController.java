package com.youreonyaron.teamservice.controller;

import com.youreonyaron.teamservice.entity.Player;
import com.youreonyaron.teamservice.entity.Team;
import com.youreonyaron.teamservice.model.DisplayTeam;
import com.youreonyaron.teamservice.model.Person;
import com.youreonyaron.teamservice.service.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.youreonyaron.teamservice.utilities.ServiceUtil.parseInput;

@RestController
@RequestMapping("api/teams/player")
public class PersonController {
    @Autowired
    PlayerService playerService;

    @GetMapping(path = "/{Id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPersonById(@PathVariable("Id") String sid) throws Exception {
        final long id=parseInput(sid);
        Optional<Player> optPerson = playerService.playerByID(id);
        return new ResponseEntity<>(createDisplay(optPerson), HttpStatus.OK);

    }

    private Object createDisplay(Optional<Player> optPerson) throws Exception {
       return optPerson.map(person -> {
            Person t = new Person();
            t.setId(person.getId());
            t.setName(person.getPlayerName());
            return t;
        }).orElseThrow(Exception::new);
    }
}

