package com.hayet.models;

/**
 * Classe Avis — Avis & Notation
 * Responsable : Eya (Développeur)
 * Fonctionnalité : US-07, US-08 (Soumission et consultation des avis)
 */
public class Avis {

    // ─── Champs privés ───────────────────────────────────────────
    private int id;
    private int idUtilisateur;
    private String nomUtilisateur;
    private int idMedecin;
    private String nomMedecin;
    private int idService;
    private int note;          // note de 1 à 5
    private String commentaire;
    private String dateAvis;
    private boolean valide;    // modéré par admin
    private String reponseAdmin;

    // ─── Constructeur vide ────────────────────────────────────────
    public Avis() {
        this.valide = false;
    }

    // ─── Constructeur complet ─────────────────────────────────────
    public Avis(int id, int idUtilisateur, String nomUtilisateur,
                int idMedecin, String nomMedecin, int idService,
                int note, String commentaire, String dateAvis) {
        this.id = id;
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.idMedecin = idMedecin;
        this.nomMedecin = nomMedecin;
        this.idService = idService;
        this.note = note;
        this.commentaire = commentaire;
        this.dateAvis = dateAvis;
        this.valide = false;
        this.reponseAdmin = null;
    }

    // ─── Méthodes métier ─────────────────────────────────────────

    /**
     * US-07 : Soumettre un avis sur un médecin / service
     * Valide les données et crée l'avis
     */
    public boolean soumettre(int note, String commentaire) {
        if (note < 1 || note > 5) {
            System.out.println("❌ Note invalide. La note doit être entre 1 et 5.");
            return false;
        }
        if (commentaire == null || commentaire.trim().length() < 10) {
            System.out.println("❌ Commentaire trop court (minimum 10 caractères).");
            return false;
        }
        this.note = note;
        this.commentaire = commentaire.trim();
        this.dateAvis = "2026-04-16";
        System.out.println("✅ Avis soumis : " + note + "/5 ⭐ — en attente de validation.");
        return true;
    }

    /**
     * US-08 : Valider un avis (admin)
     */
    public void valider() {
        this.valide = true;
        System.out.println("✅ Avis #" + id + " de " + nomUtilisateur + " validé.");
    }

    /**
     * Rejeter un avis (admin)
     */
    public void rejeter(String motif) {
        this.valide = false;
        this.reponseAdmin = motif;
        System.out.println("❌ Avis #" + id + " rejeté. Motif : " + motif);
    }

    /**
     * Répondre à un avis (admin)
     */
    public void repondre(String reponse) {
        this.reponseAdmin = reponse;
        System.out.println("✅ Réponse ajoutée à l'avis #" + id);
    }

    /**
     * Vérifier si l'avis appartient à un utilisateur donné
     */
    public boolean appartientA(int idUtilisateur) {
        return this.idUtilisateur == idUtilisateur;
    }

    /**
     * Afficher l'avis complet
     */
    public void afficherDetails() {
        System.out.println("  Avis #" + id + " — " + dateAvis);
        System.out.println("  Par         : " + nomUtilisateur);
        System.out.println("  Pour        : Dr. " + nomMedecin + " (Service #" + idService + ")");
        System.out.println("  Note        : " + afficherEtoiles(note) + " (" + note + "/5)");
        System.out.println("  Commentaire : " + commentaire);
        System.out.println("  Statut      : " + (valide ? "✅ Validé" : "⏳ En attente"));
        if (reponseAdmin != null) {
            System.out.println("  Réponse     : " + reponseAdmin);
        }
    }

    /**
     * Affiche des étoiles visuelles selon la note
     */
    private String afficherEtoiles(int note) {
        StringBuilder etoiles = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            etoiles.append(i < note ? "⭐" : "☆");
        }
        return etoiles.toString();
    }

    // ─── Getters & Setters ────────────────────────────────────────
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdUtilisateur() { return idUtilisateur; }
    public void setIdUtilisateur(int idUtilisateur) { this.idUtilisateur = idUtilisateur; }

    public String getNomUtilisateur() { return nomUtilisateur; }
    public void setNomUtilisateur(String nomUtilisateur) { this.nomUtilisateur = nomUtilisateur; }

    public int getIdMedecin() { return idMedecin; }
    public void setIdMedecin(int idMedecin) { this.idMedecin = idMedecin; }

    public String getNomMedecin() { return nomMedecin; }
    public void setNomMedecin(String nomMedecin) { this.nomMedecin = nomMedecin; }

    public int getIdService() { return idService; }
    public void setIdService(int idService) { this.idService = idService; }

    public int getNote() { return note; }
    public void setNote(int note) { this.note = note; }

    public String getCommentaire() { return commentaire; }
    public void setCommentaire(String commentaire) { this.commentaire = commentaire; }

    public String getDateAvis() { return dateAvis; }
    public void setDateAvis(String dateAvis) { this.dateAvis = dateAvis; }

    public boolean isValide() { return valide; }
    public void setValide(boolean valide) { this.valide = valide; }

    public String getReponseAdmin() { return reponseAdmin; }
    public void setReponseAdmin(String reponseAdmin) { this.reponseAdmin = reponseAdmin; }

    // ─── toString ─────────────────────────────────────────────────
    @Override
    public String toString() {
        return "Avis{id=" + id + ", utilisateur='" + nomUtilisateur +
               "', medecin='Dr. " + nomMedecin + "', note=" + note +
               "/5, valide=" + valide + "}";
    }
}
