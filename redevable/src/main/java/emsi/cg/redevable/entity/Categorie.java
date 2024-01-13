package emsi.cg.redevable.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Categorie {

    private long id;
    private String label;
    
    @Override
    public String toString() {
        return "Categrie{" +
                "id=" + id +
                ", label='" + label + '\'' +
                '}';
    }
}
