package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class StandingsCalculationUnitTest {

    final StandingsCalculation standingsCalculation = new StandingsCalculation();

    @Test
    void getFinalResult_withPenalties() {
        //given
        standingsCalculation.setMinutes(30);
        standingsCalculation.setSeconds(45);
        standingsCalculation.setFirstShootingRange("ooxo");
        standingsCalculation.setSecondShootingRange("o");
        standingsCalculation.setThirdShootingRange("");
        //when
        int result = standingsCalculation.getFinalResult();
        //then
        assertEquals(1885, result, "The final result should include penalties from missed shots.");
    }

    @Test
    void getFinalResult_noPenalties() {
        //given
        standingsCalculation.setMinutes(25);
        standingsCalculation.setSeconds(30);
        standingsCalculation.setFirstShootingRange("");
        standingsCalculation.setSecondShootingRange("");
        standingsCalculation.setThirdShootingRange("");
        //when
        int result = standingsCalculation.getFinalResult();
        //then
        assertEquals(1530, result, "The final result should equal the sum of minutes and seconds without penalties.");
    }

    @Test
    void getPenalty_allMissed() {
        //given
        standingsCalculation.setFirstShootingRange("ooooo");
        standingsCalculation.setSecondShootingRange("ooooo");
        standingsCalculation.setThirdShootingRange("ooooo");
        //when
        int penalty = standingsCalculation.getPenalty();
        //then
        assertEquals(150, penalty, "The penalty should be 150 (15 missed shots, 10 seconds each).");
    }

    @Test
    void getPenalty_noMisses() {
        //given
        standingsCalculation.setFirstShootingRange("");
        standingsCalculation.setSecondShootingRange("");
        standingsCalculation.setThirdShootingRange("");
        //when
        int penalty = standingsCalculation.getPenalty();
        //then
        assertEquals(0, penalty, "The penalty should be 0 (no missed shots).");
    }

    @Test
    void getPenalty_partialMisses() {
        //given
        standingsCalculation.setFirstShootingRange("ooxo");
        standingsCalculation.setSecondShootingRange("oo");
        standingsCalculation.setThirdShootingRange("o");
        //when
        int penalty = standingsCalculation.getPenalty();
        //then
        assertEquals(60, penalty, "The penalty should be 60 (6 missed shots, 10 seconds each).");
    }

}