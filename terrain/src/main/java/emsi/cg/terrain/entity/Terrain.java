package emsi.cg.terrain.entity;

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
    @JoinColumn(name = "redevable_id")
    @Transient
    private Redevable redevable;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @OneToMany(mappedBy = "terrain", fetch = FetchType.EAGER)
    private List<Taxe> taxes;

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