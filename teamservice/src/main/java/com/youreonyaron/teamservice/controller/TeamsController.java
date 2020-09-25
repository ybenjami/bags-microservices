package com.youreonyaron.teamservice.controller;

import com.youreonyaron.teamservice.entity.Team;
import com.youreonyaron.teamservice.model.DisplayTeam;
import com.youreonyaron.teamservice.model.Person;
import com.youreonyaron.teamservice.service.TeamService;
import static com.youreonyaron.teamservice.utilities.ServiceUtil.parseInput;


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

@RestController
@RequestMapping("api/teams")
public class TeamsController {
    @Autowired
    TeamService teamService;

    @GetMapping(path = "/{Id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTeamsById(@PathVariable("Id") String sid) throws Exception {
        final long id=parseInput(sid);
        Optional<Team> optTeam = teamService.list(id);
        return new ResponseEntity<>(createDisplay(optTeam), HttpStatus.OK);

    }

    private Object createDisplay(Optional<Team> optTeam) throws Exception {
       return optTeam.map(team -> {
            DisplayTeam t = new DisplayTeam();
            t.setName(team.getTeamName());
            t.setId(team.getId());
            t.setPlayers(createPlayerDisplay(team));
            return t;
        }).orElseThrow(Exception::new);
    }

    public Set<Person> createPlayerDisplay(Team team) {
        Set<Person> players = new HashSet<>();
        team.getPlayers().stream().forEach((player) -> {
            Person p = new Person();
            p.setName(player.getPlayerName());
            p.setId(player.getId());
            players.add(p);
        });
        return players;
    }
}

