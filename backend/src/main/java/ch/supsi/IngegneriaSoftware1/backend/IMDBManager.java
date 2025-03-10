package ch.supsi.IngegneriaSoftware1.backend;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class IMDBManager {

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
                // [9] Director, [10] Star1, [11] Star2, [12] Star3, [13] Star4, [15] guadagni
                if (line.length >= 14) {
                    String title = line[1].trim();
                    int releaseYear = Integer.parseInt(line[2].trim());
                    String runTimeStr = line[4].trim();
                    runTimeStr = runTimeStr.replaceAll("[^0-9]", "");
                    int runTime = Integer.parseInt(runTimeStr);
                    double imdbRating = Double.parseDouble(line[6].trim());
                    String director = line[9].trim();

                    // Non salviamo il campo Genre (line[5])

                    // Le star aggiuntive: Star2, Star3 e Star4
                    List<String> stars = new ArrayList<>();
                    for (int i = 10; i <= 13; i++) {
                        stars.add(line[i].trim());
                    }

                    double introiti = Double.parseDouble(line[15].trim());
                    Film movie = new Film(title, runTime, releaseYear, stars, imdbRating, introiti);
                    moviesByDirector.computeIfAbsent(director, k -> new ArrayList<>()).add(movie);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return moviesByDirector;
    }

    public static void writeCSV(int numberOfMovies, double avarageRunTime, String bestDirector, String mostFamousActor, int mostProductiveYear){

    }
}