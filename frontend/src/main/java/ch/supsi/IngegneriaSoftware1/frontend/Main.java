package ch.supsi.IngegneriaSoftware1.frontend;
import ch.supsi.IngegneriaSoftware1.backend.DataLogic;
import ch.supsi.IngegneriaSoftware1.backend.Film;
import ch.supsi.IngegneriaSoftware1.backend.IMDBManager;

import java.util.List;
import java.util.TreeMap;
public class Main{
    public static void main(String[] args) {
        IMDBManager imdbReader = new IMDBManager();
        DataLogic dl = new DataLogic();
        String filePath = "/Users/simonecoggio/Desktop/SUPSI/IngegneriaDelSoftware/eduproject/imdb_top_1000.csv"; // Assicurati di impostare il percorso corretto del file
        TreeMap<String, List<Film>> moviesByDirector = IMDBManager.readCSV(filePath);

        // Stampa il contenuto della TreeMap
        System.out.println(dl.getAvarageRunTime());
        System.out.println(dl.getBestDirector());
        System.out.println(dl.getNumberOfMovies());
        System.out.println(DataLogic.getMostFrequentActor());
        System.out.println(DataLogic.getMostProfitableYear());
    }
}
