package com.wei.rabbitmq.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UnReceiverSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String sendMsg) {
        rabbitTemplate.convertAndSend("tb", sendMsg);

    }
}
