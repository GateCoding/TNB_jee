package com.example.tnb.entity;

import jakarta.persistence.*;

@Entity
public class Taux {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double prix;
    private int annee;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    public Taux() {
    }

    public Taux(double prix, int annee, Categorie categorie) {
        this.prix = prix;
        this.annee = annee;
        this.categorie = categorie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Taux{" +
                "id=" + id +
                ", prix=" + prix +
                ", annee=" + annee +
                ", categorie=" + categorie +
                '}';
    }
}
