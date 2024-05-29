public class Note {
    private int idNote;
    private int idEleve; // Clé étrangère faisant référence à la table "Eleves"
    private int idMatiere; // Clé étrangère faisant référence à la table "Matieres"
    private double valeur;

    // Constructeur
    public Note(int idNote, int idEleve, int idMatiere, double valeur) {
        this.idNote = idNote;
        this.idEleve = idEleve;
        this.idMatiere = idMatiere;
        this.valeur = valeur;
    }

    // Getter pour idNote
    public int getIdNote() {
        return idNote;
    }

    // Setter pour idNote
    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    // Getter pour idEleve
    public int getIdEleve() {
        return idEleve;
    }

    // Setter pour idEleve
    public void setIdEleve(int idEleve) {
        this.idEleve = idEleve;
    }

    // Getter pour idMatiere
    public int getIdMatiere() {
        return idMatiere;
    }

    // Setter pour idMatiere
    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    // Getter pour valeur
    public double getValeur() {
        return valeur;
    }

    // Setter pour valeur
    public void setValeur(double valeur) {
        this.valeur = valeur;
    }
}

