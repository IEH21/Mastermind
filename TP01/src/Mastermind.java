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
import java.util.Random;

/**
 * Représente le jeu Mastermind.
 */
public class Mastermind {
    private Serie solution;
    private int nbEssais;
    private List<Serie> essais;
    private List<Serie> resultats;

    /**
     * Constructeur de la classe Mastermind avec une solution donnée.
     * @param uneSolution La solution du jeu.
     */
    public Mastermind(Serie uneSolution) {
        this.solution = uneSolution;
        this.nbEssais = 0;
        this.essais = new ArrayList<>();
        this.resultats = new ArrayList<>();
    }

    /**
     * Constructeur de la classe Mastermind avec une solution aléatoire.
     */
    public Mastermind() {
        this(genererSolutionAleatoire());
    }

    /**
     * Retourne la solution du jeu.
     * @return La série de couleurs représentant la solution.
     */
    public Serie getSolution() {
        return solution;
    }

    /**
     * Retourne le nombre d'essais effectués.
     * @return Le nombre d'essais.
     */
    public int getNbEssais() {
        return nbEssais;
    }

    /**
     * Tente une solution et retourne le résultat.
     * @param essai La série de couleurs proposée.
     * @return Le résultat de la comparaison avec la solution.
     */
    public Serie essayer(Serie essai) {
        nbEssais++;
        essais.add(essai);
        Serie resultat = solution.comparer(essai);
        resultats.add(resultat);
        return resultat;
    }

    /**
     * Retourne une représentation sous forme de chaîne de tous les essais et leurs résultats.
     * @return Une chaîne contenant l'historique des essais et résultats.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < essais.size(); i++) {
            sb.append(essais.get(i)).append(" : ").append(resultats.get(i)).append("\n");
        }
        return sb.toString();
    }

    /**
     * Génère une solution aléatoire pour le jeu.
     * @return Une série de 5 couleurs choisies aléatoirement.
     */
    private static Serie genererSolutionAleatoire() {
        Couleur[] couleursDisponibles = {
            new Couleur("Rouge", 'R'),
            new Couleur("Jaune", 'J'),
            new Couleur("Bleu", 'B'),
            new Couleur("Orange", 'O'),
            new Couleur("Vert", 'V'),
            new Couleur("Gris", 'G'),
            new Couleur("Noir", 'N'),
            new Couleur("Turquoise", 'T')
        };
        
        Random random = new Random();
        Serie solution = new Serie();
        for (int i = 0; i < 5; i++) {
            solution.ajouterCouleur(couleursDisponibles[random.nextInt(couleursDisponibles.length)]);
        }
        return solution;
    }
}