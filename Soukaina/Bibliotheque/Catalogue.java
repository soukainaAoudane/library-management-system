package com.Soukaina.Bibliotheque;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages the library's book catalog with search and statistics features
 */
public class Catalogue {
    private Livre[] livres;
    private int nombreLivres;
    private static final int TAILLE_MAX = 100;

    public Catalogue() {
        this.livres = new Livre[TAILLE_MAX];
        this.nombreLivres = 0;
    }

    /**
     * Add a book to the catalog
     */
    public boolean ajouterLivre(Livre livre) {
        if (nombreLivres < TAILLE_MAX) {
            livres[nombreLivres] = livre;
            nombreLivres++;
            System.out.println("Book added successfully: " + livre.getTitre());
            return true;
        } else {
            System.out.println("Catalog is full. Cannot add more books.");
            return false;
        }
    }

    /**
     * Search book by title
     */
    public Livre rechercher(String titre) {
        for (int i = 0; i < nombreLivres; i++) {
            if (livres[i] != null && livres[i].getTitre().equalsIgnoreCase(titre)) {
                return livres[i];
            }
        }
        return null;
    }

    /**
     * Search book by title and author
     */
    public Livre rechercher(String titre, String auteur) {
        for (int i = 0; i < nombreLivres; i++) {
            if (livres[i] != null && 
                livres[i].getTitre().equalsIgnoreCase(titre) && 
                livres[i].getAuteur().equalsIgnoreCase(auteur)) {
                return livres[i];
            }
        }
        return null;
    }

    /**
     * Search books by publication year
     */
    public Livre[] rechercher(int anneePublication) {
        int count = 0;
        // First pass: count matching books
        for (int i = 0; i < nombreLivres; i++) {
            if (livres[i] != null && livres[i].getAnneePublication() == anneePublication) {
                count++;
            }
        }
        
        // Second pass: populate result array
        Livre[] resultats = new Livre[count];
        int index = 0;
        for (int i = 0; i < nombreLivres; i++) {
            if (livres[i] != null && livres[i].getAnneePublication() == anneePublication) {
                resultats[index++] = livres[i];
            }
        }
        return resultats;
    }

    /**
     * Display all available books
     */
    public void afficherLivresDisponibles() {
        System.out.println("\n=== AVAILABLE BOOKS ===");
        boolean found = false;
        for (int i = 0; i < nombreLivres; i++) {
            if (livres[i] != null && livres[i].isDisponible()) {
                System.out.println(livres[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available books found.");
        }
    }

    /**
     * Display statistics by genre
     */
    public void statistiquesParGenre() {
        Map<String, Integer> genreStats = new HashMap<>();
        
        for (int i = 0; i < nombreLivres; i++) {
            if (livres[i] != null) {
                String genre = livres[i].getGenre();
                genreStats.put(genre, genreStats.getOrDefault(genre, 0) + 1);
            }
        }
        
        System.out.println("\n=== GENRE STATISTICS ===");
        for (Map.Entry<String, Integer> entry : genreStats.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " book(s)");
        }
    }

    public int getNombreLivres() {
        return nombreLivres;
    }
}