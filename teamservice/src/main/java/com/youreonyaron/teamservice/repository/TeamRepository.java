package com.youreonyaron.teamservice.repository;


import com.youreonyaron.teamservice.entity.Team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface TeamRepository extends JpaRepository<Team, Long> {
    }
