# Projet : Évaluation des étudiants – TP Qualité de Développement

## 1. Présentation générale

Ce projet a été réalisé dans le cadre du module Qualité de Développement (BUT 2).
L’objectif était de transformer un code initial simple (un programme qui manipulait un tableau fixe d’entiers et calculait uniquement une somme) en une application Java complète, modulaire et conforme aux bonnes pratiques de développement.

Le programme permet désormais :
- la saisie des informations du professeur ;
- la saisie et la gestion dynamique des notes des étudiants ;
- le calcul de la moyenne et de la médiane ;
- l’affichage d’un récapitulatif complet sous forme d’objet `ResultatExamen` ;
- une interaction utilisateur via un menu console.

Le projet a été développé en binôme, avec une séparation claire des responsabilités afin de faciliter le travail en parallèle et d’éviter les conflits Git.

---

## 2. Architecture du projet

src/
├── main/java/calcultableau/
│     ├── Main.java
│     ├── CalculTab.java
│     ├── UtilisateurTab.java
│     └── ResultatExamen.java
└── test/java/calcultableau/
├── CalculTabTest.java
└── UtilisateurTabTest.java

Chaque classe possède un rôle précis :

- **Main.java** : interface console, gestion du menu, saisie utilisateur.
- **UtilisateurTab.java** : gestion des informations du professeur + validation stricte.
- **CalculTab.java** : gestion des notes, tri, moyenne, médiane.
- **ResultatExamen.java** : encapsulation des résultats finaux.
- **Tests JUnit** : réalisés pour valider la logique de calcul et les contraintes.

---

## 3. Fonctionnement du programme

### 3.1 Saisie du professeur
Le programme demande :
- prénom
- nom
- email

Une validation stricte est appliquée (regex, caractères autorisés, champs non vides).

En cas d’erreur, l’utilisateur peut :
- réessayer ;
- ou utiliser un professeur par défaut (Alain Dupont).

### 3.2 Menu interactif
Une fois le professeur validé, un menu permet :

1. Ajouter une note
2. Afficher les notes
3. Trier les notes
4. Calculer la moyenne
5. Calculer la médiane
6. Afficher le résultat complet
0. Quitter

Toutes les saisies sont sécurisées (gestion des erreurs, bornes 0–20, messages explicatifs).

---

## 4. Contraintes et validations

### 4.1 Contraintes sur les données personnelles (`UtilisateurTab`)
- prénom et nom non vides ;
- minimum deux caractères ;
- pas de chiffres ni de symboles ;
- accents, tirets et apostrophes autorisés ;
- email conforme à la regex du sujet ;
- nettoyage automatique des espaces.

### 4.2 Contraintes sur les notes (`Main` et `CalculTab`)
- notes comprises entre 0 et 20 ;
- gestion des erreurs de saisie (InputMismatchException) ;
- interdiction des listes vides pour les calculs ;
- tri sécurisé sans modifier la liste d’origine.

### 4.3 Contraintes sur les résultats (`ResultatExamen`)
- date non nulle ;
- nombre d’étudiants strictement positif ;
- professeur non nul.

---

## 5. Comparaison entre le code initial et notre version

### Avant (code fourni)
- un seul fichier Java ;
- tableau fixe `int[]` ;
- aucune validation ;
- aucune gestion d’erreurs ;
- aucune séparation des responsabilités ;
- pas de tests ;
- pas de structure Maven.

### Après (notre version)
- projet Maven complet ;
- architecture claire et modulaire ;
- utilisation d’`ArrayList` ;
- validations strictes et robustes ;
- gestion d’exceptions ;
- menu interactif ;
- calcul de la moyenne et de la médiane ;
- tests unitaires complets ;
- documentation et commentaires professionnels ;
- travail Git propre avec branches séparées.

---

## 6. Travail Git

### 6.1 Organisation du dépôt
Deux branches principales ont été utilisées :
- `feature/calculs-tests` (Wendy)
- `feature/interface-utilisateur` (Eunice)

### 6.2 Commentaire
Nous avons respecté les bonnes pratiques Git :
- commits courts et explicites ;
- travail en parallèle sans conflits ;
- fusion propre dans `main`.

---

## 7. Installation et exécution

### Compilation
mvn compile

### Exécution
mvn exec:java

### Lancement des tests
mvn test

---
## 8. Lien du dépôt


## 9. Auteurs
Eunice et Wendy
Département Informatique - BUT 2
IUT de Saint-Dié

