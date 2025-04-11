package org.example;

import lombok.Data;

import java.util.List;

@Data
class StandingsCalculation {

    String name;
    int minutes;
    int seconds;
    String firstShootingRange;
    String secondShootingRange;
    String thirdShootingRange;
    Country country;

    int getFinalResult() {
        return (minutes * 60 + seconds) + getPenalty();
    }

    int getPenalty() {
        int sum = 0;
        List<String> strings = List.of(this.firstShootingRange, this.secondShootingRange, this.thirdShootingRange);
        for (String s : strings) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'o') {
                    count += 10;
                }
            }
            sum += count;
        }
        return sum;
    }

    int getFinalMinutes() {
        return getFinalResult() / 60;
    }

    int getFinalSeconds() {
        return getFinalResult() % 60;
    }
}
