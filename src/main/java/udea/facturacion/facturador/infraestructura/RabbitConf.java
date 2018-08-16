package udea.facturacion.facturador.infraestructura;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;

@Configuration
public class RabbitConf {

    @Bean
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("otter.rmq.cloudamqp.com");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("kuotergv");
        connectionFactory.setPassword("CNUUOgJ3ueMNoRIBa6WCJQMCtJsSjumx");
        connectionFactory.setChannelCheckoutTimeout(1000);
        connectionFactory.setRequestedHeartBeat(300);
        connectionFactory.setVirtualHost("kuotergv");
        return connectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        return  rabbitTemplate;
    }

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames("facturacion.solicitada.factura");
        container.setMessageListener(new Consumidor());
        container.setAcknowledgeMode(AcknowledgeMode.AUTO);
        return container;
    }

}