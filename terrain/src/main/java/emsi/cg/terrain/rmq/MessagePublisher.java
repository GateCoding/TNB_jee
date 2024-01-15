package emsi.cg.terrain.rmq;


import emsi.cg.terrain.service.TaxeService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagePublisher {

    @Autowired
    private RabbitTemplate template;

@Autowired
private TaxeService taxeService;
    @PostMapping("/publish")
        public ResponseEntity<String> responsepublish(@RequestBody DemandePaiementProducer demande) {

            template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY_RESULTAT, demande);
        return ResponseEntity.ok("Response sent: " + demande+ "Status sent: " + demande);
    }
}