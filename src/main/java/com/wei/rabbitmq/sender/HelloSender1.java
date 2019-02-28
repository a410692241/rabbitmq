package com.wei.rabbitmq.sender;

import java.util.Date;
 
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 

@Component
public class HelloSender1 {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String msg) {
        String sendMsg = "helloSender1 " + new Date();
        rabbitTemplate.convertAndSend("hello", sendMsg);
    }

}