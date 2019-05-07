package com.wei.rabbitmq.receive;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.C")
public class FanoutReceiver3 {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("fanout Receiver C" + msg);
    }

}
