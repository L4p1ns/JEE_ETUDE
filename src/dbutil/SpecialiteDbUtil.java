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

    public void deleteSpecialite(String specialiteId) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {

            int idSpecialite = Integer.parseInt(specialiteId);

            // get connection to database
            myConn = dataSource.getConnection();

            // create sql to delete personnel
            String sql = "delete from specialite where id=?";

            // prepare statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setInt(1, idSpecialite);

            // execute sql statement
            myStmt.execute();
        } finally {
            // clean up JDBC code
            close(myConn, myStmt, null);
        }
    }

    public void updateSpecialite(Specialite theSpecialite) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // get db connection
            myConn = dataSource.getConnection();

            // create SQL update statement
            String sql = "update specialite "
                    + "set nom=?, tarif=?, personnel_id=? "
                    + "where id=?";

            // prepare statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setString(1, theSpecialite.getNom());
            myStmt.setInt(2, theSpecialite.getTarif());
            myStmt.setInt(3, theSpecialite.getPersonnel_id());
            myStmt.setInt(4, theSpecialite.getId());

            // execute SQL statement
            myStmt.execute();
        } finally {
            // clean up JDBC objects
            close(myConn, myStmt, null);
        }
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

    public Specialite getSpecialite(String idspecialite) throws Exception {
        Specialite specialite = null;

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            int specialiteId = Integer.parseInt(idspecialite);

            // get connection to database
            myConn = dataSource.getConnection();

            // create sql to get selected patient
            String sql = "select id, nom, tarif, personnel_id from specialite where id=?";

            // create prepared statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setInt(1, specialiteId);

            // execute statement
            myRs = myStmt.executeQuery();

            // retrieve data from result set row
            if (myRs.next()) {
                Integer id = myRs.getInt("id");
                String nom = myRs.getString("nom");
                Integer tarif = myRs.getInt("tarif");
                Integer personnel_id = myRs.getInt("personnel_id");


                specialite = new Specialite(id, nom, tarif, personnel_id);
            } else {
                throw new Exception("Could not find specialite id: " + specialiteId);
            }

            return specialite;
        } finally {
            // clean up JDBC objects
            close(myConn, myStmt, myRs);
        }
    }
}
