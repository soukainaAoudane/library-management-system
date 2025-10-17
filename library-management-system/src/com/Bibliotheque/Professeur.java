package com.Soukaina.Bibliotheque;

/**
 * Represents a Professor user with specific borrowing rules based on tenure status
 */
public class Professeur extends Utilisateur {
    private String departement;
    private boolean estTitulaire;

    public Professeur(String nom, String prenom, String numeroId, String departement, boolean estTitulaire) {
        super(nom, prenom, numeroId);
        this.departement = departement;
        this.estTitulaire = estTitulaire;
    }

    public String getDepartement() { return departement; }
    public void setDepartement(String departement) { this.departement = departement; }
    
    public boolean isEstTitulaire() { return estTitulaire; }
    public void setEstTitulaire(boolean estTitulaire) { this.estTitulaire = estTitulaire; }

    @Override
    public boolean peutEmprunter() {
        int limite = estTitulaire ? 10 : 5;
        return nombreEmprunts < limite;
    }

    @Override
    public int getLimiteEmprunt() {
        return estTitulaire ? 10 : 5;
    }

    @Override
    public String toString() {
        return String.format("Professor[Name: %s %s, ID: %s, Department: %s, Tenured: %s, Borrowed: %d/%d]", 
                prenom, nom, numeroId, departement, estTitulaire ? "Yes" : "No", 
                nombreEmprunts, getLimiteEmprunt());
    }
}