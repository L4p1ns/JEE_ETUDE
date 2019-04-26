package dbutil;

import model.Ticket;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDbUtil {
    private DataSource dataSource;

    public TicketDbUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Ticket> getTickets() throws Exception {
        List<Ticket> tickets = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = dataSource.getConnection();

            //select ticket.id, ticket.datePrise, ticket.id_personnel, ticket.id_specialite, ticket.id_patient, s.id as idSpecialite, s.nom, s.tarif, p.nom, p.telephone, p.email,  p.type, p.prenom from  ticket join specialite s on ticket.id_specialite = s.id join personnel p on ticket.id_personnel = p.id;
            String sql = "select ticket.id, ticket.datePrise, s.nom as \"specialite\", s.tarif, p.nom as \"Nom_Personne\", p.prenom\n" +
                    "from ticket\n" +
                    "         join specialite s on ticket.id_specialite = s.id\n" +
                    "         join personnel p on ticket.id_personnel = p.id\n" +
                    "group by ticket.id, ticket.datePrise, s.nom, s.tarif, p.nom, p.prenom\n";
//            String sql = "select * from ticket";

            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery(sql);
            while (myRs.next()) {
                int id = myRs.getInt("id");
                Date date_prise = myRs.getDate("datePrise");
                String specialite = myRs.getString("specialite");
                Integer tarif = myRs.getInt("tarif");
                String nom = myRs.getString("Nom_Personne");
                String prenom = myRs.getString("prenom");

                Ticket ticket = new Ticket(id, date_prise, specialite, tarif, nom, prenom);
//                Ticket ticket = new Ticket(id, date_prise, id_specialite, id_patient, personnel);
                tickets.add(ticket);
            }
        } finally {
            // close JDBC objects
            close(myConn, myStmt, myRs);
        }
        return tickets;
    }

    public void addTicket(Ticket ticket) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // get db connection
            myConn = dataSource.getConnection();

            // create sql for insert
            String sql = "insert into ticket "
                    + "(datePrise, id_personnel, id_specialite, id_patient) "
                    + "values (?, ?, ?, ?)";

            myStmt = myConn.prepareStatement(sql);

//            myStmt.setDate(1, (java.sql.Date) ticket.getDatePrise());
            myStmt.setDate(1, (Date) ticket.getDatePrise());
            myStmt.setInt(2, ticket.getPersonnel());
            myStmt.setInt(3, ticket.getSpecialite());
            myStmt.setString(4, ticket.getPatient());

            // execute sql insert
            myStmt.execute();
        } finally {
            // clean up JDBC objects
            close(myConn, myStmt, null);
        }
    }

    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
        PersonnelDbUtil.closeConnexion(myConn, myStmt, myRs);
    }

    public Ticket getTicket(String ticketId) throws Exception {
        Ticket ticket = null;

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        int idTicket;

        try {
            idTicket = Integer.parseInt(ticketId);
            // get connection to database
            myConn = dataSource.getConnection();

            // create sql to get selected patient
            String sql = "select * from ticket where id=?";
            // create prepared statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setInt(1, idTicket);

            // execute statement
            myRs = myStmt.executeQuery();
            // retrieve data from result set row
            if (myRs.next()) {
                Integer id = myRs.getInt("id");
                Date datePrise = Date.valueOf(myRs.getString("datePrise"));
                Integer id_personnel = Integer.valueOf(myRs.getString("id_personnel"));
                Integer id_specialite = Integer.valueOf(myRs.getString("id_specialite"));
                String id_patient = myRs.getString("id_patient");

                // use the patient during construction
                ticket = new Ticket(id, datePrise, id_specialite, id_patient, id_personnel);
            } else {
                System.out.println("Ticket: " + idTicket + " n existe pas dans la base de donnee.");
            }
            return ticket;
        } finally {
            // clean up JDBC objects
            close(myConn, myStmt, myRs);
        }
    }
}
