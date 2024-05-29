public class Matiere {
    private int idMatiere;
    private String nomMatiere;
    private String description;

    // Constructeur
    public Matiere(int idMatiere, String nomMatiere, String description) {
        this.idMatiere = idMatiere;
        this.nomMatiere = nomMatiere;
        this.description = description;
    }

    // Getter pour idMatiere
    public int getIdMatiere() {
        return idMatiere;
    }

    // Setter pour idMatiere
    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    // Getter pour nomMatiere
    public String getNomMatiere() {
        return nomMatiere;
    }

    // Setter pour nomMatiere
    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    // Getter pour description
    public String getDescription() {
        return description;
    }

    // Setter pour description
    public void setDescription(String description) {
        this.description = description;
    }
}

