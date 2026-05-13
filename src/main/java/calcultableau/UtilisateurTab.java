package calcultableau;

/**
 * Représente un utilisateur (ici : le professeur).
 * Contient les informations personnelles et une méthode de validation d'email.
 * Toutes les contraintes liées aux données personnelles sont vérifiées ici.
 */
public class UtilisateurTab {

    private final String prenom;
    private final String nom;
    private final String email;

    // Regex conforme au sujet : "[\\w.-]+@[\\w.-]+\\.[a-z]{2,}"
    private static final String REGEX_EMAIL = "[\\w.-]+@[\\w.-]+\\.[a-z]{2,}";

    /**
     * Constructeur principal.
     *
     * @param prenom Prénom du professeur (non nul, non vide, caractères valides)
     * @param nom    Nom du professeur (non nul, non vide, caractères valides)
     * @param email  Adresse email du professeur (non nulle, non vide)
     */
    public UtilisateurTab(String prenom, String nom, String email) {

        if (prenom == null || prenom.isBlank()) {
            throw new IllegalArgumentException("Le prénom ne peut pas être vide.");
        }
        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("Le nom ne peut pas être vide.");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("L'email ne peut pas être vide.");
        }

        String prenomNettoye = prenom.trim();
        String nomNettoye = nom.trim();
        String emailNettoye = email.trim();

        // Validation stricte des noms
        if (!prenomNettoye.matches("[A-Za-zÀ-ÖØ-öø-ÿ' -]{2,}")) {
            throw new IllegalArgumentException("Le prénom contient des caractères invalides ou est trop court.");
        }
        if (!nomNettoye.matches("[A-Za-zÀ-ÖØ-öø-ÿ' -]{2,}")) {
            throw new IllegalArgumentException("Le nom contient des caractères invalides ou est trop court.");
        }
        if (!emailNettoye.matches(REGEX_EMAIL)) {
            throw new IllegalArgumentException("Format d'email invalide.");
        }

        this.prenom = prenomNettoye;
        this.nom = nomNettoye;
        this.email = emailNettoye;
    }

    /**
     * Vérifie si l'email respecte le format imposé par le sujet.
     *
     * @return true si l'email est valide, false sinon
     */
    public boolean emailValide() {
        return email.matches(REGEX_EMAIL);
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return prenom + " " + nom + " (" + email + ")";
    }
}