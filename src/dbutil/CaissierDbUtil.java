package dbutil;

import model.Caissier;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CaissierDbUtil {
    private DataSource dataSource;

    public CaissierDbUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Caissier> getCaissiers() throws Exception {
        List<Caissier> caissiers = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = dataSource.getConnection();

            String sql = "select * from caissier";

            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery(sql);
            while (myRs.next()) {
                int id = myRs.getInt("id");
                String matricule = myRs.getString("matricule");
                String nom = myRs.getString("nom");
                String dateNaissance = myRs.getString("dateNaissance");
                String telephone = myRs.getString("tel");
                String sexe = myRs.getString("sexe");
                String email = myRs.getString("email");
                String password = myRs.getString("password");


                Caissier caissier = new Caissier(id, matricule, nom, dateNaissance, telephone, sexe, email, password);
                caissiers.add(caissier);
            }
        } finally {
            // close JDBC objects
            close(myConn, myStmt, myRs);
        }
        return caissiers;
    }

    public void addCaissier(Caissier caissier) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // get db connection
            myConn = dataSource.getConnection();

            // create sql for insert
            String sql = "insert into caissier "
                    + "(matricule, nom, dateNaissance, tel, sexe, email, password) "
                    + "values (?, ?, ?, ?, ?, ?, ?)";

            myStmt = myConn.prepareStatement(sql);

            myStmt.setInt(1, Integer.parseInt(caissier.getMatricule()));
            myStmt.setString(2, caissier.getNom());
            myStmt.setString(3, caissier.getDateNaissance());
            myStmt.setString(4, caissier.getTel());
            myStmt.setString(5, caissier.getSexe());
            myStmt.setString(6, caissier.getEmail());
            myStmt.setString(7, caissier.getPassword());

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
