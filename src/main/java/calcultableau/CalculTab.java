package calcultableau;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe utilitaire pour gérer un tableau de notes (entiers).
 * Fournit le calcul de la moyenne, de la médiane et le tri.
 * 
 * @author VotreNom
 * @version 1.0
 */
public class CalculTab {

    /** Liste des notes stockées dans cette instance. */
    private List<Integer> notes;

    /**
     * Constructeur par défaut.
     * Initialise une nouvelle liste vide de notes.
     */
    public CalculTab() {
        this.notes = new ArrayList<>();
    }

    /**
     * Constructeur avec une liste initiale de notes.
     * 
     * @param notes La liste de notes à utiliser (une copie indépendante est créée)
     */
    public CalculTab(List<Integer> notes) {
        this.notes = new ArrayList<>(notes);
    }

    /**
     * Ajoute une nouvelle note à la liste.
     * 
     * @param note La note à ajouter (valeur entière)
     */
    public void ajouterNote(int note) {
        notes.add(note);
    }

    /**
     * Retourne une copie de la liste des notes.
     * 
     * @return Une nouvelle liste contenant toutes les notes
     */
    public List<Integer> getNotes() {
        return new ArrayList<>(notes);
    }

    /**
     * Retourne le nombre de notes dans la liste.
     * 
     * @return Le nombre total de notes
     */
    public int getNombreNotes() {
        return notes.size();
    }

    /**
     * Trie la liste interne par ordre croissant.
     * Cette méthode modifie l'ordre interne des notes.
     */
    public void trierNotes() {
        Collections.sort(notes);
    }

    /**
     * Calcule la moyenne des notes.
     * 
     * @return La moyenne des notes, ou 0.0 si la liste est vide
     */
    public double calculerMoyenne() {
        if (notes.isEmpty()) return 0.0;
        int somme = 0;
        for (int note : notes) somme += note;
        return (double) somme / notes.size();
    }

    /**
     * Calcule la médiane des notes sans modifier l'ordre interne.
     * La médiane est la valeur centrale lorsque les notes sont triées.
     * Pour un nombre pair d'éléments, la médiane est la moyenne des deux valeurs centrales.
     * 
     * @return La médiane des notes, ou 0.0 si la liste est vide
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

    /**
     * Retourne une représentation textuelle de l'objet.
     * Inclut la liste des notes, le nombre total, la moyenne et la médiane.
     * 
     * @return Une chaîne de caractères décrivant l'état actuel de l'objet
     */
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