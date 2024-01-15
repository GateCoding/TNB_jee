package emsi.cg.terrain.rmq;

import emsi.cg.terrain.entity.Redevable;
import emsi.cg.terrain.entity.Taux;
import emsi.cg.terrain.entity.Terrain;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class DemandePaiementProducer implements Serializable {

//    @Autowired
//    private AmqpTemplate rabbitTemplate;
    private Terrain terrain;
    private Redevable redevable;
    private Taux taux;

//    public void sendDemandePaiement(DemandePaiement demandePaiement) {
//        rabbitTemplate.convertAndSend("exchange.demandes", "demande.paiement", demandePaiement);
//    }
}
