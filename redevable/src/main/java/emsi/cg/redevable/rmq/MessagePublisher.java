package emsi.cg.redevable.rmq;

import emsi.cg.redevable.entity.Redevable;
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

    @PostMapping("/publish")
    public ResponseEntity<String> demandepublish(@RequestBody Redevable message) {
       message.setTerrains(null);
       message.setId(5);
       message.setNom("mery");
       message.setPrenom("elmari");
        message.setCin("EE866");
        //message.setTerrains();
        template.convertAndSend(MQConfig.EXCHANGE,
                MQConfig.ROUTING_KEY, message);

            return ResponseEntity.ok("user sent: " + message);
    }
}