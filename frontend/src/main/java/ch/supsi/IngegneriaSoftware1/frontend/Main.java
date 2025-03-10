package ch.supsi.IngegneriaSoftware1.frontend;

import ch.supsi.IngegneriaSoftware1.backend.DataLogic;
import ch.supsi.IngegneriaSoftware1.backend.IMDBManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IMDBManager imdbManager = new IMDBManager();
        DataLogic dl = new DataLogic();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il percorso del file TXT: ");
        String filePath = scanner.nextLine();

        imdbManager.writeCSV(dl.getNumberOfMovies(), dl.getAvarageRunTime(), dl.getBestDirector(), DataLogic.getMostFrequentActor(), DataLogic.getYearWithMostReleases(), filePath);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Errore nella lettura del file: " + e.getMessage());
        }
    }
}
