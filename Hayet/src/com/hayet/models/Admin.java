package com.hayet.models;

/**
 * Classe Admin — Tableau de Bord Administrateur
 * Responsable : Maram (Développeur)
 * Fonctionnalité : US-09, US-10 (Gestion et supervision de la plateforme)
 * 
 * Admin hérite de Utilisateur (relation d'héritage)
 */
public class Admin extends Utilisateur {

    // ─── Champs privés spécifiques à Admin ───────────────────────
    private int niveauAcces;         // 1 = modérateur, 2 = super-admin
    private int nombreUtilisateurs;
    private int nombreMedecins;
    private int nombreServices;
    private int nombreAvisEnAttente;
    private double revenuJournalier;  // en DT
    private String derniereConnexion;

    // ─── Constructeur vide ────────────────────────────────────────
    public Admin() {
        super();
        super.setRole("ADMIN");
        this.niveauAcces = 1;
        this.nombreUtilisateurs = 0;
        this.nombreMedecins = 0;
        this.nombreServices = 0;
        this.nombreAvisEnAttente = 0;
        this.revenuJournalier = 0.0;
    }

    // ─── Constructeur complet ─────────────────────────────────────
    public Admin(int id, String nom, String prenom, String email,
                 String motDePasse, String telephone, int niveauAcces) {
        super(id, nom, prenom, email, motDePasse, telephone, "ADMIN", "2026-04-16");
        this.niveauAcces = niveauAcces;
        this.nombreUtilisateurs = 0;
        this.nombreMedecins = 0;
        this.nombreServices = 0;
        this.nombreAvisEnAttente = 0;
        this.revenuJournalier = 0.0;
        this.derniereConnexion = "2026-04-16";
    }

    // ─── Méthodes métier ─────────────────────────────────────────

    /**
     * US-09 : Afficher le tableau de bord complet
     */
    public void afficherTableauDeBord() {
        System.out.println("  ╔══════════════════════════════════╗");
        System.out.println("  ║     TABLEAU DE BORD — HAYET      ║");
        System.out.println("  ╚══════════════════════════════════╝");
        System.out.println("  Admin        : " + getPrenom() + " " + getNom()
                           + " (Niveau " + niveauAcces + ")");
        System.out.println("  ────────────────────────────────────");
        System.out.println("  👤 Utilisateurs inscrits  : " + nombreUtilisateurs);
        System.out.println("  🩺 Médecins actifs        : " + nombreMedecins);
        System.out.println("  🏥 Services disponibles   : " + nombreServices);
        System.out.println("  ⏳ Avis en attente        : " + nombreAvisEnAttente);
        System.out.println("  💰 Revenus du jour        : " + revenuJournalier + " DT");
        System.out.println("  📅 Dernière connexion     : " + derniereConnexion);
        if (nombreAvisEnAttente > 0) {
            System.out.println("  ⚠️  ALERTE : " + nombreAvisEnAttente + " avis à modérer !");
        }
    }

    /**
     * US-10 : Ajouter un nouveau médecin à la plateforme
     */
    public void ajouterMedecin(Medecin medecin) {
        if (medecin == null) {
            System.out.println("❌ Médecin invalide.");
            return;
        }
        this.nombreMedecins++;
        System.out.println("✅ Dr. " + medecin.getPrenom() + " " + medecin.getNom()
                           + " ajouté. Total médecins : " + nombreMedecins);
    }

    /**
     * Supprimer un médecin (désactivation)
     */
    public void supprimerMedecin(Medecin medecin) {
        if (medecin == null) return;
        medecin.desactiver();
        this.nombreMedecins--;
        System.out.println("✅ Médecin retiré. Total médecins : " + nombreMedecins);
    }

    /**
     * Valider un avis en attente
     */
    public void validerAvis(Avis avis) {
        if (avis == null) return;
        avis.valider();
        if (this.nombreAvisEnAttente > 0) this.nombreAvisEnAttente--;
    }

    /**
     * Rejeter un avis
     */
    public void rejeterAvis(Avis avis, String motif) {
        if (avis == null) return;
        avis.rejeter(motif);
        if (this.nombreAvisEnAttente > 0) this.nombreAvisEnAttente--;
    }

    /**
     * Ajouter un service à la plateforme
     */
    public void ajouterService(Service service) {
        if (service == null) return;
        this.nombreServices++;
        System.out.println("✅ Service '" + service.getNom()
                           + "' ajouté. Total services : " + nombreServices);
    }

    /**
     * Enregistrer un nouveau revenu (ex: consultation payée)
     */
    public void enregistrerRevenu(double montant) {
        this.revenuJournalier += montant;
        System.out.println("💰 Revenu enregistré : +" + montant + " DT → Total jour : "
                           + revenuJournalier + " DT");
    }

    /**
     * Affiche statistiques détaillées
     */
    public void afficherDetails() {
        afficherTableauDeBord();
    }

    // ─── Getters & Setters ────────────────────────────────────────
    public int getNiveauAcces() { return niveauAcces; }
    public void setNiveauAcces(int niveauAcces) { this.niveauAcces = niveauAcces; }

    public int getNombreUtilisateurs() { return nombreUtilisateurs; }
    public void setNombreUtilisateurs(int nombreUtilisateurs) { this.nombreUtilisateurs = nombreUtilisateurs; }

    public int getNombreMedecins() { return nombreMedecins; }
    public void setNombreMedecins(int nombreMedecins) { this.nombreMedecins = nombreMedecins; }

    public int getNombreServices() { return nombreServices; }
    public void setNombreServices(int nombreServices) { this.nombreServices = nombreServices; }

    public int getNombreAvisEnAttente() { return nombreAvisEnAttente; }
    public void setNombreAvisEnAttente(int nombreAvisEnAttente) { this.nombreAvisEnAttente = nombreAvisEnAttente; }

    public double getRevenuJournalier() { return revenuJournalier; }
    public void setRevenuJournalier(double revenuJournalier) { this.revenuJournalier = revenuJournalier; }

    public String getDerniereConnexion() { return derniereConnexion; }
    public void setDerniereConnexion(String derniereConnexion) { this.derniereConnexion = derniereConnexion; }

    // ─── toString ─────────────────────────────────────────────────
    @Override
    public String toString() {
        return "Admin{nom='" + getPrenom() + " " + getNom() +
               "', niveauAcces=" + niveauAcces +
               ", medecins=" + nombreMedecins +
               ", utilisateurs=" + nombreUtilisateurs +
               ", revenuJour=" + revenuJournalier + " DT}";
    }
}
// TODO admin validation
// TODO admin logic