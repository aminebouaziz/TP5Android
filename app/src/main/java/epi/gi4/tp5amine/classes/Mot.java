package epi.gi4.tp5amine.classes;

public class Mot {
    private String leMot ;
    private int taille ;
    private String type;
    private String genre;

    public Mot(String leMot, int taille, String type, String genre) {
        this.leMot = leMot;
        this.taille = taille;
        this.type = type;
        this.genre = genre;
    }

    public String getLeMot() {
        return leMot;
    }

    public void setLeMot(String leMot) {
        this.leMot = leMot;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    @Override
    public String toString() {
        return "Mot{" +
                "leMot='" + leMot + '\'' +
                '}';
    }
}
