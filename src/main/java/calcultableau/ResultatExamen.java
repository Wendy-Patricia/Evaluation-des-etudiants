package calcultableau;

import java.time.LocalDate;

/**
 * Contient les résultats d'un examen :
 * - date
 * - nombre d'étudiants
 * - moyenne
 * - médiane
 * - informations du professeur
 *
 * Toutes les contraintes liées aux résultats sont vérifiées ici.
 */
public class ResultatExamen {

    private final LocalDate dateExamen;
    private final int nombreEtudiants;
    private final double moyenne;
    private final double mediane;
    private final UtilisateurTab professeur;

    /**
     * Constructeur principal.
     *
     * @param dateExamen      Date de l'examen (non nulle)
     * @param nombreEtudiants Nombre d'étudiants (> 0)
     * @param moyenne         Moyenne du groupe
     * @param mediane         Médiane du groupe
     * @param professeur      Professeur responsable (non nul)
     */
    public ResultatExamen(LocalDate dateExamen, int nombreEtudiants,
                          double moyenne, double mediane, UtilisateurTab professeur) {

        if (dateExamen == null) {
            throw new IllegalArgumentException("La date de l'examen ne peut pas être nulle.");
        }
        if (nombreEtudiants <= 0) {
            throw new IllegalArgumentException("Le nombre d'étudiants doit être supérieur à 0.");
        }
        if (professeur == null) {
            throw new IllegalArgumentException("Le professeur ne peut pas être nul.");
        }

        this.dateExamen = dateExamen;
        this.nombreEtudiants = nombreEtudiants;
        this.moyenne = moyenne;
        this.mediane = mediane;
        this.professeur = professeur;
    }

    @Override
    public String toString() {
        return "===== Résultat de l'examen =====\n" +
                "Date : " + dateExamen + "\n" +
                "Nombre d'étudiants : " + nombreEtudiants + "\n" +
                "Moyenne : " + moyenne + "\n" +
                "Médiane : " + mediane + "\n" +
                "Professeur : " + professeur + "\n";
    }
}
