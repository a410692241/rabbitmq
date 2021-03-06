package com.wei.rabbitmq.sender;


import java.util.Date;
 
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSender2 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String msg) {
        String sendMsg = msg + "helloSender2" + new Date();
        rabbitTemplate.convertAndSend("hello", sendMsg);
    }

}
