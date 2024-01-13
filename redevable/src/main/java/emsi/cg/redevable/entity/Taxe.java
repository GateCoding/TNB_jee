package emsi.cg.redevable.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Taxe {

    private long id;
    private boolean pay;
    private double cost;

    @ManyToOne
    @Transient
    private Taux taux;

    @ManyToOne
    @Transient
    private Terrain terrain;

    @ManyToOne
    @Transient
    private Categorie categorie;

    @ManyToOne
    @Transient
    private Redevable redevable;

}
