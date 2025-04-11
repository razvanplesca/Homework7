package org.example;

import java.util.Comparator;

class AthletesComparator implements Comparator<StandingsCalculation> {
    @Override
    public int compare(StandingsCalculation standingsCalculation1, StandingsCalculation standingsCalculation2) {
        return standingsCalculation1.getFinalResult() - standingsCalculation2.getFinalResult();
    }
}
