# Scientific Calculator 🧮

Une calculatrice scientifique web moderne et fonctionnelle développée en Java avec Spring Boot.

**Auteur :** Fadli Hamza
**Dates :** 13 - 15 juin 2026
**Durée :** 2 jours

---

## 🎯 Présentation

Scientific Calculator est une application web permettant d'effectuer des calculs mathématiques simples et scientifiques via une interface moderne, intuitive et entièrement responsive.

L'application repose sur une architecture **frontend / backend** avec une séparation claire des responsabilités et une organisation inspirée des bonnes pratiques de développement.

---

## 📋 Fonctionnalités

### Opérations de base

* ✅ Addition, soustraction, multiplication et division
* ✅ Nombres entiers et décimaux
* ✅ Gestion des parenthèses et respect de la priorité des opérateurs
* ✅ Inverse (1/x)
* ✅ Pourcentage
* ✅ Puissance au carré (x²)
* ✅ Puissance générale (x^n)

### Fonctions scientifiques

* ✅ Racine carrée (√x)
* ✅ Trigonométrie : sin, cos, tan (en degrés)
* ✅ Logarithme décimal : log₁₀
* ✅ Logarithme népérien : ln

### Interface

* ✅ Affichage en temps réel
* ✅ Historique des 10 derniers calculs
* ✅ Design responsive (ordinateur, tablette et mobile)
* ✅ Interface intuitive et boutons clairement organisés
* ✅ Gestion des erreurs
* ✅ Raccourcis clavier :

  * Entrée → calcul (=)
  * Échap → effacer (C)
  * Retour arrière → supprimer (⌫)

### Robustesse

* ✅ Gestion des divisions par zéro
* ✅ Gestion des racines carrées de nombres négatifs
* ✅ Validation des expressions mathématiques
* ✅ Messages d'erreur clairs

---

## 🛠️ Technologies utilisées

### Backend

* **Java 17** : langage principal
* **Spring Boot 3.3** : framework Java utilisé pour développer l'application web et l'API REST
* **Maven 3.6+** : gestion des dépendances et automatisation du build
* **JUnit 5** : tests automatisés

### Frontend

* **HTML5** : structure de l'interface
* **CSS3** : mise en page, Flexbox, Grid, variables CSS et design responsive
* **JavaScript ES6** : manipulation du DOM, communication avec l'API via Fetch API et gestion asynchrone avec async/await

### Outils

* **Git** : gestion de versions
* **GitHub** : hébergement et partage du code source
* **Maven** : compilation, tests et gestion du projet

---

## 🏗️ Architecture

### Architecture générale

```text
┌─────────────────────────────────────┐
│              FRONTEND               │
│                                     │
│     HTML5 + CSS3 + JavaScript ES6   │
│                                     │
│       Interface utilisateur         │
└──────────────────┬──────────────────┘
                   │
                   │ HTTP / JSON
                   ▼
┌─────────────────────────────────────┐
│              BACKEND                │
│                                     │
│            Spring Boot              │
│                                     │
│  ┌───────────────────────────────┐  │
│  │     CalculatriceController    │  │
│  │           API REST             │  │
│  └───────────────┬───────────────┘  │
│                  │                  │
│                  ▼                  │
│  ┌───────────────────────────────┐  │
│  │      ServiceCalculatrice      │  │
│  │                               │  │
│  │  • Calculs                    │  │
│  │  • Priorité des opérateurs    │  │
│  │  • Fonctions scientifiques    │  │
│  │  • Gestion des erreurs        │  │
│  └───────────────────────────────┘  │
└──────────────────┬──────────────────┘
                   │
                   ▼
              JUnit 5
         Tests automatisés
```

---

## 📁 Structure du projet

```text
calculatrice-scientifique/
│
├── src/
│   ├── main/
│   │   ├── java/com/calculatrice/
│   │   │   ├── controller/
│   │   │   │   ├── CalculatriceController.java
│   │   │   │   ├── CalculRequest.java
│   │   │   │   └── CalculResponse.java
│   │   │   │
│   │   │   ├── service/
│   │   │   │   └── ServiceCalculatrice.java
│   │   │   │
│   │   │   └── CalculatriceApplication.java
│   │   │
│   │   └── resources/
│   │       ├── static/
│   │       │   ├── index.html
│   │       │   ├── style.css
│   │       │   └── script.js
│   │       └── application.properties
│   │
│   └── test/
│       └── java/com/calculatrice/service/
│           └── ServiceCalculatriceTest.java
│
├── pom.xml
├── .gitignore
└── README.md
```

---

## 🧪 Tests

L'application dispose d'une suite de tests automatisés avec **JUnit 5**.

Les tests couvrent notamment :

* Addition
* Soustraction
* Multiplication
* Division
* Puissance
* Racine carrée
* Parenthèses
* Priorité des opérateurs
* Division par zéro
* Racine carrée d'un nombre négatif
* Expression vide
* Fonctions trigonométriques
* Logarithmes
* Nombres décimaux

### Exécuter les tests

```bash
mvn clean test
```

**Résultat :**

```text
✅ 16 tests automatisés
✅ 16 tests réussis
❌ 0 échec
❌ 0 erreur
```

---

## 🚀 Installation

### Prérequis

* Java 17 ou version supérieure
* Maven 3.6 ou version supérieure
* Git

### Cloner le projet

```bash
git clone https://github.com/7amzvv/calculatrice-scientifique.git

cd calculatrice-scientifique
```

### Lancer les tests

```bash
mvn clean test
```

### Lancer l'application

```bash
mvn spring-boot:run
```

L'application sera ensuite accessible à l'adresse :

```text
http://localhost:8080
```

---


## 👨‍💻 Auteur

**Fadli Hamza**

Projet réalisé dans le cadre de la pratique du développement **Java, Spring Boot, REST, JavaScript et JUnit**.

