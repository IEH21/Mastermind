/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author imaneelharch
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Représente une série de couleurs dans le jeu Mastermind.
 */
public class Serie {
    private List<Couleur> couleurs;

    /**
     * Constructeur de la classe Serie. Crée une série vide.
     */
    public Serie() {
        this.couleurs = new ArrayList<>();
    }

    /**
     * Retourne la couleur à la position spécifiée dans la série.
     * @param position La position de la couleur (0-indexée).
     * @return La couleur à la position donnée.
     * @throws IllegalArgumentException si la position est invalide.
     */
    public Couleur getCouleur(int position) {
        if (position < 0 || position >= couleurs.size()) {
            throw new IllegalArgumentException("Position invalide");
        }
        return couleurs.get(position);
    }

    /**
     * Ajoute une couleur à la fin de la série.
     * @param uneCouleur La couleur à ajouter.
     */
    public void ajouterCouleur(Couleur uneCouleur) {
        couleurs.add(uneCouleur);
    }

    /**
     * Compare cette série avec une autre.
     * @param uneSerie La série à comparer.
     * @return true si les séries sont identiques, false sinon.
     */
    public boolean equals(Serie uneSerie) {
        if (this.couleurs.size() != uneSerie.couleurs.size()) {
            return false;
        }
        for (int i = 0; i < couleurs.size(); i++) {
            if (!this.couleurs.get(i).equals(uneSerie.couleurs.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Compare cette série avec une autre et retourne le résultat.
     * @param uneSerie La série à comparer.
     * @return Une série de couleurs noires et blanches représentant le résultat.
     * @throws IllegalArgumentException si les séries n'ont pas la même taille.
     */
    public Serie comparer(Serie uneSerie) {
        if (this.couleurs.size() != uneSerie.couleurs.size()) {
            throw new IllegalArgumentException("Les séries doivent avoir la même taille");
        }
        
        Serie resultat = new Serie();
        List<Boolean> utilisees = new ArrayList<>(couleurs.size());
        for (int i = 0; i < couleurs.size(); i++) {
            utilisees.add(false);
        }

        // Vérification des noires (couleurs correctes à la bonne position)
        for (int i = 0; i < couleurs.size(); i++) {
            if (this.couleurs.get(i).equals(uneSerie.couleurs.get(i))) {
                resultat.ajouterCouleur(new Couleur("Noir", 'N'));
                utilisees.set(i, true);
            }
        }

        // Vérification des blanches (couleurs correctes à la mauvaise position)
        for (int i = 0; i < couleurs.size(); i++) {
            if (!utilisees.get(i)) {
                for (int j = 0; j < couleurs.size(); j++) {
                    if (i != j && !utilisees.get(j) && this.couleurs.get(i).equals(uneSerie.couleurs.get(j))) {
                        resultat.ajouterCouleur(new Couleur("Blanc", 'B'));
                        utilisees.set(j, true);
                        break;
                    }
                }
            }
        }

        return resultat;
    }

    /**
     * Retourne une représentation sous forme de chaîne de la série.
     * @return Une chaîne contenant les abréviations des couleurs séparées par des espaces.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Couleur c : couleurs) {
            sb.append(c.toString()).append(" ");
        }
        return sb.toString().trim();
    }
}
