package ch.supsi.IngegneriaSoftware1.backend;

import java.util.List;

public class Film {
    private String title;
    private int durataFilm;
    private List<String> attori;
    private String direttore;
    private int annoPublicazione;

    public Film(String title, int durataFilm, int annoPublicazione, String direttore, List<String> attori) {
        this.title = title;
        this.durataFilm = durataFilm;
        this.annoPublicazione = annoPublicazione;
        this.direttore = direttore;
        this.attori = attori;
    }

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

    public String getDirettore() {
        return direttore;
    }

    public void setDirettore(String direttore) {
        this.direttore = direttore;
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
}
