package com.youreonyaron.teamservice.entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Team {

    @Id
    private Long id;
    @ManyToMany(cascade = CascadeType.MERGE)
    Set<Player> players = new HashSet<>();
    private String teamName;
}