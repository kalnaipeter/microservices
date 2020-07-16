package com.codecool.videoservice.controller;

import com.codecool.videoservice.service.DiceRollService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/roll")
public class DiceRollController {

    @Autowired
    private DiceRollService service;

    @Autowired
    private Environment environment;

    @GetMapping("/d6")
    public Roll rollD6(){
        return new Roll(
                service.rollD6(),
                "D6",
                environment.getProperty("server.port")
        );
    }

    @GetMapping("/d20")
    public Roll rollD20(){
        return new Roll(
                service.rollD20(),
                "D20",
                environment.getProperty("server.port")
        );
    }

    @Data
    @AllArgsConstructor
    public class Roll {
        private int result;
        private String dice;
        private String port;
    }
}
