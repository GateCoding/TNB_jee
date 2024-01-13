package emsi.cg.terrain.entity;

import jakarta.persistence.*;

import java.util.List;

public class Redevable {

    private long id;
    private String nom;
    private String prenom;
    private String cin;
    public Redevable() {
    }

    public Redevable( String nom, String prenom, String cin) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
    }

    public Redevable(String nom, String prenom, String cin, List<Terrain> terrains) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.terrains = terrains;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public List<Terrain> getTerrains() {
        return terrains;
    }

    public void setTerrains(List<Terrain> terrains) {
        this.terrains = terrains;
    }

    @Override
    public String toString() {
        return "Redevable{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", cin='" + cin + '\'' +
                ", terrains=" + terrains +
                '}';
    }
}
