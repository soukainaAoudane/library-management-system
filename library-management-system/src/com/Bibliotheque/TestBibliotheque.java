package com.Soukaina.Bibliotheque;

/**
 * Main test class to demonstrate the library system functionality
 */
public class TestBibliotheque {
    
    public static void main(String[] args) {
        // Set encoding for proper character display
        
        System.out.println("🚀 LIBRARY MANAGEMENT SYSTEM - DEMONSTRATION\n");
        
        Bibliotheque biblio = new Bibliotheque();
        creerDonneesTest(biblio);
        
        // Test searches
        testerRecherches(biblio);
        
        // Test borrowing operations
        testerEmprunts(biblio);
        
        // Display statistics
        afficherStatistiques(biblio);
        
        // Test limits
        testerLimites(biblio);
        
        System.out.println("\n✅ DEMONSTRATION COMPLETED SUCCESSFULLY");
    }

    /**
     * Test various search functionalities
     */
    public static void testerRecherches(Bibliotheque biblio) {
        System.out.println("=== SEARCH TESTS ===");
        
        // Search by title
        Livre livreTrouve = biblio.getCatalogue().rechercher("1984");
        if (livreTrouve != null) {
            System.out.println("✓ Found by title: " + livreTrouve.getTitre());
        }
        
        // Search by title and author
        Livre livreTrouve2 = biblio.getCatalogue().rechercher("Dune", "Frank Herbert");
        if (livreTrouve2 != null) {
            System.out.println("✓ Found by title and author: " + livreTrouve2.getTitre());
        }
        
        // Search by year
        Livre[] livres1949 = biblio.getCatalogue().rechercher(1949);
        System.out.println("✓ Found " + livres1949.length + " books from 1949");
    }

    /**
     * Test borrowing operations
     */
    public static void testerEmprunts(Bibliotheque biblio) {
        System.out.println("\n=== BORROWING TESTS ===");
        
        // Successful borrowings
        biblio.effectuerEmprunts("ETU001", "1984");
        biblio.effectuerEmprunts("ETU001", "Le Petit Prince");
        biblio.effectuerEmprunts("PROF001", "Fondation");
        
        // Try to borrow unavailable book
        biblio.effectuerEmprunts("ETU002", "1984"); // Should fail - book already borrowed
    }

    /**
     * Display all statistics
     */
    public static void afficherStatistiques(Bibliotheque biblio) {
        System.out.println("\n=== SYSTEM STATISTICS ===");
        biblio.getCatalogue().afficherLivresDisponibles();
        biblio.getCatalogue().statistiquesParGenre();
        biblio.afficherStatistiquesEmprunts();
        biblio.afficherTousLesUtilisateurs();
    }

    /**
     * Test user borrowing limits
     */
    public static void testerLimites(Bibliotheque biblio) {
        System.out.println("\n=== LIMIT TESTS ===");
        
        // Student should reach limit (3 books)
        biblio.effectuerEmprunts("ETU001", "Dune"); // 3rd book - should succeed
        biblio.effectuerEmprunts("ETU001", "L'Etranger"); // 4th book - should fail
    }

    /**
     * Create test data for the demonstration
     */
    public static void creerDonneesTest(Bibliotheque biblio) {
        System.out.println("=== CREATING TEST DATA ===");
        
        // Create test books
        Livre[] livresTest = {
            new Livre("1984", "George Orwell", "978-0451524935", "Science-Fiction", true, 1949),
            new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", "978-0156013987", "Fiction", true, 1943),
            new Livre("Fondation", "Isaac Asimov", "978-0553293357", "Science-Fiction", true, 1951),
            new Livre("Dune", "Frank Herbert", "978-0441172719", "Science-Fiction", true, 1965),
            new Livre("L'Etranger", "Albert Camus", "978-0679720201", "Philosophy", true, 1942),
            new Livre("Orgueil et Préjugés", "Jane Austen", "978-0141439518", "Romance", true, 1813)
        };
        
        for (Livre livre : livresTest) {
            biblio.getCatalogue().ajouterLivre(livre);
        }
        System.out.println("✓ " + livresTest.length + " books added to catalog");
        
        // Create test users
        Etudiant etudiant1 = new Etudiant("Dupont", "Jean", "ETU001", "Licence");
        Etudiant etudiant2 = new Etudiant("Martin", "Marie", "ETU002", "Master");
        
        Professeur professeur1 = new Professeur("Durand", "Pierre", "PROF001", "Computer Science", true);
        Professeur professeur2 = new Professeur("Leroy", "Sophie", "PROF002", "Literature", false);
        
        biblio.inscrireUtilisateur(etudiant1);
        biblio.inscrireUtilisateur(etudiant2);
        biblio.inscrireUtilisateur(professeur1);
        biblio.inscrireUtilisateur(professeur2);
        
        System.out.println("✓ 4 users registered (2 students, 2 professors)");
    }
}