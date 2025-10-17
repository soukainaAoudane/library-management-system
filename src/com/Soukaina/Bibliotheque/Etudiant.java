package com.Soukaina.Bibliotheque;

/**
 * Represents a Student user with specific borrowing rules
 */
public class Etudiant extends Utilisateur {
    private String niveauEtude;

    public Etudiant(String nom, String prenom, String numeroId, String niveauEtude) {
        super(nom, prenom, numeroId);
        this.niveauEtude = niveauEtude;
    }

    public String getNiveauEtude() { return niveauEtude; }
    public void setNiveauEtude(String niveauEtude) { this.niveauEtude = niveauEtude; }

    @Override
    public boolean peutEmprunter() {
        return nombreEmprunts < 3; // Students can borrow up to 3 books
    }

    @Override
    public int getLimiteEmprunt() {
        return 3;
    }

    @Override
    public String toString() {
        return String.format("Student[Name: %s %s, ID: %s, Level: %s, Borrowed: %d/%d]", 
                prenom, nom, numeroId, niveauEtude, nombreEmprunts, getLimiteEmprunt());
    }
}