public class Enseignant {
    private int idEnseignant;
    private String nom;
    private String prenom;
    private String specialite;
    private int idClasse; // Clé étrangère faisant référence à la table "Classes"
    private int idMatiere; // Clé étrangère faisant référence à la table "Matieres"

    // Constructeur
    public Enseignant(int idEnseignant, String nom, String prenom, String specialite, int idClasse, int idMatiere) {
        this.idEnseignant = idEnseignant;
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.idClasse = idClasse;
        this.idMatiere = idMatiere;
    }

    // Getter pour idEnseignant
    public int getIdEnseignant() {
        return idEnseignant;
    }

    // Setter pour idEnseignant
    public void setIdEnseignant(int idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    // Getter pour nom
    public String getNom() {
        return nom;
    }

    // Setter pour nom
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter pour prenom
    public String getPrenom() {
        return prenom;
    }

    // Setter pour prenom
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    // Getter pour specialite
    public String getSpecialite() {
        return specialite;
    }

    // Setter pour specialite
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    // Getter pour idClasse
    public int getIdClasse() {
        return idClasse;
    }

    // Setter pour idClasse
    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    // Getter pour idMatiere
    public int getIdMatiere() {
        return idMatiere;
    }

    // Setter pour idMatiere
    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }
}

