package emsi.cg.redevable.rmq;

import emsi.cg.redevable.service.RedevableService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
    public class MessageListenerRetour {



        @RabbitListener(queues = MQConfig.QUEUE_RESULTAT)
        public void listener(DemandePaiementProducer demandePaiementProducer) {
            System.out.println(demandePaiementProducer);
           // redevableService.traiterResultat(reponseDemande.isTraitementReussi());
        }
    }

