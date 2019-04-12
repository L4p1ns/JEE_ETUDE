package model;

import java.util.List;

public class Caissier extends Personne {
    private String email;
    private String password;
    private List<Ticket> tickets;

    public Caissier(int id, String matricule, String nom, String dateNaissance, String tel, String sexe, String email, String password) {
        super(id, matricule, nom, dateNaissance, tel, sexe);
        this.email = email;
        this.password = password;
        // TODO Auto-generated constructor stub
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }


}
