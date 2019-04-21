package dbutil;

import model.Personnel;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonnelDbUtil {
    private DataSource dataSource;

    public PersonnelDbUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    static void closeConnexion(Connection myConn, Statement myStmt, ResultSet myRs) {
        try {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public List<Personnel> getPersonnels() throws Exception {
        List<Personnel> personnels = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = dataSource.getConnection();

            String sql = "select * from personnel";

            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery(sql);
            while (myRs.next()) {
                Integer id = myRs.getInt("id");
                String matricule = myRs.getString("matricule");
                String nom = myRs.getString("nom");
                String prenom = myRs.getString("prenom");
                String dateNaissance = myRs.getString("date_naissance");
                String telephone = myRs.getString("telephone");
                String sexe = myRs.getString("sexe");
                String email = myRs.getString("email");
                String password = myRs.getString("password");
                String domaine = myRs.getString("domaine");
                String type = myRs.getString("type");

                Personnel tempPersonnel = new Personnel(id, matricule, nom, dateNaissance, telephone, sexe, email, password, domaine, prenom, type);

                personnels.add(tempPersonnel);
            }
        } finally {
            // close JDBC objects
            close(myConn, myStmt, myRs);
        }
        return personnels;
    }

    public List<Personnel> getMedecins() throws Exception {
        List<Personnel> medecins = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = dataSource.getConnection();

            String sql = "select * from personnel where type='MEDECIN'";

            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery(sql);
            while (myRs.next()) {
                Integer id = myRs.getInt("id");
                String matricule = myRs.getString("matricule");
                String nom = myRs.getString("nom");
                String prenom = myRs.getString("prenom");
                String dateNaissance = myRs.getString("date_naissance");
                String telephone = myRs.getString("telephone");
                String sexe = myRs.getString("sexe");
                String email = myRs.getString("email");
                String password = myRs.getString("password");
                String domaine = myRs.getString("domaine");
                String type = myRs.getString("type");

                Personnel tempPersonnel = new Personnel(id, matricule, nom, dateNaissance, telephone, sexe, email, password, domaine, prenom, type);

                medecins.add(tempPersonnel);
            }
        } finally {
            // close JDBC objects
            close(myConn, myStmt, myRs);
        }
        return medecins;
    }

    public List<Personnel> getCaissiers() throws Exception {
        List<Personnel> caissiers = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = dataSource.getConnection();

            String sql = "select * from personnel where type='CAISSIER'";

            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery(sql);
            while (myRs.next()) {
                Integer id = myRs.getInt("id");
                String matricule = myRs.getString("matricule");
                String nom = myRs.getString("nom");
                String prenom = myRs.getString("prenom");
                String dateNaissance = myRs.getString("date_naissance");
                String telephone = myRs.getString("telephone");
                String sexe = myRs.getString("sexe");
                String email = myRs.getString("email");
                String password = myRs.getString("password");
                String domaine = myRs.getString("domaine");
                String type = myRs.getString("type");

                Personnel tempPersonnel = new Personnel(id, matricule, nom, dateNaissance, telephone, sexe, email, password, domaine, prenom, type);

                caissiers.add(tempPersonnel);
            }
        } finally {
            // close JDBC objects
            close(myConn, myStmt, myRs);
        }
        return caissiers;
    }


    public void addPersonnel(Personnel personnel) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // get db connection
            myConn = dataSource.getConnection();

            // create sql for insert
            String sql = "insert into personnel "
                    + "(nom, date_naissance, telephone, sexe, email, password, domaine, type, prenom, matricule) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            myStmt = myConn.prepareStatement(sql);

            myStmt.setString(1, personnel.getNom());
            myStmt.setString(2, personnel.getDateNaissance());
            myStmt.setString(3, personnel.getTel());
            myStmt.setString(4, personnel.getSexe());
            myStmt.setString(5, personnel.getEmail());
            myStmt.setString(6, personnel.getPassword());
            myStmt.setString(7, personnel.getDomaine());
            myStmt.setString(8, personnel.getType());
            myStmt.setString(9, personnel.getPrenom());
            myStmt.setString(10, personnel.getMatricule());

            // execute sql insert
            myStmt.execute();
        } finally {
            // clean up JDBC objects
            close(myConn, myStmt, null);
        }
    }


    public Personnel getPersonnel(String matriculeId) throws Exception {

        Personnel personnel = null;

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            // get connection to database
            myConn = dataSource.getConnection();

            // create sql to get selected patient
            String sql = "select * from personnel where matricule=?";

            // create prepared statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setString(1, matriculeId);

            // execute statement
            myRs = myStmt.executeQuery();

            // retrieve data from result set row
            if (myRs.next()) {
                String matricule = myRs.getString("matricule");
                String nom = myRs.getString("nom");
                String dateNaissance = myRs.getString("date_naissance");
                String telephone = myRs.getString("telephone");
                String sexe = myRs.getString("sexe");
                String email = myRs.getString("email");
                String password = myRs.getString("password");
                String domain = myRs.getString("domaine");
                String grade = myRs.getString("grade");
                String type = myRs.getString("type");

                personnel = new Personnel(null, matricule, nom, dateNaissance, telephone, sexe, email, password, domain, grade, type);
            } else {
                throw new Exception("Could not find personnel matricule: " + matriculeId);
            }

            return personnel;
        } finally {
            // clean up JDBC objects
            close(myConn, myStmt, myRs);
        }
    }

    public Personnel getPersonnelByEmailAndPassword(String email, String password) throws Exception {

        Personnel personnel = null;

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            // get connection to database
            myConn = dataSource.getConnection();

            // create sql to get selected patient
            String sql = "select * from personnel where email=? AND password=?";

            // create prepared statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setString(1, email);
            myStmt.setString(2, password);

            // execute statement
            myRs = myStmt.executeQuery();

            // retrieve data from result set row
            if (myRs.next()) {
                Integer id = myRs.getInt("id");
                String matricule = myRs.getString("matricule");
                String nom = myRs.getString("nom");
                String prenom = myRs.getString("prenom");
                String dateNaissance = myRs.getString("date_naissance");
                String telephone = myRs.getString("telephone");
                String sexe = myRs.getString("sexe");
                String emailP = myRs.getString("email");
                String passwordP = myRs.getString("password");
                String domain = myRs.getString("domaine");
                String type = myRs.getString("type");

                personnel = new Personnel(id, matricule, nom, dateNaissance, telephone, sexe, emailP, passwordP, domain, prenom, type);
            } else {
                System.out.println("Email ou mot de passe incorrect.");
            }

            return personnel;
        } finally {
            // clean up JDBC objects
            close(myConn, myStmt, myRs);
        }
    }


    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
        closeConnexion(myConn, myStmt, myRs);
    }
}
