package model;

public class Speciaite {
    private int id;
    private String nom;
    private int tarif;
    public Speciaite(int id, String nom, int tarif) {
        super();
        this.id = id;
        this.nom = nom;
        this.tarif = tarif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

}
