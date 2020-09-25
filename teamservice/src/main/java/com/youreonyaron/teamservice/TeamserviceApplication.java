package com.youreonyaron.teamservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableScheduling
public class TeamserviceApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(TeamserviceApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TeamserviceApplication.class);
    }

    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

}

