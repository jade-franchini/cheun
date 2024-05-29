public class App {
    public static void main(String[] args) throws Exception {

        // Création d'une instance de la classe Classe
        Classe classe1 = new Classe(1, "Classe A", "Niveau 1");
        Classe classe2 = new Classe(2, "Classe B", "Niveau 2");
        Classe classe3 = new Classe(3, "Classe C", "Niveau 3");
        // Création d'une instance de la classe Eleve
        Eleve eleve1 = new Eleve(1, "Doe", "John", 1); // Supposons que l'élève appartient à la classe d'id 1
        // Création d'une instance de la classe Enseignant
        Enseignant enseignant1 = new Enseignant(1, "Smith", "Alice", "Mathématiques", 1, 1); // Supposons que l'enseignant enseigne la matière d'id 1 à la classe d'id 1
        // Création d'une instance de la classe Matiere
        Matiere matiere1 = new Matiere(1, "Mathématiques", "Description de la matière");
        // Création d'une instance de la classe Note
        Note note1 = new Note(1, 1, 1, 18.5); // Supposons que la note est attribuée à l'élève d'id 1 pour la matière d'id 1
    
        System.out.println(classe1.getIdClasse());
        System.out.println(classe1.getNomClasse());
        System.out.println(classe1.getNiveau());

        
    }
}
