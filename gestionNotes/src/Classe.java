public class Classe {
    private int idClasse;
    private String nomClasse;
    private String niveau;

    // Constructeur
    public Classe(int idClasse, String nomClasse, String niveau) {
        this.idClasse = idClasse;
        this.nomClasse = nomClasse;
        this.niveau = niveau;
    }

        // Getter pour idClasse
    public int getIdClasse() {
        return idClasse;
    }

    // Setter pour idClasse
    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    // Getter pour nomClasse
    public String getNomClasse() {
        return nomClasse;
    }

    // Setter pour nomClasse
    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    // Getter pour niveau
    public String getNiveau() {
        return niveau;
    }

    // Setter pour niveau
    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
}
