package emsi.cg.redevable.service;

import emsi.cg.redevable.entity.Redevable;
import emsi.cg.redevable.entity.Terrain;
import emsi.cg.redevable.repository.RedevableRepository;
import emsi.cg.redevable.rmq.DemandePaiementProducer;
import emsi.cg.redevable.rmq.MQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedevableService {

    @Autowired
    RedevableRepository rr;
    @Autowired
    TerrainMS terrainMS;


    @Autowired
    private RabbitTemplate template;

//    public void traiterDemandePaiement(DemandePaiementProducer demande, boolean traitementReussi) {
//        // Effectuez le traitement côté redevable ici, par exemple, en envoyant un message de résultat au redevable.
//
//        String cinRedevable = demande.getRedevable().getCin();
//        if (traitementReussi) {
//            // Envoyez un message de succès au redevable
//            String message = "Votre demande de paiement a été traitée avec succès.";
//            envoyerMessageAuRedevable(cinRedevable, message);
//        } else {
//            // Envoyez un message d'échec au redevable
//            String message = "La demande de paiement a échoué. Veuillez contacter le support.";
//            envoyerMessageAuRedevable(cinRedevable, message);
//        }
//    }

//    private void envoyerMessageAuRedevable(String cinRedevable, String message) {
//
//        template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY_RESULTAT, message);
//    }

    public Redevable save(Redevable o) {
        return rr.save(o);
    }

    public void update(Redevable o) {
        rr.save(o);
    }

    public void delete(long id) {
        rr.delete(rr.findById(id));
    }

    public Redevable findByCin(String cin) {
        return rr.findByCin(cin);
    }

    public List<Redevable> findAll(){
        return rr.findAll();
    }

    public List<Terrain> findAllTerrain(Redevable redevable){
        return terrainMS.findByRedevableCin(redevable.getCin());
    }



    public void traiterResultat(boolean traitementReussi) {
        if (traitementReussi) {
            System.out.println("Notification de succès ");
        } else {
            System.out.println("Notification d'échec");
        }
        // Vous pouvez également effectuer d'autres actions en fonction du résultat
    }

    public Redevable findById(long id){
        return rr.findById(id);
    }


}
