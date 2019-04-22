package model;

public class Personnel extends Personne {
    private String email;
    private String password;
    private String domaine;
    private String prenom;
    private String type;

    public Personnel(Integer id, String matricule, String nom, String dateNaissance2, String tel, String sexe, String email, String password, String domaine, String prenom, String type) {
        super(id, matricule, nom, dateNaissance2, tel, sexe);
        this.email = email;
        this.password = password;
        this.domaine = domaine;
        this.type = type;
        this.prenom = prenom;
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

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
