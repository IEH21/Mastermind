/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author imaneelharch
 */
import java.util.Scanner;

/**
 * Classe principale qui gère l'interface utilisateur du jeu Mastermind.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenue dans le jeu Mastermind!");
        System.out.println("Vous devez deviner une série de 5 couleurs parmi : Rouge (R), Jaune (J), Bleu (B), Orange (O), Vert (V), Gris (G), Noir (N), Turquoise (T).");
        System.out.println("Les couleurs peuvent être répétées.");
        System.out.println("Vous avez 12 essais pour deviner la bonne combinaison.");
        System.out.println();

        // Création d'une nouvelle instance du jeu Mastermind et d'un scanner pour lire les entrées utilisateur
        Mastermind jeu = new Mastermind();
        Scanner scanner = new Scanner(System.in);

        // Boucle principale du jeu, limitée à 12 essais
        while (jeu.getNbEssais() < 12) {
            System.out.print("Essai #" + (jeu.getNbEssais() + 1) + ": Entrez votre série de 5 couleurs (ex: R J B O V) : ");
            String input = scanner.nextLine();
            String[] couleurs = input.split(" ");

            if (couleurs.length != 5) {
                System.out.println("Veuillez entrer exactement 5 couleurs.");
                continue;
            }

            Serie serieProposee = new Serie();
            boolean saisieValide = true;

            for (String couleurAbreviation : couleurs) {
                Couleur couleur = CouleurParAbreviation(couleurAbreviation);
                if (couleur == null) {
                    System.out.println("Couleur invalide : " + couleurAbreviation);
                    saisieValide = false;
                    break;
                }
                serieProposee.ajouterCouleur(couleur);
            }

            if (!saisieValide) {
                continue;
            }

            // Tentative de la proposition et récupération du résultat
            Serie resultat = jeu.essayer(serieProposee);
            System.out.println("Résultat : " + resultat.toString());

            // Vérification de la victoire
            if (jeu.getSolution().equals(serieProposee)) {
                System.out.println("Bravo ! Vous avez trouvé la solution en " + jeu.getNbEssais() + " essais.");
                return;
            }
        }

        // Message affiché si le joueur n'a pas trouvé la solution après 12 essais
        System.out.println("Désolé, vous avez épuisé tous vos essais. La solution était : " + jeu.getSolution().toString());
    }

    // Méthode pour obtenir une Couleur à partir de son abréviation
    private static Couleur CouleurParAbreviation(String abreviation) {
        // Cette méthode doit être implémentée en fonction de votre classe Couleur
        // Voici un exemple de ce à quoi cela pourrait ressembler :
        switch (abreviation.toUpperCase()) {
            case "R": return new Couleur("Rouge", 'R');
            case "J": return new Couleur("Jaune", 'J');
            case "B": return new Couleur("Bleu", 'B');
            case "O": return new Couleur("Orange", 'O');
            case "V": return new Couleur("Vert", 'V');
            case "G": return new Couleur("Gris", 'G');
            case "N": return new Couleur("Noir", 'N');
            case "T": return new Couleur("Turquoise", 'T');
            default: return null;
        }
    }
}