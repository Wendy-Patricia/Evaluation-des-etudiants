package calcultableau;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Tests exhaustifs de UtilisateurTab")
class UtilisateurTabTest {

    // ── Constructeur – cas valides ────────────────────────────────

    @Nested
    @DisplayName("Constructeur – cas valides")
    class ConstructeurValide {

        @Test
        @DisplayName("constructeur – données valides – crée l'objet correctement")
        void constructeur_donneesValides_creeObjetCorrectement() {
            UtilisateurTab u = new UtilisateurTab("Alain", "Dupont", "alain.dupont@iut.fr");

            assertThat(u.getPrenom()).isEqualTo("Alain");
            assertThat(u.getNom()).isEqualTo("Dupont");
            assertThat(u.getEmail()).isEqualTo("alain.dupont@iut.fr");
        }

        @Test
        @DisplayName("constructeur – espaces autour des valeurs – nettoie les espaces")
        void constructeur_espacesAutourDesValeurs_nettoyeEspaces() {
            UtilisateurTab u = new UtilisateurTab("  Alain  ", "  Dupont  ", "  alain.dupont@iut.fr  ");

            assertThat(u.getPrenom()).isEqualTo("Alain");
            assertThat(u.getNom()).isEqualTo("Dupont");
            assertThat(u.getEmail()).isEqualTo("alain.dupont@iut.fr");
        }

        @Test
        @DisplayName("constructeur – prénom avec tiret – accepté")
        void constructeur_prenomAvecTiret_accepte() {
            UtilisateurTab u = new UtilisateurTab("Jean-Pierre", "Dupont", "jp@iut.fr");
            assertThat(u.getPrenom()).isEqualTo("Jean-Pierre");
        }

        @Test
        @DisplayName("constructeur – prénom avec apostrophe – accepté")
        void constructeur_prenomAvecApostrophe_accepte() {
            UtilisateurTab u = new UtilisateurTab("N'Golo", "Dupont", "ng@iut.fr");
            assertThat(u.getPrenom()).isEqualTo("N'Golo");
        }

        @Test
        @DisplayName("constructeur – nom avec accents – accepté")
        void constructeur_nomAvecAccents_accepte() {
            UtilisateurTab u = new UtilisateurTab("Élodie", "Müller", "elodie@iut.fr");
            assertThat(u.getNom()).isEqualTo("Müller");
        }

        @Test
        @DisplayName("constructeur – prénom de deux caractères – accepté")
        void constructeur_prenomDeuxCaracteres_accepte() {
            UtilisateurTab u = new UtilisateurTab("Al", "Dupont", "al@iut.fr");
            assertThat(u.getPrenom()).isEqualTo("Al");
        }
    }

    // ── Constructeur – prénom invalide ────────────────────────────

    @Nested
    @DisplayName("Constructeur – prénom invalide")
    class PrenomInvalide {

