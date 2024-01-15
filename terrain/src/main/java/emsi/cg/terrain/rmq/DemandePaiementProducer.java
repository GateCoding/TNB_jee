package emsi.cg.terrain.rmq;

import emsi.cg.terrain.entity.Redevable;
import emsi.cg.terrain.entity.Taux;
import emsi.cg.terrain.entity.Taxe;
import emsi.cg.terrain.entity.Terrain;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
public class DemandePaiementProducer implements Serializable {

//    @Autowired
//    private AmqpTemplate rabbitTemplate;
    private long terrain;
    private String redevable;
    private long taux;
    private long taxe;
    private  String reponseDemande;
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    // Nouvelle propriété pour la réponse

//    public void sendDemandePaiement(DemandePaiement demandePaiement) {
//        rabbitTemplate.convertAndSend("exchange.demandes", "demande.paiement", demandePaiement);
//    }
}
