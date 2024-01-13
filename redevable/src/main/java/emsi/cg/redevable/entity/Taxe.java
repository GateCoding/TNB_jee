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


    private Taux taux;


    private Terrain terrain;

    private Categorie categorie;

    private Redevable redevable;




    private Double cost;


}
