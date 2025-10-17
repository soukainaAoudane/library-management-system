package com.Soukaina.Bibliotheque;

/**
 * Abstract class representing a Library User
 * Defines common properties and methods for all user types
 */
public abstract class Utilisateur {
    protected String nom;
    protected String prenom;
    protected String numeroId;
    protected Livre[] livresEmpruntes;
    protected int nombreEmprunts;
    protected static final int TAILLE_MAX = 15;

    public Utilisateur(String nom, String prenom, String numeroId) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroId = numeroId;
        this.livresEmpruntes = new Livre[TAILLE_MAX];
        this.nombreEmprunts = 0;
    }

    // Getters and setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    
    public String getNumeroId() { return numeroId; }
    public void setNumeroId(String numeroId) { this.numeroId = numeroId; }
    
    public int getNombreEmprunts() { return nombreEmprunts; }

    /**
     * Check if user can borrow more books
     */
    public abstract boolean peutEmprunter();

    /**
     * Get user's borrowing limit
     */
    public abstract int getLimiteEmprunt();

    /**
     * Borrow a book
     */
    public boolean emprunterLivre(Livre livre) {
        if (!peutEmprunter()) {
            System.out.println("Borrowing limit reached. Cannot borrow more books.");
            return false;
        }
        if (!livre.isDisponible()) {
            System.out.println("Book is not available: " + livre.getTitre());
            return false;
        }
        
        livresEmpruntes[nombreEmprunts] = livre;
        nombreEmprunts++;
        livre.setDisponible(false);
        System.out.println("Book borrowed successfully: " + livre.getTitre());
        return true;
    }

    @Override
    public String toString() {
        return String.format("User[Name: %s %s, ID: %s, Borrowed: %d/%d]", 
                prenom, nom, numeroId, nombreEmprunts, getLimiteEmprunt());
    }
}