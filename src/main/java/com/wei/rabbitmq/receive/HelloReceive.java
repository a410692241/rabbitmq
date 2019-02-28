package com.wei.rabbitmq.receive;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 只接受hello的队列接收者
 */
@Component
@RabbitListener(queues = "hello")
public class HelloReceive {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("接收器一号收到的消息是:" + hello);
    }
}
