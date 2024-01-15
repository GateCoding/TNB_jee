package emsi.cg.redevable.rmq;

import emsi.cg.redevable.entity.Redevable;
import emsi.cg.redevable.service.RedevableService;
import emsi.cg.redevable.service.TerrainMS;
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
    private RedevableService redevableService;

    @Autowired
    private TerrainMS terrainMS;
    @PostMapping("/publish")
    public ResponseEntity<String> demandepublish(@RequestBody DemandePaiementProducer request) {
        template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, request);
        return ResponseEntity.ok("User sent: " + request.toString());
    }
}