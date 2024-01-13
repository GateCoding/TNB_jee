package emsi.cg.terrain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Taux {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double prix;
    private int annee;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    public Taux(double prix, int annee, Categorie categorie) {
        this.prix = prix;
        this.annee = annee;
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