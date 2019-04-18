package dbutil;

import model.Consultation;
import model.Ticket;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultationDbUtil {
    private DataSource dataSource;

    public ConsultationDbUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Consultation> getConsultations() throws Exception {
        List<Consultation> consultations = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = dataSource.getConnection();

            String sql = "select id, dateConsultation, id_medecin, id_ticket, motif from consultation";

            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery(sql);
            while (myRs.next()) {
                int id = myRs.getInt("id");
                Date date_prise = myRs.getDate("dateConsultation");
                Integer id_medecin = myRs.getInt("id_medecin");
                Integer id_ticket = myRs.getInt("id_ticket");
                String motif = myRs.getString("motif");

                Consultation consultation = new Consultation(id,date_prise,id_medecin,id_ticket,motif);
                consultations.add(consultation);
            }
        } finally {
            // close JDBC objects
            close(myConn, myStmt, myRs);
        }
        return consultations;
    }

    public void addConsultation(Consultation consultation) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // get db connection
            myConn = dataSource.getConnection();

            // create sql for insert
            String sql = "insert into consultation "
                    + "(dateConsultation, id_medecin, id_ticket, motif) "
                    + "values (?, ?, ?, ?)";

            myStmt = myConn.prepareStatement(sql);

//            myStmt.setDate(1, (java.sql.Date) ticket.getDatePrise());
            myStmt.setDate(1, (Date) consultation.getDate());
            myStmt.setInt(2, consultation.getMedecin_id());
            myStmt.setInt(3, consultation.getTicket_id());
            myStmt.setString(4, consultation.getMotif());

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
