package model;


import java.util.Date;

public class Ticket {
    private int id;
    private Date datePrise;
    private Integer specialite;
    private Integer patient;
    private Integer caissier;
    private Integer personnel;
    private Double montant;

    public Ticket(Integer id, Date datePrise, Integer specialite, Integer patient, Integer caissier, Integer personnel, Double montant) {
        this.id = id;
        this.datePrise = datePrise;
        this.specialite = specialite;
        this.patient = patient;
        this.caissier = caissier;
        this.personnel = personnel;
        this.montant = montant;
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

    public Integer getPatient() {
        return patient;
    }

    public void setPatient(Integer patient) {
        this.patient = patient;
    }

    public Integer getCaissier() {
        return caissier;
    }

    public void setCaissier(Integer caissier) {
        this.caissier = caissier;
    }

    public Integer getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Integer personnel) {
        this.personnel = personnel;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }
}
