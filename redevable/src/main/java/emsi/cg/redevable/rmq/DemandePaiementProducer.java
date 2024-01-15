package emsi.cg.redevable.rmq;
import emsi.cg.redevable.entity.Redevable;
import emsi.cg.redevable.entity.Taux;
import emsi.cg.redevable.entity.Terrain;
import lombok.*;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
@RequiredArgsConstructor

@AllArgsConstructor
@Getter
@Setter
@ToString
public class DemandePaiementProducer implements Serializable {


     Terrain terrain;
     Redevable redevable;
     Taux taux;


}
