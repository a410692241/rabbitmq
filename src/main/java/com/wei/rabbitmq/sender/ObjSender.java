package com.wei.rabbitmq.sender;

import com.wei.rabbitmq.entity.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendObj(User user) {
        rabbitTemplate.convertAndSend("obj", user);
    }
}
