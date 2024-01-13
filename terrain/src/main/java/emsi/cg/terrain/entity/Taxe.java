package emsi.cg.terrain.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Taxe {
    private long id;
    private boolean pay;
    private double cost;

    @ManyToOne
    @JoinColumn(name = "taux_id")
    private Taux taux;

    @ManyToOne
    @JoinColumn(name = "terrain_id")
    private Terrain terrain;

    @ManyToOne
    private Categorie categorie;

    @ManyToOne
    @Transient
    private Redevable redevable;


    public Taxe(boolean pay, Taux taux, Terrain terrain, Categorie categorie, Redevable redevable, Double cost) {
        this.pay = pay;
        this.taux = taux;
        this.terrain = terrain;
        this.categorie = categorie;
        this.redevable = redevable;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Taxe{" +
                "id=" + id +
                ", pay=" + pay +
                ", taux=" + taux +
                ", terrain=" + terrain +
                ", categorie=" + categorie +
                ", redevable=" + redevable +
                ", cost=" + cost +
                '}';
    }
}