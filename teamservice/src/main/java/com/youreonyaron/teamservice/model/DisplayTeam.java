package com.youreonyaron.teamservice.model;

import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DisplayTeam {

    private Long id;
    private String name;
    private Set<Person> players;
}
