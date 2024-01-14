package emsi.cg.terrain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Redevable implements Serializable {

    private long id;
    private String nom;
    private String prenom;


    private String cin;

    @Transient
    @OneToMany
    List<Terrain> terrains;

    public Redevable( String nom, String prenom, String cin) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
    }

    @Override
    public String toString() {
        return "Redevable{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", cin='" + cin + '\'' +
                ", terrains=" + terrains +
                '}';
    }
}
