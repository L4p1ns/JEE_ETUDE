/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

public class Patient extends Personne {
    private String GroupeSanguin;
    private List<Ticket> tickets;

    public Patient(Integer id, String matricule, String nom, String dateNaissance, String tel, String sexe, String GroupeSanguin) {
        super(id, matricule, nom, dateNaissance, tel, sexe);
        this.GroupeSanguin = GroupeSanguin;

    }

    public Patient(String matricule, String nom, String dateNaissance2, String tel, String sexe, String groupeSanguin) {
        super(matricule, nom, dateNaissance2, tel, sexe);
       this.GroupeSanguin = groupeSanguin;
    }

    public String getGroupeSanguin() {
        return GroupeSanguin;
    }

    public void setGroupeSanguin(String groupeSanguin) {
        GroupeSanguin = groupeSanguin;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }


}
