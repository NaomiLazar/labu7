package model;

public class Carte {
    private String titlu;
    private String autor;
    private int anAparitie;

    public Carte() { // Constructor necesar pentru Jackson
    }

    public Carte(String titlu, String autor, int anAparitie) {
        this.titlu = titlu;
        this.autor = autor;
        this.anAparitie = anAparitie;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnAparitie() {
        return anAparitie;
    }

    public void setAnAparitie(int anAparitie) {
        this.anAparitie = anAparitie;
    }

    @Override
    public String toString() {
        return "model.Carte{" +
                "titlu='" + titlu + '\'' +
                ", autor='" + autor + '\'' +
                ", anAparitie=" + anAparitie +
                '}';
    }
}