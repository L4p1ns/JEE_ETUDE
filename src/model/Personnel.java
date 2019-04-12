package model;

public class Personnel {
    private String matricule;
    private String fonction;

    public Personnel(String matricule, String fonction) {
        super();
        this.matricule = matricule;
        this.fonction = fonction;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }
}
