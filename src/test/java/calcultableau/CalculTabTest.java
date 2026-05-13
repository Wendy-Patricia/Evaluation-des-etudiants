package calcultableau;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Tests du projet CalculTab")
class CalculTabTest {

    // ── Gestion des notes ────────────────────────────────────────

    @Nested
    @DisplayName("Gestion des notes")
    class GestionNotes {

        private CalculTab ct;

        @BeforeEach
        void setUp() { ct = new CalculTab(); }

        @Test
        @DisplayName("ajouterNote – liste vide – ajoute la note")
        void ajouterNote_listeVide_ajouteLaNote() {
            ct.ajouterNote(15);
            assertThat(ct.getNotes()).containsExactly(15);
        }

        @Test
        @DisplayName("getNombreNotes – trois notes – retourne 3")
        void getNombreNotes_troisNotes_retourne3() {
            ct.ajouterNote(10); ct.ajouterNote(12); ct.ajouterNote(14);
            assertThat(ct.getNombreNotes()).isEqualTo(3);
        }

        @Test
        @DisplayName("getNombreNotes – liste vide – retourne 0")
        void getNombreNotes_listeVide_retourne0() {
            assertThat(ct.getNombreNotes()).isZero();
        }
    }

    // ── Moyenne ──────────────────────────────────────────────────

    @Nested
    @DisplayName("Calcul de la moyenne")
    class Moyenne {

        @Test
        @DisplayName("calculerMoyenne – liste vide – retourne 0.0")
        void calculerMoyenne_listeVide_retourne0() {
            assertThat(new CalculTab().calculerMoyenne()).isEqualTo(0.0);
        }

        @Test
        @DisplayName("calculerMoyenne – notes positives – retourne la moyenne correcte")
        void calculerMoyenne_notesPositives_retourneMoyenneCorrecte() {
            CalculTab ct = new CalculTab(Arrays.asList(10, 20, 30));
            assertThat(ct.calculerMoyenne()).isEqualTo(20.0);
        }

        @Test
        @DisplayName("calculerMoyenne – une seule note – retourne cette note")
        void calculerMoyenne_uneSeuleNote_retourneCetteNote() {
            assertThat(new CalculTab(Arrays.asList(17)).calculerMoyenne()).isEqualTo(17.0);
        }

        @Test
        @DisplayName("calculerMoyenne – deux notes – retourne double précis")
        void calculerMoyenne_deuxNotes_retourneDoublePrecis() {
            assertThat(new CalculTab(Arrays.asList(10, 11)).calculerMoyenne()).isEqualTo(10.5);
        }
    }

    // ── Médiane ──────────────────────────────────────────────────

    @Nested
    @DisplayName("Calcul de la médiane")
    class Mediane {

        @Test
        @DisplayName("calculerMediane – liste vide – retourne 0.0")
        void calculerMediane_listeVide_retourne0() {
            assertThat(new CalculTab().calculerMediane()).isEqualTo(0.0);
        }

        @Test
        @DisplayName("calculerMediane – nombre impair de notes – retourne élément central")
        void calculerMediane_nombreImpair_retourneElementCentral() {
            // trié : [5, 10, 15] → médiane = 10
            CalculTab ct = new CalculTab(Arrays.asList(15, 5, 10));
            assertThat(ct.calculerMediane()).isEqualTo(10.0);
        }

        @Test
        @DisplayName("calculerMediane – nombre pair de notes – retourne moyenne des deux centraux")
        void calculerMediane_nombrePair_retourneMoyenneDesDeux() {
            // trié : [4, 8, 12, 16] → médiane = (8+12)/2 = 10.0
            CalculTab ct = new CalculTab(Arrays.asList(12, 4, 16, 8));
            assertThat(ct.calculerMediane()).isEqualTo(10.0);
        }

        @Test
        @DisplayName("calculerMediane – notes identiques – retourne cette note")
        void calculerMediane_notesIdentiques_retourneCetteNote() {
            assertThat(new CalculTab(Arrays.asList(12, 12, 12)).calculerMediane()).isEqualTo(12.0);
        }
    }

    // ── Tri ──────────────────────────────────────────────────────

    @Nested
    @DisplayName("Tri des notes")
    class Tri {

        @Test
        @DisplayName("trierNotes – notes désordonnées – liste triée croissante")
        void trierNotes_notesDesordonnees_listeTrieeCroissante() {
            CalculTab ct = new CalculTab(Arrays.asList(18, 5, 12, 9));
            ct.trierNotes();
            assertThat(ct.getNotes()).containsExactly(5, 9, 12, 18);
        }

        @Test
        @DisplayName("trierNotes – liste déjà triée – reste inchangée")
        void trierNotes_listeDejaTriee_resteInchangee() {
            CalculTab ct = new CalculTab(Arrays.asList(1, 2, 3, 4));
            ct.trierNotes();
            assertThat(ct.getNotes()).containsExactly(1, 2, 3, 4);
        }
    }
}