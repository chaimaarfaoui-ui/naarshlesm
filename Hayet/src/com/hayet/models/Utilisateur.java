package com.hayet.models;

/**
 * Classe Utilisateur — Authentification & Inscription
 * Responsable : Chaima (Product Owner + Dev)
 * Fonctionnalité : US-01, US-02 (Inscription et Connexion)
 */
public class Utilisateur {

    // ─── Champs privés ───────────────────────────────────────────
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private String telephone;
    private String role; // "PATIENT", "VISITEUR", "ADMIN"
    private boolean estConnecte;
    private String dateInscription;

    // ─── Constructeur vide ────────────────────────────────────────
    public Utilisateur() {
        this.estConnecte = false;
        this.role = "VISITEUR";
    }

    // ─── Constructeur complet ─────────────────────────────────────
    public Utilisateur(int id, String nom, String prenom, String email,
                       String motDePasse, String telephone, String role, String dateInscription) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.telephone = telephone;
        this.role = role;
        this.estConnecte = false;
        this.dateInscription = dateInscription;
    }

    // ─── Méthodes métier ─────────────────────────────────────────

    /**
     * US-01 : Inscription d'un nouvel utilisateur
     * Vérifie que l'email n'est pas vide et que le mot de passe est valide
     */
    public boolean sInscrire(String nom, String prenom, String email,
                              String motDePasse, String telephone) {
        if (email == null || email.isEmpty() || !email.contains("@")) {
            System.out.println("❌ Email invalide.");
            return false;
        }
        if (motDePasse == null || motDePasse.length() < 6) {
            System.out.println("❌ Mot de passe trop court (minimum 6 caractères).");
            return false;
        }
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.telephone = telephone;
        this.role = "PATIENT";
        this.dateInscription = "2026-04-16";
        System.out.println("✅ Compte créé : " + prenom + " " + nom + " (" + email + ")");
        return true;
    }

    /**
     * US-02 : Connexion d'un utilisateur existant
     * Vérifie email et mot de passe
     */
    public boolean seConnecter(String email, String motDePasse) {
        if (this.email.equals(email) && this.motDePasse.equals(motDePasse)) {
            this.estConnecte = true;
            System.out.println("✅ Connexion réussie ! Bienvenue " + this.prenom + " " + this.nom);
            return true;
        } else {
            System.out.println("❌ Email ou mot de passe incorrect.");
            return false;
        }
    }

    /**
     * Déconnexion de l'utilisateur
     */
    public void seDeconnecter() {
        this.estConnecte = false;
        System.out.println("✅ Déconnexion réussie.");
    }

    /**
     * Modification du mot de passe
     */
    public boolean modifierMotDePasse(String ancienMdp, String nouveauMdp) {
        if (!this.motDePasse.equals(ancienMdp)) {
            System.out.println("❌ Ancien mot de passe incorrect.");
            return false;
        }
        if (nouveauMdp.length() < 6) {
            System.out.println("❌ Nouveau mot de passe trop court.");
            return false;
        }
        this.motDePasse = nouveauMdp;
        System.out.println("✅ Mot de passe modifié avec succès.");
        return true;
    }

    /**
     * Affiche les détails de l'utilisateur
     */
    public void afficherDetails() {
        System.out.println("  Utilisateur #" + id + " : " + prenom + " " + nom);
        System.out.println("  Email       : " + email);
        System.out.println("  Téléphone   : " + telephone);
        System.out.println("  Rôle        : " + role);
        System.out.println("  Connecté    : " + (estConnecte ? "Oui" : "Non"));
        System.out.println("  Inscrit le  : " + dateInscription);
    }

    // ─── Getters & Setters ────────────────────────────────────────
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public boolean isEstConnecte() { return estConnecte; }
    public void setEstConnecte(boolean estConnecte) { this.estConnecte = estConnecte; }

    public String getDateInscription() { return dateInscription; }
    public void setDateInscription(String dateInscription) { this.dateInscription = dateInscription; }

    // ─── toString ─────────────────────────────────────────────────
    @Override
    public String toString() {
        return "Utilisateur{id=" + id + ", nom='" + prenom + " " + nom +
               "', email='" + email + "', role='" + role + "', connecte=" + estConnecte + "}";
    }
}
// feature models branch updategit gti
// added attributes 
// added constructor
// TODO validation
// TODO fix logic