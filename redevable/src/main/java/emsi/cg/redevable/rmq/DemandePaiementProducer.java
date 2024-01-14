package emsi.cg.redevable.rmq;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandePaiementProducer {

    @Autowired
    private AmqpTemplate rabbitTemplate;

//    public void sendDemandePaiement(DemandePaiement demandePaiement) {
//        rabbitTemplate.convertAndSend("exchange.demandes", "demande.paiement", demandePaiement);
//    }
}
