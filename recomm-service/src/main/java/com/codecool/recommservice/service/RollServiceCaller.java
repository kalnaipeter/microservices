package com.codecool.recommservice.service;

import com.codecool.recommservice.model.DiceRollResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Stream;

@Service
@Slf4j
public class RollServiceCaller {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${diceroll.url}")
    private String baseUrl;

    public int rollForMonster(){
        log.info("==Monsterrolls==");
        DiceRollResult body = restTemplate.getForEntity(baseUrl + "/d20", DiceRollResult.class).getBody();
        log.info("Service called" + body.getPort());

        return body.getResult();
    }


    public int rollForHero() {
        log.info("== Hero rolls ==");

        return Stream.generate(() -> restTemplate.getForEntity(baseUrl + "/d6", DiceRollResult.class))
                .limit(3)
                .map(HttpEntity::getBody)
                .mapToInt(value -> {
                    log.info("Service called on: " + value.getPort());
                    return value.getResult();
                })
                .sum();
    }

}
