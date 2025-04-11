package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

class Writer {

    void run() {

        String inputFilePath = "src/main/resources/results.csv";
        String outputFilePath = "src/main/resources/standings.csv";

        Set<StandingsCalculation> athletes = Reader.readFromFile(inputFilePath);

        try (FileWriter file = new FileWriter(outputFilePath, StandardCharsets.UTF_8)) {
            file.write("Athletes Final Standings\n");
            for (StandingsCalculation a : athletes) {
                file.write(a.getName() + " " + a.getFinalMinutes() + " : " + a.getFinalSeconds() +
                        " (" + a.getMinutes() + " : " + a.getSeconds() + " + " + a.getPenalty() + ")" +
                        " " + a.getCountry());
                file.write("\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing the file: " + e.getMessage());
        }
    }
}
