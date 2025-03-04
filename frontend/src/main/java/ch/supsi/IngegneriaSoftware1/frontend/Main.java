package ch.supsi.IngegneriaSoftware1.frontend;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import ch.supsi.IngegneriaSoftware1.backend.Film;

public class IMDBReader {

    public static TreeMap<String, List<Film>> readCSV(String filePath) {
        TreeMap<String, List<Film>> moviesByDirector = new TreeMap<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            // Salta l'intestazione
            reader.readNext();

            while ((line = reader.readNext()) != null) {
                // Struttura prevista:
                // [0] Poster_Link, [1] Series_Title, [2] Released_Year, [3] Certificate,
                // [4] Runtime, [5] Genre, [6] IMDB_Rating, [7] Overview, [8] Meta_score,
                // [9] Director, [10] Star1, [11] Star2, [12] Star3, [13] Star4, ...
                if (line.length >= 14) {
                    String title = line[1].trim();
                    int releaseYear = Integer.parseInt(line[2].trim());
                    int runTime = Integer.parseInt(line[4].trim());
                    double imdbRating = Double.parseDouble(line[6].trim());
                    String director = line[9].trim();
                    String mainActor = line[10].trim();

                    // Non salviamo il campo Genre (line[5])

                    // Le star aggiuntive: Star2, Star3 e Star4
                    List<String> stars = new ArrayList<>();
                    for (int i = 11; i <= 13 && i < line.length; i++) {
                        stars.add(line[i].trim());
                    }

                    Film movie = new Film(title, runTime, releaseYear, director, stars);
                    moviesByDirector.computeIfAbsent(director, k -> new ArrayList<>()).add(movie);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return moviesByDirector;
    }

    public static void main(String[] args) {
        String filePath = "imdb_top_1000.csv"; // Assicurati di impostare il percorso corretto del file
        TreeMap<String, List<Film>> moviesByDirector = readCSV(filePath);

        // Stampa il contenuto della TreeMap
        for (String director : moviesByDirector.keySet()) {
            System.out.println("Director: " + director);
            for (Film movie : moviesByDirector.get(director)) {
                System.out.println("  " + movie);
            }
        }
    }
}