        @Test
        @DisplayName("constructeur – prénom null – lève IllegalArgumentException")
        void constructeur_prenomNull_leveException() {
            assertThatThrownBy(() -> new UtilisateurTab(null, "Dupont", "a@iut.fr"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("prénom");
        }

        @Test
        @DisplayName("constructeur – prénom vide – lève IllegalArgumentException")
        void constructeur_prenomVide_leveException() {
            assertThatThrownBy(() -> new UtilisateurTab("", "Dupont", "a@iut.fr"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("prénom");
        }

        @Test
        @DisplayName("constructeur – prénom blanc – lève IllegalArgumentException")
        void constructeur_prenomBlanc_leveException() {
            assertThatThrownBy(() -> new UtilisateurTab("   ", "Dupont", "a@iut.fr"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("prénom");
        }

        @Test
        @DisplayName("constructeur – prénom un seul caractère – lève IllegalArgumentException")
        void constructeur_prenomUnCaractere_leveException() {
            assertThatThrownBy(() -> new UtilisateurTab("A", "Dupont", "a@iut.fr"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest(name = "prénom invalide : \"{0}\"")
        @ValueSource(strings = {"Al4in", "Al@in", "Al!in", "123"})
        @DisplayName("constructeur – prénom avec caractères invalides – lève IllegalArgumentException")
        void constructeur_prenomCaracteresInvalides_leveException(String prenomInvalide) {
            assertThatThrownBy(() -> new UtilisateurTab(prenomInvalide, "Dupont", "a@iut.fr"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    // ── Constructeur – nom invalide ───────────────────────────────

    @Nested
    @DisplayName("Constructeur – nom invalide")
    class NomInvalide {

        @Test
        @DisplayName("constructeur – nom null – lève IllegalArgumentException")
        void constructeur_nomNull_leveException() {
            assertThatThrownBy(() -> new UtilisateurTab("Alain", null, "a@iut.fr"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("nom");
        }

        @Test
        @DisplayName("constructeur – nom vide – lève IllegalArgumentException")
        void constructeur_nomVide_leveException() {
            assertThatThrownBy(() -> new UtilisateurTab("Alain", "", "a@iut.fr"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("nom");
        }

        @Test
        @DisplayName("constructeur – nom blanc – lève IllegalArgumentException")
        void constructeur_nomBlanc_leveException() {
            assertThatThrownBy(() -> new UtilisateurTab("Alain", "   ", "a@iut.fr"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("nom");
        }

        @Test
        @DisplayName("constructeur – nom un seul caractère – lève IllegalArgumentException")
        void constructeur_nomUnCaractere_leveException() {
            assertThatThrownBy(() -> new UtilisateurTab("Alain", "D", "a@iut.fr"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest(name = "nom invalide : \"{0}\"")
        @ValueSource(strings = {"Dup0nt", "Dup@nt", "123"})
        @DisplayName("constructeur – nom avec caractères invalides – lève IllegalArgumentException")
        void constructeur_nomCaracteresInvalides_leveException(String nomInvalide) {
            assertThatThrownBy(() -> new UtilisateurTab("Alain", nomInvalide, "a@iut.fr"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    // ── Constructeur – email invalide (format) ────────────────────

    @Nested
    @DisplayName("Constructeur – email invalide (champ vide)")
    class EmailChampInvalide {

        @Test
        @DisplayName("constructeur – email null – lève IllegalArgumentException")
        void constructeur_emailNull_leveException() {
            assertThatThrownBy(() -> new UtilisateurTab("Alain", "Dupont", null))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("email");
        }

        @Test
        @DisplayName("constructeur – email vide – lève IllegalArgumentException")
        void constructeur_emailVide_leveException() {
            assertThatThrownBy(() -> new UtilisateurTab("Alain", "Dupont", ""))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("email");
        }

        @Test
        @DisplayName("constructeur – email blanc – lève IllegalArgumentException")
        void constructeur_emailBlanc_leveException() {
            assertThatThrownBy(() -> new UtilisateurTab("Alain", "Dupont", "   "))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("email");
        }
    }

    // ── emailValide() ─────────────────────────────────────────────

    @Nested
    @DisplayName("emailValide() – formats valides")
    class EmailValideFormats {

        @ParameterizedTest(name = "email valide : \"{0}\"")
        @ValueSource(strings = {
                "alain.dupont@iut.fr",
                "a@b.fr",
                "user.name@domain.com",
                "user-name@domain.org",
                "user_name@domain.co",
                "user@sub.domain.fr",
                "123user@domain.fr"
        })
        @DisplayName("emailValide – email correct – retourne true")
        void emailValide_emailCorrect_retourneTrue(String email) {
            UtilisateurTab u = new UtilisateurTab("Alain", "Dupont", email);
            assertThat(u.emailValide()).isTrue();
        }

        @ParameterizedTest(name = "email invalide : \"{0}\"")
        @ValueSource(strings = {
                "sansat",
                "sans@",
                "@domaine.fr",
                "user@.fr",
                "user@domaine",
                "user@domaine.F",        
                "user @domaine.fr",      
                "user@domaine .fr" 
        })
        @DisplayName("emailValide – email incorrect – retourne false")
        void emailValide_emailIncorrect_retourneFalse(String email) {
            UtilisateurTab u = creerUtilisateurAvecEmailBrut(email);
            assertThat(u.emailValide()).isFalse();
        }

        /**
         * Crée un UtilisateurTab en contournant la validation du constructeur
         * pour tester emailValide() de façon isolée, via la réflexion Java.
         */
        private UtilisateurTab creerUtilisateurAvecEmailBrut(String email) {
            try {
                var constructor = UtilisateurTab.class.getDeclaredConstructor(
                        String.class, String.class, String.class);
                UtilisateurTab u = new UtilisateurTab("Alain", "Dupont", "valide@iut.fr");
                var field = UtilisateurTab.class.getDeclaredField("email");
                field.setAccessible(true);
                field.set(u, email);
                return u;
            } catch (Exception e) {
                throw new RuntimeException("Réflexion échouée", e);
            }
        }
    }

    // ── toString() ────────────────────────────────────────────────

    @Nested
    @DisplayName("toString()")
    class ToStringTests {

        @Test
        @DisplayName("toString – données valides – format correct")
        void toString_donneesValides_formatCorrect() {
            UtilisateurTab u = new UtilisateurTab("Alain", "Dupont", "alain.dupont@iut.fr");
            assertThat(u.toString())
                    .contains("Alain")
                    .contains("Dupont")
                    .contains("alain.dupont@iut.fr");
        }

        @Test
        @DisplayName("toString – retourne prénom nom (email)")
        void toString_retournePrenomNomEmail() {
            UtilisateurTab u = new UtilisateurTab("Alain", "Dupont", "alain.dupont@iut.fr");
            assertThat(u.toString()).isEqualTo("Alain Dupont (alain.dupont@iut.fr)");
        }
    }
}