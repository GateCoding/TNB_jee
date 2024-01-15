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
    @PostMapping("/demandecreate")
    public DemandePaiementProducer saveDemande(@RequestBody DemandePaiementProducer request) {
        // Process the request and return the modified object
        request.setRedevable(redevableService.findByCin(request.getRedevable().getCin()));
        request.setTaux(terrainMS.tauxById(request.getTaux().getId()));
        request.setTerrain(terrainMS.terrainById(request.getTerrain().getId()));
        return request;
    }


    @PostMapping("/publish")
    public ResponseEntity<String> demandepublish( @RequestBody DemandePaiementProducer request) {
        request = new DemandePaiementProducer(
                (terrainMS.terrainById(request.getTerrain().getId()))
                ,redevableService.findByCin(request.getRedevable().getCin())
                ,terrainMS.tauxById(request.getTaux().getId()));

        // Send the serialized object to the message broker
        template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, request);
        return ResponseEntity.ok("User sent: " + request.toString());
    }
}