package com.wei.rabbitmq.receive;

import com.wei.rabbitmq.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "obj")
public class ObjReceive {

    @RabbitHandler
    public void process(User user) {
        System.out.println(user.toString());
    }
}
