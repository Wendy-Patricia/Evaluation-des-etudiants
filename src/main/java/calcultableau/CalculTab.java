package calcultableau;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe utilitaire pour gérer un tableau de notes (entiers).
 * Fournit le calcul de la moyenne, de la médiane et le tri.
 */
public class CalculTab {

    private List<Integer> notes;

    public CalculTab() {
        this.notes = new ArrayList<>();
    }

    public CalculTab(List<Integer> notes) {
        this.notes = new ArrayList<>(notes);
    }

    public void ajouterNote(int note) {
        notes.add(note);
    }

    public List<Integer> getNotes() {
        return new ArrayList<>(notes);
    }

    public int getNombreNotes() {
        return notes.size();
    }

    /** Trie la liste interne par ordre croissant. */
    public void trierNotes() {
        Collections.sort(notes);
    }

    /** Calcule la moyenne. Retourne 0.0 si la liste est vide. */
    public double calculerMoyenne() {
        if (notes.isEmpty()) return 0.0;
        int somme = 0;
        for (int note : notes) somme += note;
        return (double) somme / notes.size();
    }

    /**
     * Calcule la médiane sans modifier l'ordre interne.
     * Retourne 0.0 si la liste est vide.
     */
    public double calculerMediane() {
        if (notes.isEmpty()) return 0.0;

        List<Integer> triees = new ArrayList<>(notes);
        Collections.sort(triees);

        int taille = triees.size();
        int milieu = taille / 2;

        if (taille % 2 == 0) {
            return (triees.get(milieu - 1) + triees.get(milieu)) / 2.0;
        } else {
            return triees.get(milieu);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CalculTab{");
        sb.append("notes=").append(notes);
        sb.append(", nombre=").append(getNombreNotes());
        sb.append(", moyenne=").append(String.format("%.2f", calculerMoyenne()));
        sb.append(", mediane=").append(calculerMediane());
        sb.append("}");
        return sb.toString();
    }
}