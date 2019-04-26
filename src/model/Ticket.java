package model;

import java.util.Date;

public class Ticket {
    private int id;
    private Date datePrise;
    private Integer specialite;
    private Integer personnel;
    private String patient;
    private Integer tarif;
    private String nom;
    private String prenom;
    private String typeService;

    public Ticket(Integer id, Date datePrise, Integer specialite, String patient, Integer personnel) {
        this.id = id;
        this.datePrise = datePrise;
        this.specialite = specialite;
        this.patient = patient;
        this.personnel = personnel;
    }

    public Ticket(int id, Date datePrise, String typeService, Integer tarif, String nom, String prenom) {
        this.id = id;
        this.datePrise = datePrise;
        this.typeService = typeService;
        this.tarif = tarif;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Ticket(Date datePrise, Integer specialite, String patient, Integer personnel) {
        this.datePrise = datePrise;
        this.specialite = specialite;
        this.patient = patient;
        this.personnel = personnel;
    }

    public Integer getTarif() {
        return tarif;
    }

    public void setTarif(Integer tarif) {
        this.tarif = tarif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatePrise() {
        return datePrise;
    }

    public void setDatePrise(Date datePrise) {
        this.datePrise = datePrise;
    }

    public Integer getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Integer specialite) {
        this.specialite = specialite;
    }

    public Integer getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Integer personnel) {
        this.personnel = personnel;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", datePrise=" + datePrise +
                ", specialite=" + specialite +
                ", personnel=" + personnel +
                ", patient='" + patient + '\'' +
                ", tarif=" + tarif +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
