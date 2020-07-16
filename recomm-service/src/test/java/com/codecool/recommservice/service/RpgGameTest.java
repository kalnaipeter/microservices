package com.codecool.recommservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RpgGameTest {

    @Mock
    private RollServiceCaller rollServiceCaller;

    @InjectMocks
    private RpgGame rpgGame;


    @Test
    void evaluateCombat_MonsterWins() {
        when(rollServiceCaller.rollForHero()).thenReturn(12);
        when(rollServiceCaller.rollForMonster()).thenReturn(20);

        assertThat(rpgGame.evaluateCombat()).isEqualTo("Monster won! 12 vs 20");

    }

    @Test
    void evaluateCombat_HeroWins() {
        when(rollServiceCaller.rollForHero()).thenReturn(16);
        when(rollServiceCaller.rollForMonster()).thenReturn(1);

        assertThat(rpgGame.evaluateCombat()).isEqualTo("Hero won! 16 vs 1");

    }
}