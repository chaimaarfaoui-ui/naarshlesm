package com.hayet.models;

/**
 * ╔══════════════════════════════════════════════════════════════╗
 * ║             HAYET — Plateforme de Services Médicaux          ║
 * ║                     Sprint 1 — Main.java V1                  ║
 * ╚══════════════════════════════════════════════════════════════╝
 *
 * Équipe Hayet — FSEGT, Université Tunis El Manar — AGL 2025/2026
 *   Chaima  — Product Owner + Dev  — Authentification & Inscription
 *   Farah   — Scrum Master + Dev   — Recherche & Filtrage des Services
 *   Malek   — Développeur          — Profil Médecin & Équipe
 *   Eya     — Développeur          — Avis & Notation
 *   Maram   — Développeur          — Tableau de Bord Admin
 *
 * Compilation :
 *   javac -encoding UTF-8 -d out src/com/hayet/models/*.java
 * Exécution :
 *   java -cp out com.hayet.models.Main
 */
public class Main {

    public static void main(String[] args) {

        afficherSeparateur("═", 60);
        System.out.println("      HAYET — Démonstration Sprint 1");
        System.out.println("      Plateforme de Services Médicaux");
        afficherSeparateur("═", 60);

        // ──────────────────────────────────────────────────────────
        // FONCTIONNALITÉ 1 — Authentification & Inscription (Chaima)
        // ──────────────────────────────────────────────────────────
        afficherSection("1", "Authentification & Inscription", "Chaima");

        // Inscription d'un nouveau patient
        Utilisateur patient = new Utilisateur();
        patient.setId(1);
        patient.sInscrire("Ben Ali", "Fatma", "fatma@gmail.com", "pass123", "+216 55 123 456");

        // Connexion
        patient.seConnecter("fatma@gmail.com", "pass123");

        // Affichage du profil
        System.out.println();
        System.out.println("  Profil utilisateur :");
        patient.afficherDetails();

        // Test connexion échouée
        System.out.println();
        Utilisateur visiteur = new Utilisateur(2, "Trabelsi", "Mohamed",
                "med@mail.com", "azerty1", "+216 98 765 432", "PATIENT", "2026-04-10");
        visiteur.seConnecter("med@mail.com", "mauvaismdp");

        // ──────────────────────────────────────────────────────────
        // FONCTIONNALITÉ 2 — Recherche & Filtrage des Services (Farah)
        // ──────────────────────────────────────────────────────────
        afficherSection("2", "Recherche & Filtrage des Services", "Farah");

        // Création de services médicaux
        Service s1 = new Service(1, "Cabinet Dr. Chaabane", "Généraliste",
                "Médecine générale et suivi patient", 25.0, "Tunis", "Rue de la Liberté, Tunis");
        Service s2 = new Service(2, "Cabinet Dr. Mejri", "Dentiste",
                "Soins dentaires et orthodontie", 80.0, "Sfax", "Avenue Bourguiba, Sfax");
        Service s3 = new Service(3, "Clinique Oeil et Lumière", "Ophtalmologue",
                "Consultation ophtalmologique et lunettes", 50.0, "Tunis", "Lac 2, Tunis");
        Service s4 = new Service(4, "Cabinet Dr. Saidi", "Dermatologue",
                "Dermatologie et soins de la peau", 60.0, "Sousse", "Rue Ibn Khaldoun, Sousse");

        // Recherche par mot-clé
        System.out.println("  Recherche : 'dentiste'");
        if (s2.correspondARecherche("dentiste")) {
            System.out.println("  → Trouvé : " + s2.getNom());
        }

        System.out.println();
        System.out.println("  Filtrage : Tunis, budget ≤ 55 DT");
        Service[] tousServices = {s1, s2, s3, s4};
        int nbTrouves = 0;
        for (Service s : tousServices) {
            if (s.filtrerCombine("Tunis", null, 55.0)) {
                System.out.print("  → ");
                s.afficherDetails();
                System.out.println();
                nbTrouves++;
            }
        }
        System.out.println("  " + nbTrouves + " service(s) trouvé(s) à Tunis sous 55 DT.");

        // ──────────────────────────────────────────────────────────
        // FONCTIONNALITÉ 3 — Profil Médecin & Équipe (Malek)
        // ──────────────────────────────────────────────────────────
        afficherSection("3", "Profil Médecin & Équipe", "Malek");

        Medecin medecin1 = new Medecin(1, "Chaabane", "Karim", "Généraliste",
                "dr.chaabane@hayet.tn", "+216 71 123 456",
                "Rue de la Liberté, Bab Bhar", "Tunis", 25.0, 12, "Doctorat en Médecine — FMST");
        medecin1.setNoteMoyenne(4.3);
        medecin1.setNombreConsultations(187);

        Medecin medecin2 = new Medecin(2, "Mejri", "Sonia", "Dentiste",
                "dr.mejri@hayet.tn", "+216 74 456 789",
                "Avenue Bourguiba, Centre-Ville", "Sfax", 80.0, 8, "Doctorat en Chirurgie Dentaire");
        medecin2.setNoteMoyenne(4.7);
        medecin2.setNombreConsultations(95);

        System.out.println("  Profil complet médecin 1 :");
        medecin1.afficherProfil();
        System.out.println();
        System.out.println("  Mise à jour du tarif de Dr. Mejri :");
        medecin2.mettreAJourProfil(null, null, 85.0);
        System.out.println();
        System.out.println("  Liste médecins à Tunis :");
        Medecin[] medecins = {medecin1, medecin2};
        for (Medecin m : medecins) {
            if (m.estDans("Tunis")) {
                m.afficherDetails();
            }
        }

        // ──────────────────────────────────────────────────────────
        // FONCTIONNALITÉ 4 — Avis & Notation (Eya)
        // ──────────────────────────────────────────────────────────
        afficherSection("4", "Avis & Notation", "Eya");

        // Créer une consultation terminée
        Consultation consultation = new Consultation(1, patient.getId(),
                patient.getPrenom() + " " + patient.getNom(),
                medecin1.getId(), medecin1.getPrenom() + " " + medecin1.getNom(),
                s1.getId(), "2026-04-14", "10:00", 25.0, "Rhume et fièvre");
        consultation.confirmer();
        consultation.terminer();

        // Soumettre un avis
        Avis avis1 = new Avis();
        avis1.setId(1);
        avis1.setIdUtilisateur(patient.getId());
        avis1.setNomUtilisateur(patient.getPrenom() + " " + patient.getNom());
        avis1.setIdMedecin(medecin1.getId());
        avis1.setNomMedecin(medecin1.getPrenom() + " " + medecin1.getNom());
        avis1.setIdService(s1.getId());
        avis1.soumettre(5, "Très bon médecin, à l'écoute et professionnel.");

        // Avis avec note invalide
        Avis avisInvalide = new Avis();
        avisInvalide.soumettre(7, "Test note invalide");

        // Afficher avis
        System.out.println();
        System.out.println("  Avis soumis :");
        avis1.afficherDetails();

        // Mise à jour de la note du médecin et du service
        medecin1.mettreAJourNote(5.0);
        s1.mettreAJourNote(5.0);
        System.out.println();
        System.out.println("  Note du Dr. " + medecin1.getNom() + " après avis : "
                           + medecin1.getNoteMoyenne() + "/5");

        // ──────────────────────────────────────────────────────────
        // FONCTIONNALITÉ 5 — Tableau de Bord Admin (Maram)
        // ──────────────────────────────────────────────────────────
        afficherSection("5", "Tableau de Bord Administrateur", "Maram");

        Admin admin = new Admin(99, "Bouazizi", "Mariem",
                "admin@hayet.tn", "admin@Secure1", "+216 71 999 000", 2);

        // Initialiser les statistiques
        admin.setNombreUtilisateurs(3);
        admin.setNombreAvisEnAttente(1);

        // Ajouter médecins et services
        admin.ajouterMedecin(medecin1);
        admin.ajouterMedecin(medecin2);
        admin.ajouterService(s1);
        admin.ajouterService(s2);
        admin.ajouterService(s3);
        admin.ajouterService(s4);

        // Enregistrer revenus
        admin.enregistrerRevenu(25.0);
        admin.enregistrerRevenu(80.0);

        // Valider l'avis en attente
        System.out.println();
        System.out.println("  Modération de l'avis :");
        admin.validerAvis(avis1);
        System.out.println();

        // Afficher tableau de bord final
        admin.afficherTableauDeBord();

        // ──────────────────────────────────────────────────────────
        // RÉSUMÉ FINAL
        // ──────────────────────────────────────────────────────────
        afficherSeparateur("─", 60);
        System.out.println("  ✅ Sprint 1 — Toutes les fonctionnalités démontrées");
        System.out.println("  Classes : Utilisateur, Service, Medecin, Avis,");
        System.out.println("            Consultation, Admin (extends Utilisateur)");
        System.out.println("  Interactions : patient → service → médecin → avis → admin");
        afficherSeparateur("═", 60);
    }

    // ─── Utilitaires d'affichage ──────────────────────────────────
    private static void afficherSection(String num, String titre, String responsable) {
        System.out.println();
        afficherSeparateur("─", 60);
        System.out.println("  FONCTIONNALITÉ " + num + " — " + titre);
        System.out.println("  Responsable : " + responsable);
        afficherSeparateur("─", 60);
    }

    private static void afficherSeparateur(String caractere, int longueur) {
        StringBuilder sb = new StringBuilder("  ");
        for (int i = 0; i < longueur; i++) sb.append(caractere);
        System.out.println(sb.toString());
    }
}
