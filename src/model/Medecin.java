package model;

public class Medecin extends Personne {

    private String email;
    private String password;
    private String grade;

    public Medecin(int id, String matricule, String nom, String dateNaissance, String tel, String sexe) {
        super(id, matricule, nom, dateNaissance, tel, sexe);
        // TODO Auto-generated constructor stub
        this.email = email;
        this.password = password;
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }


}
