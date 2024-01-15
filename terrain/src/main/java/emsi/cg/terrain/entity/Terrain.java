package emsi.cg.terrain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Terrain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double surface;

    @ManyToOne
    @JoinColumn(name = "redevable_cin")
    @Transient
    private Redevable redevable;
    private String redevablecin;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @OneToMany(mappedBy = "terrain", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Taxe> taxes;

    public Terrain(double surface, String redevableid, Categorie categorie) {
        this.surface = surface;
        this.redevablecin = redevableid;
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Terrain{" +
                "id=" + id +
                ", surface=" + surface +
                ", redevable=" + redevable +
                ", categorie=" + categorie +
                ", taxes=" + taxes +
                '}';
    }
}