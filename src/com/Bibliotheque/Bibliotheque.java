package com.Soukaina.Bibliotheque;

/**
 * Main library system class that coordinates all operations
 */
public class Bibliotheque {
    private Catalogue catalogue;
    private Utilisateur[] utilisateurs;
    private int nombreUtilisateurs;
    private static final int MAX_UTILISATEURS = 50;

    public Bibliotheque() {
        this.catalogue = new Catalogue();
        this.utilisateurs = new Utilisateur[MAX_UTILISATEURS];
        this.nombreUtilisateurs = 0;
    }

    /**
     * Register a new user
     */
    public boolean inscrireUtilisateur(Utilisateur utilisateur) {
        if (nombreUtilisateurs < MAX_UTILISATEURS) {
            utilisateurs[nombreUtilisateurs] = utilisateur;
            nombreUtilisateurs++;
            System.out.println("User registered successfully: " + utilisateur.getNom());
            return true;
        } else {
            System.out.println("Cannot register user. Maximum capacity reached.");
            return false;
        }
    }

    /**
     * Process a book borrowing request
     */
    public boolean effectuerEmprunts(String numeroId, String titreLivre) {
        // Find user
        Utilisateur utilisateur = null;
        for (int i = 0; i < nombreUtilisateurs; i++) {
            if (utilisateurs[i] != null && utilisateurs[i].getNumeroId().equals(numeroId)) {
                utilisateur = utilisateurs[i];
                break;
            }
        }
        
        if (utilisateur == null) {
            System.out.println("User not found with ID: " + numeroId);
            return false;
        }

        // Find book
        Livre livre = catalogue.rechercher(titreLivre);
        if (livre == null) {
            System.out.println("Book not found: " + titreLivre);
            return false;
        }

        // Process borrowing using polymorphism
        return utilisateur.emprunterLivre(livre);
    }

    /**
     * Display borrowing statistics by user type
     */
    public void afficherStatistiquesEmprunts() {
        int empruntsEtudiants = 0;
        int empruntsProfesseurs = 0;

        for (int i = 0; i < nombreUtilisateurs; i++) {
            if (utilisateurs[i] != null) {
                if (utilisateurs[i] instanceof Etudiant) {
                    empruntsEtudiants += utilisateurs[i].getNombreEmprunts();
                } else if (utilisateurs[i] instanceof Professeur) {
                    empruntsProfesseurs += utilisateurs[i].getNombreEmprunts();
                }
            }
        }

        System.out.println("\n=== BORROWING STATISTICS ===");
        System.out.println("Student borrowings: " + empruntsEtudiants);
        System.out.println("Professor borrowings: " + empruntsProfesseurs);
        System.out.println("Total borrowings: " + (empruntsEtudiants + empruntsProfesseurs));
    }

    /**
     * Display all registered users
     */
    public void afficherTousLesUtilisateurs() {
        System.out.println("\n=== REGISTERED USERS ===");
        boolean found = false;
        for (int i = 0; i < nombreUtilisateurs; i++) {
            if (utilisateurs[i] != null) {
                System.out.println(utilisateurs[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No users registered.");
        }
    }

    public Catalogue getCatalogue() {
        return catalogue;
    }
}