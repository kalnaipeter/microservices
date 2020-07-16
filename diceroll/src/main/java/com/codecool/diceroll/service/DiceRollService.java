package com.codecool.diceroll.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class DiceRollService {

    @Autowired
    private Random random;

    public int rollD6() {
        log.info("Lets roll d6!");
        return random.nextInt(6)+1;
    }

    public int rollD20() {
        log.info("Lets roll d20!");
        return random.nextInt(20)+1;
    }
}
