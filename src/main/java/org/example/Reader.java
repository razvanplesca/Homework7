package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

class Reader {
    static Set<StandingsCalculation> readFromFile(String filePath) {
        Set<StandingsCalculation> athletes = new TreeSet<>(new AthletesComparator());

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");

                StandingsCalculation athlete = new StandingsCalculation();
                athlete.name = data[1];
                athlete.minutes = Integer.parseInt(data[3].substring(0, 2));
                athlete.seconds = Integer.parseInt(data[3].substring(3));
                athlete.firstShootingRange = data[4];
                athlete.secondShootingRange = data[5];
                athlete.thirdShootingRange = data[6];
                athlete.country = Country.valueOf(data[2]);

                athletes.add(athlete);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing numeric values: " + e.getMessage());
        }

        return athletes;
    }
}
