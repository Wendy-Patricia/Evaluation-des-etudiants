package calcultableau;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Classe principale gérant l'interaction avec l'utilisateur.
 * - Saisie des informations du professeur
 * - Saisie des notes
 * - Affichage des résultats
 *
 * La partie "CalculTab" est temporairement désactivée tant que la Personne 1
 * n'a pas fourni son implémentation.
 */
public class Main {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("=== Informations du professeur ===");

            String prenom = lireTexteNonVide(sc, "Prénom : ");
            String nom = lireTexteNonVide(sc, "Nom : ");
            String email = lireTexteNonVide(sc, "Email : ");

            UtilisateurTab prof;
            try {
                prof = new UtilisateurTab(prenom, nom, email);
            } catch (IllegalArgumentException e) {
                System.out.println("❌ Erreur sur les informations du professeur : " + e.getMessage());
                return;
            }

            if (!prof.emailValide()) {
                System.out.println("❌ Erreur : l'email n'est pas valide.");
                System.out.println("Format attendu : exemple@domaine.fr");
                return;
            }

            int n = lireEntierDansIntervalle(sc,
                    "\nNombre d'étudiants : ",
                    1,
                    1000,
                    "Le nombre d'étudiants doit être un entier entre 1 et 1000.");

            List<Integer> notes = new ArrayList<>();
            System.out.println("\n=== Saisie des notes (0 à 20) ===");

            for (int i = 0; i < n; i++) {
                int note = lireEntierDansIntervalle(sc,
                        "Note " + (i + 1) + " : ",
                        0,
                        20,
                        "La note doit être un entier entre 0 et 20.");
                notes.add(note);
            }

            if (notes.isEmpty()) {
                System.out.println("❌ Aucune note saisie. Impossible de calculer les résultats.");
                return;
            }

            // ============================================================
            // 🔵 PARTIE TEMPORAIREMENT COMMENTÉE
            // Cette partie dépend de la classe CalculTab (Personne 1).
            // Elle sera réactivée dès que l'implémentation sera disponible.
            // ============================================================

            /*
            CalculTab calcul = new CalculTab();

            double moyenne;
            double mediane;

            try {
                moyenne = calcul.calculerMoyenne(notes);
                mediane = calcul.calculerMediane(notes);
            } catch (Exception e) {
                System.out.println("❌ Erreur lors du calcul : " + e.getMessage());
                return;
            }

            ResultatExamen resultat;
            try {
                resultat = new ResultatExamen(
                        LocalDate.now(), n, moyenne, mediane, prof
                );
            } catch (IllegalArgumentException e) {
                System.out.println("❌ Erreur lors de la création du résultat : " + e.getMessage());
                return;
            }

            System.out.println();
            System.out.println(resultat);
            */

            // ============================================================
            // 🔵 MESSAGE TEMPORAIRE POUR L’UTILISATEUR
            // ============================================================

            System.out.println("\n=== Calculs non disponibles ===");
            System.out.println("La partie 'CalculTab' n'a pas encore été fournie par la Personne 1.");
            System.out.println("Les informations du professeur et les notes ont été correctement enregistrées.");
            System.out.println("Le calcul de la moyenne et de la médiane sera activé dès que possible.");

        } catch (Exception e) {
            System.out.println("❌ Erreur critique inattendue : " + e.getMessage());
        }
    }

    private static String lireTexteNonVide(Scanner sc, String message) {
        String texte;
        do {
            System.out.print(message);
            texte = sc.nextLine();
            if (texte == null || texte.isBlank()) {
                System.out.println("⚠ Veuillez saisir une valeur non vide.");
            }
        } while (texte == null || texte.isBlank());
        return texte;
    }

    private static int lireEntierDansIntervalle(Scanner sc,
                                                String message,
                                                int min,
                                                int max,
                                                String messageErreur) {
        Integer valeur = null;
        while (valeur == null) {
            System.out.print(message);
            try {
                int lu = sc.nextInt();
                sc.nextLine(); // vider le buffer

                if (lu < min || lu > max) {
                    System.out.println("❌ " + messageErreur);
                } else {
                    valeur = lu;
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Veuillez entrer un entier valide.");
                sc.nextLine(); // vider le buffer
            }
        }
        return valeur;
    }
}
