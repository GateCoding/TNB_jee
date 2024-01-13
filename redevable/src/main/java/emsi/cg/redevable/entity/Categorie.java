package emsi.cg.redevable.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String label;

    public Categorie() {
    }




    @Override
    public String toString() {
        return "Categrie{" +
                "id=" + id +
                ", label='" + label + '\'' +
                '}';
    }
}
