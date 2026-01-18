/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author imaneelharch
 */
public class Couleur {
    private String nom;
    private char abreviation;

    /**
     * Constructeur de la classe Couleur.
     * @param unNom Le nom complet de la couleur.
     * @param uneAbreviation L'abréviation (un caractère) de la couleur.
     */
    public Couleur(String unNom, char uneAbreviation) {
        this.nom = unNom;
        this.abreviation = uneAbreviation;
    }

    /**
     * Retourne le nom de la couleur.
     * @return Le nom complet de la couleur.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne l'abréviation de la couleur.
     * @return L'abréviation (un caractère) de la couleur.
     */
    public char getAbreviation() {
        return abreviation;
    }

    /**
     * Compare cette couleur avec une autre.
     * @param uneCouleur La couleur à comparer.
     * @return true si les couleurs sont identiques, false sinon.
     */
    public boolean equals(Couleur uneCouleur) {
        return this.nom.equals(uneCouleur.nom) && this.abreviation == uneCouleur.abreviation;
    }

    /**
     * Retourne une représentation sous forme de chaîne de la couleur.
     * @return L'abréviation de la couleur.
     */
    @Override
    public String toString() {
        return String.valueOf(abreviation);
    }
}
