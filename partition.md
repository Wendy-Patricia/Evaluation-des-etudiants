# TP 2 – Organisation du travail (2 personnes)

## Objectif

Le but est de diviser le projet en deux parties afin que deux personnes puissent travailler en parallèle avec Git sans avoir beaucoup de conflits.

---

# Structure du projet

```text
TP-Qualite-Dev/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── calcultableau/
│   │           ├── Main.java
│   │           ├── CalculTab.java
│   │           ├── UtilisateurTab.java
│   │           └── ResultatExamen.java
│   │
│   └── test/
│       └── java/
│           └── calcultableau/
│               ├── CalculTabTest.java
│               └── UtilisateurTabTest.java
│
├── pom.xml
└── README.md
```

---

# Répartition du travail

# Personne 1 — Logique et calculs

## Responsabilités

Cette personne travaille principalement sur :

* CalculTab.java
* calcul de la moyenne
* calcul de la médiane
* tri des notes
* ArrayList
* tests unitaires

---

## Tâches

### 1. Modifier le tableau fixe

Transformer :

```java
int tab[] = new int[50];
```

par :

```java
ArrayList<Integer> notes = new ArrayList<>();
```

---

### 2. Créer les méthodes de calcul

Exemple :

```java
public double calculerMoyenne(ArrayList<Integer> notes)
```

```java
public double calculerMediane(ArrayList<Integer> notes)
```

```java
public void trierNotes(ArrayList<Integer> notes)
```

---

### 3. Implémenter le calcul de la médiane

* trier les notes
* vérifier si la taille est paire ou impaire

---

### 4. Créer les tests unitaires

Utiliser :

* JUnit 5
* AssertJ
* @DisplayName

Exemple :

```java
@Test
@DisplayName("calculerMoyenne retourne la bonne moyenne")
void calculerMoyenne_returnsCorrectAverage() {

}
```

---

### 5. Branche Git

Créer une branche :

```bash
git checkout -b feature/calculs-tests
```

Exemples de commits :

```bash
git commit -m "Ajout calcul moyenne"
git commit -m "Ajout calcul mediane"
git commit -m "Ajout tests CalculTab"
```

---

# Personne 2 — Interface et utilisateur

## Responsabilités

Cette personne travaille principalement sur :

* Main.java
* UtilisateurTab.java
* validation de l’email
* affichage console
* documentation

---

## Tâches

### 1. Créer la classe UtilisateurTab

Exemple :

```java
public class UtilisateurTab {

    private String prenom;
    private String nom;
    private String email;

}
```

---

### 2. Ajouter la validation de l’email

Utiliser la regex du sujet :

```java
"[\\w.-]+@[\\w.-]+\\.[a-z]{2,}"
```

Créer une méthode :

```java
public boolean emailValide()
```

---

### 3. Créer la classe ResultatExamen

Cette classe doit contenir :

* date de l’examen
* nombre d’étudiants
* moyenne
* médiane
* informations du professeur

---

### 4. Compléter Main.java

Le Main doit :

* demander les informations
* lire les notes
* appeler les méthodes de CalculTab
* afficher les résultats

---

### 5. Documentation

Ajouter :

* JavaDoc
* commentaires utiles
* README.md

---

### 6. Branche Git

Créer une branche :

```bash
git checkout -b feature/interface-utilisateur
```

Exemples de commits :

```bash
git commit -m "Creation classe UtilisateurTab"
git commit -m "Ajout validation email"
git commit -m "Creation interface console"
```

---

# Travail en parallèle avec Git

Chaque personne travaille sur sa propre branche.

## Personne 1

```bash
git checkout -b feature/calculs-tests
```

## Personne 2

```bash
git checkout -b feature/interface-utilisateur
```

---

# Fusion des branches

Quand une partie est terminée :

```bash
git checkout main
git pull
```

Puis :

```bash
git merge feature/calculs-tests
```

et :

```bash
git merge feature/interface-utilisateur
```

---

# Création du projet dans VS Code

# 1. Installer les extensions

Dans VS Code installer :

* Extension Pack for Java
* Maven for Java
* GitLens (optionnel)

---

# 2. Créer le projet Maven

Ouvrir le terminal :

```bash
mvn archetype:generate
```

Choisir :

```text
maven-archetype-quickstart
```

Puis remplir :

```text
GroupId : com.iut
ArtifactId : tp-qualite-dev
```

---

# 3. Ouvrir le projet

Dans VS Code :

```text
File > Open Folder
```

Choisir le dossier du projet.

---

# 4. Créer le package Java

Créer le package :

```text
calcultableau
```

Dans :

```text
src/main/java
```

---

# 5. Ajouter les dépendances Maven

Dans le fichier pom.xml ajouter :

```xml
<dependencies>

    <!-- JUnit 5 -->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.10.2</version>
        <scope>test</scope>
    </dependency>

    <!-- AssertJ -->
    <dependency>
        <groupId>org.assertj</groupId>
        <artifactId>assertj-core</artifactId>
        <version>3.25.3</version>
        <scope>test</scope>
    </dependency>

</dependencies>
```

---

# 6. Compiler le projet

```bash
mvn compile
```

---

# 7. Exécuter le projet

```bash
mvn exec:java
```

Ou utiliser le bouton ▶ dans VS Code.

---

# 8. Exécuter les tests

```bash
mvn test
```

---

# 9. Initialiser Git

```bash
git init
```

Ajouter les fichiers :

```bash
git add .
```

Premier commit :

```bash
git commit -m "Initial commit"
```

---

# Fichier .gitignore recommandé

Créer un fichier `.gitignore` :

```gitignore
target/
.classpath
.project
.settings/
.vscode/
```

---

# Conseils importants

## Éviter les conflits Git

Chaque personne doit travailler sur des fichiers différents.

| Personne 1          | Personne 2          |
| ------------------- | ------------------- |
| CalculTab.java      | Main.java           |
| CalculTabTest.java  | UtilisateurTab.java |
| logique des calculs | interface console   |
| médiane             | email               |
| tri                 | affichage           |

---

# Architecture recommandée

## Main.java

Contient uniquement l’interface console.

---

## CalculTab.java

Contient toute la logique :

* moyenne
* médiane
* tri

---

## UtilisateurTab.java

Contient :

* prénom
* nom
* email

---

## ResultatExamen.java

Contient les résultats de l’examen.

---

# Points importants pour l’évaluation

Le professeur va surtout regarder :

* la séparation des classes
* la qualité du code
* les tests unitaires
* Git
* Maven
* la documentation
* les conventions de nommage
* le calcul correct de la médiane

---

# Conseils supplémentaires

## Faire des commits petits et clairs

Bon exemple :

```bash
git commit -m "Ajout tri des notes"
```

Mauvais exemple :

```bash
git commit -m "final"
```
