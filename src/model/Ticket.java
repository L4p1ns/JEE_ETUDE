/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

public class Ticket {
    private int id;
    private Date datePrise;
    private Speciaite specialite;
    private Patient patient;
    private Caissier caissier;

    public Ticket(int id, Date datePrise, Speciaite specialite, Patient patient, Caissier caissier) {
        this.id = id;
        this.datePrise = datePrise;
        this.specialite = specialite;
        this.patient = patient;
        this.caissier = caissier;
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

    public Speciaite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Speciaite specialite) {
        this.specialite = specialite;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Caissier getCaissier() {
        return caissier;
    }

    public void setCaissier(Caissier caissier) {
        this.caissier = caissier;
    }


}
