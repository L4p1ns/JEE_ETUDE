package dbutil;

import model.Specialite;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SpecialiteDbUtil {
    private DataSource dataSource;

    public SpecialiteDbUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Specialite> getSpecialites() throws Exception {
        List<Specialite> specialites = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = dataSource.getConnection();

            String sql = "select * from specialite";

            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery(sql);
            while (myRs.next()) {
                int id = myRs.getInt("id");
                String nom = myRs.getString("nom");
                int tarif = myRs.getInt("tarif");
                int personnel_id = myRs.getInt("personnel_id");
                Specialite specialite = new Specialite(id, nom, tarif, personnel_id);
                specialites.add(specialite);
            }
        } finally {
            // close JDBC objects
            close(myConn, myStmt, myRs);
        }
        return specialites;
    }

    public void addSpecialite(Specialite specialite) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // get db connection
            myConn = dataSource.getConnection();

            // create sql for insert
            String sql = "insert into specialite "
                    + "(nom, tarif, personnel_id) "
                    + "values (?, ?, ?)";

            myStmt = myConn.prepareStatement(sql);

            myStmt.setString(1, specialite.getNom());
            myStmt.setInt(2, specialite.getTarif());
            myStmt.setInt(3, specialite.getPersonnel_id());

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
