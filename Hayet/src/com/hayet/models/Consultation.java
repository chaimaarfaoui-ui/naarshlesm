package com.hayet.models;

/**
 * Classe Consultation — Prise de Rendez-vous
 * Classe commune (partagée entre membres) — interactions entre fonctionnalités
 * Utilisée par : Chaima (auth), Farah (recherche), Malek (médecin), Eya (avis), Maram (admin)
 */
public class Consultation {

    // ─── Champs privés ───────────────────────────────────────────
    private int id;
    private int idPatient;
    private String nomPatient;
    private int idMedecin;
    private String nomMedecin;
    private int idService;
    private String dateConsultation;
    private String heureConsultation;
    private String statut; // "EN_ATTENTE", "CONFIRMEE", "ANNULEE", "TERMINEE"
    private double montantPaye; // en DT
    private String motif;
    private boolean avisLaisseApresCours;

    // ─── Constructeur vide ────────────────────────────────────────
    public Consultation() {
        this.statut = "EN_ATTENTE";
        this.avisLaisseApresCours = false;
        this.montantPaye = 0.0;
    }

    // ─── Constructeur complet ─────────────────────────────────────
    public Consultation(int id, int idPatient, String nomPatient,
                        int idMedecin, String nomMedecin, int idService,
                        String dateConsultation, String heureConsultation,
                        double montantPaye, String motif) {
        this.id = id;
        this.idPatient = idPatient;
        this.nomPatient = nomPatient;
        this.idMedecin = idMedecin;
        this.nomMedecin = nomMedecin;
        this.idService = idService;
        this.dateConsultation = dateConsultation;
        this.heureConsultation = heureConsultation;
        this.statut = "EN_ATTENTE";
        this.montantPaye = montantPaye;
        this.motif = motif;
        this.avisLaisseApresCours = false;
    }

    // ─── Méthodes métier ─────────────────────────────────────────

    /**
     * Confirmer la consultation (par le médecin ou la plateforme)
     */
    public void confirmer() {
        this.statut = "CONFIRMEE";
        System.out.println("✅ Consultation #" + id + " confirmée — "
                           + dateConsultation + " à " + heureConsultation
                           + " avec Dr. " + nomMedecin);
    }

    /**
     * Annuler la consultation
     */
    public void annuler(String raison) {
        this.statut = "ANNULEE";
        System.out.println("❌ Consultation #" + id + " annulée. Raison : " + raison);
    }

    /**
     * Terminer la consultation (marquer comme faite)
     */
    public void terminer() {
        this.statut = "TERMINEE";
        System.out.println("✅ Consultation #" + id + " terminée. Paiement : "
                           + montantPaye + " DT");
    }

    /**
     * Marquer l'avis comme laissé
     */
    public void marquerAvisLaisse() {
        this.avisLaisseApresCours = true;
    }

    /**
     * Vérifier si la consultation est terminée (et donc notation possible)
     */
    public boolean peutEtreNotee() {
        return "TERMINEE".equals(this.statut) && !avisLaisseApresCours;
    }

    /**
     * Afficher les détails de la consultation
     */
    public void afficherDetails() {
        System.out.println("  Consultation #" + id);
        System.out.println("  Patient     : " + nomPatient);
        System.out.println("  Médecin     : Dr. " + nomMedecin);
        System.out.println("  Date        : " + dateConsultation + " à " + heureConsultation);
        System.out.println("  Motif       : " + motif);
        System.out.println("  Statut      : " + statut);
        System.out.println("  Montant     : " + montantPaye + " DT");
    }

    // ─── Getters & Setters ────────────────────────────────────────
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdPatient() { return idPatient; }
    public void setIdPatient(int idPatient) { this.idPatient = idPatient; }

    public String getNomPatient() { return nomPatient; }
    public void setNomPatient(String nomPatient) { this.nomPatient = nomPatient; }

    public int getIdMedecin() { return idMedecin; }
    public void setIdMedecin(int idMedecin) { this.idMedecin = idMedecin; }

    public String getNomMedecin() { return nomMedecin; }
    public void setNomMedecin(String nomMedecin) { this.nomMedecin = nomMedecin; }

    public int getIdService() { return idService; }
    public void setIdService(int idService) { this.idService = idService; }

    public String getDateConsultation() { return dateConsultation; }
    public void setDateConsultation(String dateConsultation) { this.dateConsultation = dateConsultation; }

    public String getHeureConsultation() { return heureConsultation; }
    public void setHeureConsultation(String heureConsultation) { this.heureConsultation = heureConsultation; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public double getMontantPaye() { return montantPaye; }
    public void setMontantPaye(double montantPaye) { this.montantPaye = montantPaye; }

    public String getMotif() { return motif; }
    public void setMotif(String motif) { this.motif = motif; }

    public boolean isAvisLaisseApresCours() { return avisLaisseApresCours; }
    public void setAvisLaisseApresCours(boolean avisLaisseApresCours) {
        this.avisLaisseApresCours = avisLaisseApresCours;
    }

    // ─── toString ─────────────────────────────────────────────────
    @Override
    public String toString() {
        return "Consultation{id=" + id + ", patient='" + nomPatient +
               "', medecin='Dr. " + nomMedecin + "', date='" + dateConsultation +
               "', statut='" + statut + "', montant=" + montantPaye + " DT}";
    }
}
