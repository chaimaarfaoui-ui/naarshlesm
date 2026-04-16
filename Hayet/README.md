# Hayet — Plateforme de Services Médicaux

> Projet AGL 2025/2026 — FSEGT, Université Tunis El Manar  
> Enseignante : Fatma Karray | Sprint 1

## Pitch

**Hayet** est une plateforme tunisienne de mise en relation entre patients et médecins/services médicaux.  
Elle permet de rechercher un médecin par spécialité et localisation, consulter les avis, prendre rendez-vous et gérer la plateforme depuis un tableau de bord admin.

**Problème résolu :** Trouver un médecin disponible en Tunisie sans passer des heures au téléphone.  
**Cible :** Patients, Médecins, Administrateurs de la plateforme.

---

## Équipe

| Membre | Rôle Scrum | Fonctionnalité | Branche Git |
|--------|-----------|----------------|-------------|
| Chaima | Product Owner + Dev | Authentification & Inscription | `feature/authentification` |
| Farah | Scrum Master + Dev | Recherche & Filtrage des Services | `feature/recherche-services` |
| Malek | Développeur | Profil Médecin & Équipe | `feature/profil-medecin` |
| Eya | Développeur | Avis & Notation | `feature/notation-avis` |
| Maram | Développeur | Tableau de Bord Admin | `feature/admin-dashboard` |

---

## Structure du projet

```
Hayet/
├── README.md
├── docs/
│   ├── rapport.pdf
│   └── captures/
│       ├── maquettes/
│       ├── kanban/
│       └── reviews/
├── diagrammes/
│   ├── DCU_Hayet.puml
│   ├── DC_Hayet.puml
│   └── DS_Hayet.puml
└── src/
    └── com/hayet/models/
        ├── Main.java          ← Point d'entrée
        ├── Utilisateur.java   ← Chaima
        ├── Service.java       ← Farah
        ├── Medecin.java       ← Malek
        ├── Avis.java          ← Eya
        ├── Admin.java         ← Maram (extends Utilisateur)
        └── Consultation.java  ← Classe commune
```

---

## Compilation & Exécution

```bash
# Compiler
javac -encoding UTF-8 -d out src/com/hayet/models/*.java

# Exécuter
java -cp out com.hayet.models.Main
```

---

## Classes Java — Sprint 1

| Classe | Responsable | Héritage/Relations | Méthodes clés |
|--------|------------|-------------------|---------------|
| `Utilisateur` | Chaima | — | `sInscrire()`, `seConnecter()`, `seDeconnecter()` |
| `Service` | Farah | — | `correspondARecherche()`, `filtrerCombine()`, `mettreAJourNote()` |
| `Medecin` | Malek | — | `afficherProfil()`, `mettreAJourProfil()`, `mettreAJourNote()` |
| `Avis` | Eya | — | `soumettre()`, `valider()`, `rejeter()` |
| `Admin` | Maram | extends Utilisateur | `afficherTableauDeBord()`, `ajouterMedecin()`, `validerAvis()` |
| `Consultation` | Commune | — | `confirmer()`, `terminer()`, `annuler()` |

---

## Lien Figma

> [À compléter par l'équipe après création des maquettes]

---

## Acteurs du système

- **Visiteur** — peut rechercher des services sans compte
- **Patient (Client)** — s'inscrit, consulte, laisse des avis
- **Administrateur** — gère la plateforme, modère les avis, supervise les médecins
