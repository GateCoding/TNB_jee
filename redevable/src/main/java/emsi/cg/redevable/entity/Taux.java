package emsi.cg.redevable.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor

public class Taux {


    private long id;
    private double prix;
    private int annee;


    private Categorie categorie;

    public Taux() {
    }


}
