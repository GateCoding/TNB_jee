package emsi.cg.terrain.rmq;


import emsi.cg.terrain.entity.Redevable;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(Redevable message) {
        System.out.println("ttttt");
        System.out.println(message);
    }
}