package com.Soukaina.Bibliotheque;

/**
 * Represents a Book in the library system
 * Contains book details and manages availability status
 */
public class Livre {
    private String titre;
    private String auteur;
    private String isbn;
    private String genre;
    private boolean disponible;
    private int anneePublication;

    /**
     * Constructor to create a new Book
     */
    public Livre(String titre, String auteur, String isbn, String genre, boolean disponible, int anneePublication) {
        this.titre = titre;
        this.auteur = auteur;
        this.isbn = isbn;
        this.genre = genre;
        this.disponible = disponible;
        this.anneePublication = anneePublication;
    }

    // Getters and setters with English comments
    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }
    
    public String getAuteur() { return auteur; }
    public void setAuteur(String auteur) { this.auteur = auteur; }
    
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    
    public int getAnneePublication() { return anneePublication; }
    public void setAnneePublication(int anneePublication) { this.anneePublication = anneePublication; }

    /**
     * Borrow this book if available
     */
    public void emprunter() {
        if (disponible) {
            disponible = false;
            System.out.println("Book successfully borrowed: " + titre);
        } else {
            System.out.println("Book not available: " + titre);
        }
    }

    /**
     * Return this book to the library
     */
    public void retourner() {
        if (!disponible) {
            disponible = true;
            System.out.println("Book successfully returned: " + titre);
        } else {
            System.out.println("Book was already available: " + titre);
        }
    }

    @Override
    public String toString() {
        return String.format("Book[Title: %s, Author: %s, ISBN: %s, Genre: %s, Year: %d, Available: %s]",
                titre, auteur, isbn, genre, anneePublication, disponible ? "Yes" : "No");
    }
}