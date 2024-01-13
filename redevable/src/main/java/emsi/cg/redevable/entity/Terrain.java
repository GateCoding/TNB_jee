package emsi.cg.redevable.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Terrain {

    private long id;
    private double surface;


    private Redevable redevable;

    private Categorie categorie;





    @Override
    public String toString() {
        return "Terrain{" +
                "id=" + id +
                ", surface=" + surface +
                ", redevable=" + redevable +
                ", categorie=" + categorie +
            //    ", taxes=" + taxes +
                '}';
    }
}
