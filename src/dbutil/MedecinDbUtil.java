package dbutil;

import model.Medecin;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MedecinDbUtil {
    private DataSource dataSource;

    public MedecinDbUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Medecin> getMedecins() throws Exception {
        List<Medecin> medecins = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = dataSource.getConnection();

            String sql = "select * from medecin";

            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery(sql);
            while (myRs.next()) {
                int id = myRs.getInt("id");
                String matricule = myRs.getString("matricule");
                String nom = myRs.getString("nom");
                String dateNaissance = myRs.getString("dateNaissance");
                String telephone = myRs.getString("telephone");
                String sexe = myRs.getString("sexe");
                String email = myRs.getString("email");
                String password = myRs.getString("password");
                String grade = myRs.getString("grade");

                Medecin medecin = new Medecin(id, matricule, nom, dateNaissance, telephone, sexe, email, password, grade);
                medecins.add(medecin);
            }
        } finally {
            // close JDBC objects
            close(myConn, myStmt, myRs);
        }
        return medecins;
    }

    // Add medecin
    public void addMedecin(Medecin medecin) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // get db connection
            myConn = dataSource.getConnection();

            // create sql for insert
            String sql = "insert into medecin "
                    + "(matricule, nom, dateNaissance, telephone, sexe, email, password, grade) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?)";

            myStmt = myConn.prepareStatement(sql);

            myStmt.setInt(1, Integer.parseInt(medecin.getMatricule()));
            myStmt.setString(2, medecin.getNom());
            myStmt.setString(3, medecin.getDateNaissance());
            myStmt.setString(4, medecin.getTel());
            myStmt.setString(5, medecin.getSexe());
            myStmt.setString(6, medecin.getEmail());
            myStmt.setString(7, medecin.getPassword());
            myStmt.setString(8, medecin.getGrade());

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
