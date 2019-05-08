package com.wei.rabbitmq.receive;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 只接受hello的队列接收者
 */
@Component
@RabbitListener(queues = "hello")
public class HelloReceive2 {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("接收器二号收到的消息是:" + msg);
    }

}
