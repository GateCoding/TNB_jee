package emsi.cg.redevable.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.util.List;

@Entity
public class Redevable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nom;
    private String prenom;
    private String cin;

//    @JsonIgnore
//    @Transient
//    List<Terrain> terrains;
    public Redevable() {
    }


    @Override
    public String toString() {
        return "Redevable{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", cin='" + cin + '\'' +
              //  ", terrains=" + terrains +
                '}';
    }
}
