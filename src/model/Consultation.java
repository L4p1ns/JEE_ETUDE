package model;

import java.util.Date;

public class Consultation {
    private Integer id;
    private Date date;
    private Integer medecin_id;
    private Integer ticket_id;

    public Consultation(Integer id, Date date, Integer medecin_id, Integer ticket_id) {
        this.id = id;
        this.date = date;
        this.medecin_id = medecin_id;
        this.ticket_id = ticket_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getMedecin_id() {
        return medecin_id;
    }

    public void setMedecin_id(Integer medecin_id) {
        this.medecin_id = medecin_id;
    }

    public Integer getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(Integer ticket_id) {
        this.ticket_id = ticket_id;
    }
}
