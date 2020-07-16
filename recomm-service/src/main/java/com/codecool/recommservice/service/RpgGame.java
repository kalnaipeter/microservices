package com.codecool.recommservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RpgGame {

    @Autowired
    private RollServiceCaller serviceCaller;

    public String evaluateCombat() {
        int heroDmg = serviceCaller.rollForHero();
        int monsterDmg = serviceCaller.rollForMonster();

        String result = heroDmg + " vs " + monsterDmg;

        return heroDmg > monsterDmg ? "Hero won! " + result : "Monster won! " + result;
    }
}
