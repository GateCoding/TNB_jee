package com.example.tnb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Taux {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double prix;
    private int annee;

    public Taux() {
    }

    public Taux(double prix, int annee) {
        this.prix = prix;
        this.annee = annee;
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

    @Override
    public String toString() {
        return "Taux{" +
                "id=" + id +
                ", prix=" + prix +
                ", annee=" + annee +
                '}';
    }
}
