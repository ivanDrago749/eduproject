package ch.supsi.IngegneriaSoftware1.frontend;
import java.util.List;
import java.util.TreeMap;
public class Main{
    public static void main(String[] args) {
        IMDBReader imdbReader = new IMDBReader();
        String filePath = "/Users/simonecoggio/Desktop/SUPSI/IngegneriaDelSoftware/eduproject/imdb_top_1000.csv"; // Assicurati di impostare il percorso corretto del file
        TreeMap<String, List<Film>> moviesByDirector = imdbReader.readCSV(filePath);

        // Stampa il contenuto della TreeMap
        for (String director : moviesByDirector.keySet()) {
            System.out.println("Director: " + director);
            for (Film movie : moviesByDirector.get(director)) {
                System.out.println("  " + movie);
            }
        }
    }
}
