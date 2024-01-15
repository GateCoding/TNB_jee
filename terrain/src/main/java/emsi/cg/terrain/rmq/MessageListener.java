package emsi.cg.terrain.rmq;


import emsi.cg.terrain.entity.Redevable;
import emsi.cg.terrain.repository.DemandeRepository;
import emsi.cg.terrain.service.TaxeService;
import emsi.cg.terrain.service.TerrainService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    @Autowired
    private TaxeService taxeService;

    RabbitTemplate template;

//    @RabbitListener(queues = MQConfig.QUEUE)
//    public void listener(DemandePaiementProducer demande) {
//        System.out.println("Reçu une demande : " + demande);
//        taxeService.traiterDemandePaiement(demande);
//
//      //  boolean traitementReussi = terrainService.traiterDemandePaiement(demande);
//
//     //   System.out.println("ttttt");
//       // System.out.println("hheloo  "+demande);
//        //va publier autre message
//        template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY_RETOUR, traitementReussi);
//
//
//    }
    @Autowired
    DemandeRepository demandeRepository;
    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(DemandePaiementProducer demande) {
         demandeRepository.save(demande);
        System.out.println(demande);

    }

    //    template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY_RESULTAT, reponse)
 //   ReponseDemande reponse = taxeService.traiterDemandePaiement(demande);


}