package com.hayet.models;

/**
 * Classe Service — Recherche & Filtrage des Services
 * Responsable : Farah (Scrum Master + Dev)
 * Fonctionnalité : US-03, US-04 (Recherche et affichage des services médicaux)
 */
public class Service {

    // ─── Champs privés ───────────────────────────────────────────
    private int id;
    private String nom;
    private String categorie;      // "Généraliste", "Dentiste", "Dermatologue", etc.
    private String description;
    private double prix;           // en DT (Dinar Tunisien)
    private String localisation;   // Gouvernorat (ex: "Tunis", "Sfax", "Sousse")
    private String adresse;
    private boolean disponible;
    private double noteMoyenne;    // sur 5
    private int nombreAvis;

    // ─── Constructeur vide ────────────────────────────────────────
    public Service() {
        this.disponible = true;
        this.noteMoyenne = 0.0;
        this.nombreAvis = 0;
    }

    // ─── Constructeur complet ─────────────────────────────────────
    public Service(int id, String nom, String categorie, String description,
                   double prix, String localisation, String adresse) {
        this.id = id;
        this.nom = nom;
        this.categorie = categorie;
        this.description = description;
        this.prix = prix;
        this.localisation = localisation;
        this.adresse = adresse;
        this.disponible = true;
        this.noteMoyenne = 0.0;
        this.nombreAvis = 0;
    }

    // ─── Méthodes métier ─────────────────────────────────────────

    /**
     * US-03 : Recherche d'un service par mot-clé
     * Retourne true si ce service correspond au mot-clé
     */
    public boolean correspondARecherche(String motCle) {
        if (motCle == null || motCle.isEmpty()) return false;
        String mc = motCle.toLowerCase();
        return this.nom.toLowerCase().contains(mc)
            || this.categorie.toLowerCase().contains(mc)
            || this.description.toLowerCase().contains(mc)
            || this.localisation.toLowerCase().contains(mc);
    }

    /**
     * US-04 : Filtrage par catégorie
     * Retourne true si ce service appartient à la catégorie demandée
     */
    public boolean filtrerParCategorie(String categorie) {
        return this.categorie.equalsIgnoreCase(categorie);
    }

    /**
     * Filtrage par localisation (gouvernorat)
     */
    public boolean filtrerParLocalisation(String localisation) {
        return this.localisation.equalsIgnoreCase(localisation);
    }

    /**
     * Filtrage par prix maximum
     */
    public boolean filtrerParPrixMax(double prixMax) {
        return this.prix <= prixMax;
    }

    /**
     * Filtrage combiné : localisation + catégorie + prix maximum
     */
    public boolean filtrerCombine(String localisation, String categorie, double prixMax) {
        boolean locOk = localisation == null || filtrerParLocalisation(localisation);
        boolean catOk = categorie == null || filtrerParCategorie(categorie);
        boolean prixOk = prixMax <= 0 || filtrerParPrixMax(prixMax);
        return locOk && catOk && prixOk && this.disponible;
    }

    /**
     * Met à jour la note moyenne après un nouvel avis
     */
    public void mettreAJourNote(double nouvelleNote) {
        double totalActuel = this.noteMoyenne * this.nombreAvis;
        this.nombreAvis++;
        this.noteMoyenne = (totalActuel + nouvelleNote) / this.nombreAvis;
        // arrondi à 1 décimale
        this.noteMoyenne = Math.round(this.noteMoyenne * 10.0) / 10.0;
    }

    /**
     * Affiche les détails du service
     */
    public void afficherDetails() {
        System.out.println("  Service #" + id + " : " + nom);
        System.out.println("  Catégorie   : " + categorie);
        System.out.println("  Description : " + description);
        System.out.println("  Prix        : " + prix + " DT");
        System.out.println("  Lieu        : " + adresse + ", " + localisation);
        System.out.println("  Note        : " + noteMoyenne + "/5 (" + nombreAvis + " avis)");
        System.out.println("  Disponible  : " + (disponible ? "Oui" : "Non"));
    }

    // ─── Getters & Setters ────────────────────────────────────────
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getCategorie() { return categorie; }
    public void setCategorie(String categorie) { this.categorie = categorie; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }

    public String getLocalisation() { return localisation; }
    public void setLocalisation(String localisation) { this.localisation = localisation; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    public double getNoteMoyenne() { return noteMoyenne; }
    public void setNoteMoyenne(double noteMoyenne) { this.noteMoyenne = noteMoyenne; }

    public int getNombreAvis() { return nombreAvis; }
    public void setNombreAvis(int nombreAvis) { this.nombreAvis = nombreAvis; }

    // ─── toString ─────────────────────────────────────────────────
    @Override
    public String toString() {
        return "Service{id=" + id + ", nom='" + nom + "', categorie='" + categorie +
               "', prix=" + prix + " DT, localisation='" + localisation +
               "', note=" + noteMoyenne + "/5}";
    }
}


 // TODO service validation
 // TODO service logic