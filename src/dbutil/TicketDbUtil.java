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

            String sql = "select id, date_prise, id_specialite, id_caissier, id_patient, id_personnel, montant from ticket";

            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery(sql);
            while (myRs.next()) {
                int id = myRs.getInt("id");
                Date date_prise =  myRs.getDate("date_prise");
                Integer id_specialite = myRs.getInt("id_specialite");
                Integer id_patient = myRs.getInt("id_caissier");
                Integer id_caissier = myRs.getInt("id_patient");
                Integer personnel = myRs.getInt("id_personnel");
                Double montant = myRs.getDouble("montant");

                Ticket ticket = new Ticket(id, date_prise, id_specialite, id_patient, id_caissier, personnel, montant);
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
                    + "(id_specialite, id_caissier, id_patient, id_personnel, montant) "
                    + "values (?, ?, ?, ?, ?)";

            myStmt = myConn.prepareStatement(sql);

//            myStmt.setDate(1, (java.sql.Date) ticket.getDatePrise());
            myStmt.setInt(1, ticket.getSpecialite());
            myStmt.setInt(2, ticket.getCaissier());
            myStmt.setInt(3, ticket.getPatient());
            myStmt.setInt(4, ticket.getPersonnel());
            myStmt.setDouble(5, ticket.getMontant());

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
}
