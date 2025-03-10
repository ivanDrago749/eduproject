package ch.supsi.IngegneriaSoftware1.backend;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

public class Film {
    private double rating;
    private String title;
    private int durataFilm;
    private List<String> attori;
    private int annoPublicazione;

    public Film(String title, int durataFilm, int annoPublicazione, List<String> attori, double rating) {
        this.title = title;
        this.durataFilm = durataFilm;
        this.annoPublicazione = annoPublicazione;
        this.attori = attori;
        this.rating = rating;
    }


    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {this.rating = rating;}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDurataFilm() {
        return durataFilm;
    }

    public void setDurataFilm(int durataFilm) {
        durataFilm = durataFilm;
    }

    public List<String> getAttori() {
        return attori;
    }

    public void setAttori(List<String> attori) {
        this.attori = attori;
    }

    public int getAnnoPublicazione() {
        return annoPublicazione;
    }

    public void setAnnoPublicazione(int annoPublicazione) {
        annoPublicazione = annoPublicazione;
    }

    @Override
    public String toString() {
        return "Film{" +
                "rating=" + rating +
                ", title='" + title + '\'' +
                ", durataFilm=" + durataFilm +
                ", attori=" + attori +
                ", annoPublicazione=" + annoPublicazione +
                '}';
    }
}
