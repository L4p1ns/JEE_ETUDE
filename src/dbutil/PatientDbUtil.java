package dbutil;

import model.Patient;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PatientDbUtil {
    private DataSource dataSource;

    public PatientDbUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Patient> getPatients() throws Exception {
        List<Patient> patients = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            // get a connection
            myConn = dataSource.getConnection();

            // create sql statement
            String sql = "select * from patient";

            myStmt = myConn.createStatement();

            // execute query
            myRs = myStmt.executeQuery(sql);
            // process result set
            while (myRs.next()) {

                // retrieve data from result set row
                int id = myRs.getInt("id");
                String matricule = myRs.getString("matricule");
                String nom = myRs.getString("nom");
                String dateNaissance = myRs.getString("dateNaissance");
                String telephone = myRs.getString("telephone");
                String sexe = myRs.getString("sexe");
                String groupeSanguin = myRs.getString("groupeSanguin");

                // create new patient object
                Patient tempPatient = new Patient(id, matricule, nom, dateNaissance, telephone, sexe, groupeSanguin);

                // add it to the list of patients
                patients.add(tempPatient);
            }
        } finally {
            // close JDBC objects
            close(myConn, myStmt, myRs);
        }
        return patients;
    }

    // Ajouter un Patient
    public void addPatient(Patient patient) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // get db connection
            myConn = dataSource.getConnection();

            // create sql for insert
            String sql = "insert into patient "
                    + "(matricule, nom, dateNaissance, telephone, sexe, groupeSanguin) "
                    + "values (?, ?, ?, ?, ?, ?)";

            myStmt = myConn.prepareStatement(sql);

            // set the param values for the patient
            myStmt.setString(1, patient.getMatricule());
            myStmt.setString(2, patient.getNom());
            myStmt.setString(3, patient.getDateNaissance());
            myStmt.setString(4, patient.getTel());
            myStmt.setString(5, patient.getSexe());
            myStmt.setString(6, patient.getGroupeSanguin());

            // execute sql insert
            myStmt.execute();
        } finally {
            // clean up JDBC objects
            close(myConn, myStmt, null);
        }
    }

    public Patient getPatient(String thePatientId) throws Exception {

        Patient patient = null;

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        int patientId;

        try {
            // Convert id to int
            patientId = Integer.parseInt(thePatientId);

            // get connection to database
            myConn = dataSource.getConnection();

            // create sql to get selected patient
            String sql = "select * from patient where id=?";

            // create prepared statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setInt(1, patientId);

            // execute statement
            myRs = myStmt.executeQuery();

            // retrieve data from result set row
            if (myRs.next()) {
                String matricule = myRs.getString("matricule");
                String nom = myRs.getString("nom");
                String dateNaissance = myRs.getString("dateNaissance");
                String telephone = myRs.getString("telephone");
                String sexe = myRs.getString("sexe");
                String groupeSanguin = myRs.getString("groupeSanguin");

                // use the patient during construction
                patient = new Patient(patientId, matricule, nom, dateNaissance, telephone, sexe, groupeSanguin);
            } else {
                throw new Exception("Could not find patient matricule: " + patientId);
            }

            return patient;
        } finally {
            // clean up JDBC objects
            close(myConn, myStmt, myRs);
        }
    }

    // Update patient
    public void updatePatient(Patient thePatient) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // get db connection
            myConn = dataSource.getConnection();

            // create SQL update statement
            String sql = "update patient "
                    + "set matricule=?, nom=?, dateNaissance=?, telephone=?, sexe=?, groupeSanguin=? "
                    + "where id=?";

            // prepare statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setString(1, thePatient.getMatricule());
            myStmt.setString(2, thePatient.getNom());
            myStmt.setString(3, thePatient.getDateNaissance());
            myStmt.setString(4, thePatient.getTel());
            myStmt.setString(5, thePatient.getSexe());
            myStmt.setString(6, thePatient.getGroupeSanguin());
            myStmt.setInt(7, thePatient.getId());

            // execute SQL statement
            myStmt.execute();
        } finally {
            // clean up JDBC objects
            close(myConn, myStmt, null);
        }
    }

    // Delete Patient
    public void deletePatient(String patientId) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // convert patient id to int
            int idPatient = Integer.parseInt(patientId);

            // get connection to database
            myConn = dataSource.getConnection();

            // create sql to delete patient
            String sql = "delete from patient where id=?";

            // prepare statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setInt(1, idPatient);

            // execute sql statement
            myStmt.execute();
        } finally {
            // clean up JDBC code
            close(myConn, myStmt, null);
        }
    }

    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
        try {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();   // doesn't really close it ... just puts back in connection pool
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
