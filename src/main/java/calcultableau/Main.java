package calcultableau;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Création du professeur =====");

        UtilisateurTab professeur = null;

        while (professeur == null) {

            try {
                System.out.print("Prénom : ");
                String prenom = scanner.nextLine();

                System.out.print("Nom : ");
                String nom = scanner.nextLine();

                System.out.print("Email : ");
                String email = scanner.nextLine();

                professeur = new UtilisateurTab(prenom, nom, email);

            } catch (IllegalArgumentException e) {

                System.out.println("\nErreur : " + e.getMessage());

                System.out.println("\nQue voulez-vous faire ?");
                System.out.println("1 - Réessayer");
                System.out.println("2 - Utiliser professeur par défaut");
                System.out.print("Choix : ");

                int choix = scanner.nextInt();
                scanner.nextLine(); // limpar buffer

                if (choix == 2) {
                    professeur = new UtilisateurTab(
                            "Alain",
                            "Dupont",
                            "alain.dupont@iut.fr");
                    System.out.println("Professeur par défaut utilisé.");
                }
                // se choix = 1 → loop continua automaticamente
            }
        }

        CalculTab calculTab = new CalculTab();

        int choix;

        do {

            System.out.println("\n========== MENU ==========");
            System.out.println("1 - Ajouter une note");
            System.out.println("2 - Afficher les notes");
            System.out.println("3 - Trier les notes");
            System.out.println("4 - Calculer la moyenne");
            System.out.println("5 - Calculer la médiane");
            System.out.println("6 - Afficher le résultat complet");
            System.out.println("0 - Quitter");
            System.out.print("Votre choix : ");

            choix = scanner.nextInt();

            switch (choix) {

                case 1 -> {
                    System.out.print("Entrer une note : ");
                    int note = scanner.nextInt();

                    if (note < 0 || note > 20) {
                        System.out.println("La note doit être comprise entre 0 et 20.");
                    } else {
                        calculTab.ajouterNote(note);
                        System.out.println("Note ajoutée avec succès.");
                    }
                }

                case 2 -> System.out.println("\n===== NOTES =====\n" + calculTab.getNotes());

                case 3 -> {
                    calculTab.trierNotes();
                    System.out.println("Les notes ont été triées.");
                }

                case 4 -> System.out.println("\nMoyenne : " + calculTab.calculerMoyenne());

                case 5 -> System.out.println("\nMédiane : " + calculTab.calculerMediane());

                case 6 -> {

                    if (calculTab.getNombreNotes() == 0) {
                        System.out.println("Aucune note enregistrée.");
                    } else {

                        ResultatExamen resultat = new ResultatExamen(
                                LocalDate.now(),
                                calculTab.getNombreNotes(),
                                calculTab.calculerMoyenne(),
                                calculTab.calculerMediane(),
                                professeur);

                        System.out.println("\n" + resultat);
                    }
                }

                case 0 -> System.out.println("Fin du programme.");

                default -> System.out.println("Choix invalide.");
            }

        } while (choix != 0);

        scanner.close();
    }
}