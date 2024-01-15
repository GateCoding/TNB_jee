package emsi.cg.terrain.rmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {
    public static final String QUEUE = "2ite_micro_message_queue";
    public static final String EXCHANGE = "2ite_micro_message_exchange";
    public static final String ROUTING_KEY = "message_routingKey";
    public static final String QUEUE_RESULTAT = "2ite_micro_message_queue_resultat";
    public static final String ROUTING_KEY_RESULTAT = "message_routingKey_resultat";


    @Bean
    public Queue demandeQueue() {
        return new Queue(QUEUE);
    }

    @Bean
    public Queue reponseQueue() {
        return new Queue(QUEUE_RESULTAT);
    }

    @Bean
    public TopicExchange terrainExchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding demandeBinding(Queue demandeQueue, TopicExchange terrainExchange) {
        return BindingBuilder
                .bind(demandeQueue)
                .to(terrainExchange)
                .with(ROUTING_KEY);
    }

    @Bean
    public Binding reponseBinding(Queue reponseQueue, TopicExchange terrainExchange) {
        return BindingBuilder
                .bind(reponseQueue)
                .to(terrainExchange)
                .with(ROUTING_KEY_RESULTAT);
    }

    @Bean
    public MessageConverter terrainMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate terrainTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(terrainMessageConverter());
        return template;
    }


}