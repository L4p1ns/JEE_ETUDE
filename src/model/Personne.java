package model;

public abstract class Personne {
    protected String matricule;
    protected String nom;
    protected String dateNaissance;
    protected String tel;
    protected String sexe;
    private int id;

    public Personne(int id, String matricule, String nom, String dateNaissance2, String tel, String sexe) {
        super();
        this.id = id;
        this.matricule = matricule;
        this.nom = nom;
        this.dateNaissance = dateNaissance2;
        this.tel = tel;
        this.sexe = sexe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String string) {
        this.dateNaissance = string;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }


}
