package emsi.cg.redevable.rmq;
import emsi.cg.redevable.entity.Redevable;
import emsi.cg.redevable.entity.Taux;
import emsi.cg.redevable.entity.Taxe;
import emsi.cg.redevable.entity.Terrain;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
@RequiredArgsConstructor

@Getter
@Setter
@ToString
public class DemandePaiementProducer implements Serializable {

     private long terrain;
     private String redevable;
     private long taux;
     private long taxe;
     private String reponseDemande;
     private Long id;



     // Nouvelle propriété pour la réponse

//    public void sendDemandePaiement(DemandePaiement demandePaiement) {
//        rabbitTemplate.convertAndSend("exchange.demandes", "demande.paiement", demandePaiement);
//    }
}