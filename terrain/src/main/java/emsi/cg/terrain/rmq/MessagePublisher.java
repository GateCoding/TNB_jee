package emsi.cg.terrain.rmq;


import emsi.cg.terrain.entity.Taux;
import emsi.cg.terrain.entity.Taxe;
import emsi.cg.terrain.entity.Terrain;
import emsi.cg.terrain.service.TaxeService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
@RestController
public class MessagePublisher {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private TaxeService taxeService;

    @PostMapping("/publish")
        public ResponseEntity<String> responsepublish(@RequestBody DemandePaiementProducer demande) {
        System.out.println("ffffffffffffffffffffffffff"+demande.getTaxe());
        Taxe t;
            if (demande.getTaxe()==0){
                template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY_RESULTAT, demande);
                return ResponseEntity.ok("Response sent: " + demande+ "Status sent: " + demande);
            }else{
              t=taxeService.findById(demande.getTaxe());
             t.setPay(true);
             taxeService.update(t);
            template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY_RESULTAT, demande);
        return ResponseEntity.ok("Response sent: " + demande+ "Status sent: " + demande);
            }
    }
}