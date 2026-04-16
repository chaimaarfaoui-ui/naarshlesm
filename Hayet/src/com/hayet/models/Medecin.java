package com.hayet.models;

/**
 * Classe Medecin — Profil Médecin & Équipe
 * Responsable : Malek (Développeur)
 * Fonctionnalité : US-05, US-06 (Gestion et affichage du profil médecin)
 */
public class Medecin {

    // ─── Champs privés ───────────────────────────────────────────
    private int id;
    private String nom;
    private String prenom;
    private String specialite;
    private String email;
    private String telephone;
    private String adresseCabinet;
    private String gouvernorat;
    private double tarifConsultation; // en DT
    private int anneesExperience;
    private String diplome;
    private boolean actif;
    private double noteMoyenne;   // calculée depuis Avis
    private int nombreConsultations;

    // ─── Constructeur vide ────────────────────────────────────────
    public Medecin() {
        this.actif = true;
        this.noteMoyenne = 0.0;
        this.nombreConsultations = 0;
    }

    // ─── Constructeur complet ─────────────────────────────────────
    public Medecin(int id, String nom, String prenom, String specialite,
                   String email, String telephone, String adresseCabinet,
                   String gouvernorat, double tarifConsultation,
                   int anneesExperience, String diplome) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.email = email;
        this.telephone = telephone;
        this.adresseCabinet = adresseCabinet;
        this.gouvernorat = gouvernorat;
        this.tarifConsultation = tarifConsultation;
        this.anneesExperience = anneesExperience;
        this.diplome = diplome;
        this.actif = true;
        this.noteMoyenne = 0.0;
        this.nombreConsultations = 0;
    }

    // ─── Méthodes métier ─────────────────────────────────────────

    /**
     * US-05 : Afficher le profil complet du médecin
     */
    public void afficherProfil() {
        System.out.println("  Dr. " + prenom + " " + nom + " — " + specialite);
        System.out.println("  Cabinet     : " + adresseCabinet + ", " + gouvernorat);
        System.out.println("  Tarif       : " + tarifConsultation + " DT");
        System.out.println("  Expérience  : " + anneesExperience + " ans");
        System.out.println("  Diplôme     : " + diplome);
        System.out.println("  Contact     : " + telephone + " | " + email);
        System.out.println("  Note        : " + noteMoyenne + "/5");
        System.out.println("  Consultations : " + nombreConsultations);
        System.out.println("  Statut      : " + (actif ? "Actif" : "Inactif"));
    }

    /**
     * US-06 : Mettre à jour le profil du médecin
     */
    public void mettreAJourProfil(String telephone, String adresseCabinet,
                                   double nouveauTarif) {
        if (telephone != null && !telephone.isEmpty()) {
            this.telephone = telephone;
        }
        if (adresseCabinet != null && !adresseCabinet.isEmpty()) {
            this.adresseCabinet = adresseCabinet;
        }
        if (nouveauTarif > 0) {
            this.tarifConsultation = nouveauTarif;
        }
        System.out.println("✅ Profil du Dr. " + prenom + " " + nom + " mis à jour.");
    }

    /**
     * Incrémente le compteur de consultations
     */
    public void incrementerConsultations() {
        this.nombreConsultations++;
    }

    /**
     * Met à jour la note moyenne du médecin
     */
    public void mettreAJourNote(double note) {
        // Recalcul de la moyenne pondérée
        if (nombreConsultations == 0) {
            this.noteMoyenne = note;
        } else {
            double total = this.noteMoyenne * nombreConsultations;
            this.noteMoyenne = Math.round(((total + note) / (nombreConsultations + 1)) * 10.0) / 10.0;
        }
    }

    /**
     * Désactiver le compte médecin (admin)
     */
    public void desactiver() {
        this.actif = false;
        System.out.println("⚠️  Dr. " + prenom + " " + nom + " désactivé.");
    }

    /**
     * Vérifier si le médecin est dans un gouvernorat donné
     */
    public boolean estDans(String gouvernorat) {
        return this.gouvernorat.equalsIgnoreCase(gouvernorat);
    }

    /**
     * Affiche les détails (alias court pour les listes)
     */
    public void afficherDetails() {
        System.out.println("  Dr. " + prenom + " " + nom + " | " + specialite +
                           " | " + gouvernorat + " | " + tarifConsultation + " DT | ⭐ " + noteMoyenne);
    }

    // ─── Getters & Setters ────────────────────────────────────────
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getSpecialite() { return specialite; }
    public void setSpecialite(String specialite) { this.specialite = specialite; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getAdresseCabinet() { return adresseCabinet; }
    public void setAdresseCabinet(String adresseCabinet) { this.adresseCabinet = adresseCabinet; }

    public String getGouvernorat() { return gouvernorat; }
    public void setGouvernorat(String gouvernorat) { this.gouvernorat = gouvernorat; }

    public double getTarifConsultation() { return tarifConsultation; }
    public void setTarifConsultation(double tarifConsultation) { this.tarifConsultation = tarifConsultation; }

    public int getAnneesExperience() { return anneesExperience; }
    public void setAnneesExperience(int anneesExperience) { this.anneesExperience = anneesExperience; }

    public String getDiplome() { return diplome; }
    public void setDiplome(String diplome) { this.diplome = diplome; }

    public boolean isActif() { return actif; }
    public void setActif(boolean actif) { this.actif = actif; }

    public double getNoteMoyenne() { return noteMoyenne; }
    public void setNoteMoyenne(double noteMoyenne) { this.noteMoyenne = noteMoyenne; }

    public int getNombreConsultations() { return nombreConsultations; }
    public void setNombreConsultations(int nombreConsultations) { this.nombreConsultations = nombreConsultations; }

    // ─── toString ─────────────────────────────────────────────────
    @Override
    public String toString() {
        return "Medecin{id=" + id + ", nom='Dr. " + prenom + " " + nom +
               "', specialite='" + specialite + "', gouvernorat='" + gouvernorat +
               "', tarif=" + tarifConsultation + " DT, note=" + noteMoyenne + "/5}";
    }
}
