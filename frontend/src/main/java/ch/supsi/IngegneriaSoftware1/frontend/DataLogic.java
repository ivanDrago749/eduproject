package ch.supsi.IngegneriaSoftware1.frontend;

import java.util.*;
import java.util.stream.Collectors;

public class DataLogic {
    static IMDBReader fileReader = new IMDBReader();
    static TreeMap<String, List<Film>> moviesByDirector = fileReader.readCSV("/Users/simonecoggio/Desktop/SUPSI/IngegneriaDelSoftware/eduproject/imdb_top_1000.csv");

    public TreeMap<String, List<Film>> getMoviesByDirector() {
        return moviesByDirector;
    }

    public double getAvarageRunTime() {
        return moviesByDirector.values().stream()
                .flatMap(List::stream)
                .mapToInt(Film::getDurataFilm)
                .average()
                .orElse(0);
    }

    public long getNumberOfMovies() {
        return moviesByDirector.values().stream()
                .mapToLong(List::size)
                .sum();
    }


    public String getBestDirector() {
        return moviesByDirector.entrySet().stream()
                .max(Comparator.comparingDouble(entry -> averageRating(entry.getValue())))
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    private static double averageRating(List<Film> films) {
        return films.stream()
                .mapToDouble(Film::getRating)
                .average()
                .orElse(0.0);
    }

    public static String getMostFrequentActorFromDirectors() {
        Map<String, Long> actorFrequency = moviesByDirector.values().stream()
                .flatMap(List::stream)
                .flatMap(film -> film.getAttori().stream())
                .collect(Collectors.groupingBy(actor -> actor, Collectors.counting()));

        return actorFrequency.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

    }

}
