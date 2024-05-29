public class Eleve {
    private int idEleve;
    private String nom;
    private String prenom;
    private int idClasse; // Clé étrangère faisant référence à la table "Classes"

    // Constructeur
    public Eleve(int idEleve, String nom, String prenom, int idClasse) {
        this.idEleve = idEleve;
        this.nom = nom;
        this.prenom = prenom;
        this.idClasse = idClasse;
    }


    // Getter pour idEleve
    public int getIdEleve() {
        return idEleve;
    }

    // Setter pour idEleve
    public void setIdEleve(int idEleve) {
        this.idEleve = idEleve;
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

    // Getter pour idClasse
    public int getIdClasse() {
        return idClasse;
    }

    // Setter pour idClasse
    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }
}
