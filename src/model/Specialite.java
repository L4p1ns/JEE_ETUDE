package model;

public class Specialite {
    private Integer id;
    private String nom;
    private Integer tarif;
    private Integer personnel_id;

    public Specialite(Integer id, String nom, int tarif, int personnel_id) {
        this.id = id;
        this.nom = nom;
        this.tarif = tarif;
        this.personnel_id = personnel_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getTarif() {
        return tarif;
    }

    public void setTarif(Integer tarif) {
        this.tarif = tarif;
    }

    public Integer getPersonnel_id() {
        return personnel_id;
    }

    public void setPersonnel_id(Integer personnel_id) {
        this.personnel_id = personnel_id;
    }
}
