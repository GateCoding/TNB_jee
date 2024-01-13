package emsi.cg.redevable.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Taux {

    private long id;
    private double prix;
    private int annee;

    @ManyToOne
    @Transient
    private Categorie categorie;
}
