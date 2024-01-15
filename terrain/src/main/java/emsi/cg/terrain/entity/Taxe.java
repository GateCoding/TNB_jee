package emsi.cg.terrain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Taxe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private boolean pay;
    private double cost;

    @ManyToOne
    @JoinColumn(name = "taux_id")
    private Taux taux;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "terrain_id")
    private Terrain terrain;

    @ManyToOne
    private Categorie categorie;

    @ManyToOne
    @Transient
    private Redevable redevable;
    private String redevablecin;

//    public Taxe(boolean pay, double cost, Taux taux, Terrain terrain, Categorie categorie, String redevablecin) {
//        this.pay = pay;
//        this.cost = cost;
//        this.taux = taux;
//        this.terrain = terrain;
//        this.categorie = categorie;
//        this.redevablecin = redevablecin;
//    }

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