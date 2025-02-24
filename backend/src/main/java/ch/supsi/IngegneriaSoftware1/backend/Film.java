package ch.supsi.IngegneriaSoftware1.backend;

public class Film {
    private int DurataFilm;
    private String[] attori;
    private String direttore;
    private int AnnoPublicazione;

    public Film(int durataFilm, int annoPublicazione, String direttore, String[] attori) {
        DurataFilm = durataFilm;
        AnnoPublicazione = annoPublicazione;
        this.direttore = direttore;
        this.attori = attori;
    }

    public int getDurataFilm() {
        return DurataFilm;
    }

    public void setDurataFilm(int durataFilm) {
        DurataFilm = durataFilm;
    }

    public String getDirettore() {
        return direttore;
    }

    public void setDirettore(String direttore) {
        this.direttore = direttore;
    }

    public String[] getAttori() {
        return attori;
    }

    public void setAttori(String[] attori) {
        this.attori = attori;
    }

    public int getAnnoPublicazione() {
        return AnnoPublicazione;
    }

    public void setAnnoPublicazione(int annoPublicazione) {
        AnnoPublicazione = annoPublicazione;
    }
}
