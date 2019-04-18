package model;

import java.util.Date;

public class Ticket {
    private int id;
    private Date datePrise;
    private Integer specialite;
    private Integer personnel;
    private String patient;

    public Ticket(Integer id, Date datePrise, Integer specialite, String patient, Integer personnel) {
        this.id = id;
        this.datePrise = datePrise;
        this.specialite = specialite;
        this.patient = patient;
        this.personnel = personnel;
    }

    public Ticket(Date datePrise, Integer specialite, String patient, Integer personnel) {
        this.datePrise = datePrise;
        this.specialite = specialite;
        this.patient = patient;
        this.personnel = personnel;
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
}
