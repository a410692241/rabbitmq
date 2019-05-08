package com.wei.rabbitmq;

import com.wei.rabbitmq.entity.User;
import com.wei.rabbitmq.sender.HelloSender1;
import com.wei.rabbitmq.sender.HelloSender2;
import com.wei.rabbitmq.sender.MessageSender;
import com.wei.rabbitmq.sender.ObjSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Provider {
    @Autowired
    private HelloSender1 sender1;
    @Autowired
    private HelloSender2 sender2;
    @Autowired
    private ObjSender objSender;
    @Autowired
    private MessageSender messageSender;

    /**
     *
     */
    @Test
    public void test() {
        sender1.send("发送一对一");
    }


    /**
     * 多对多的消息
     */
    @Test
    public void oneToMany() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            sender1.send("发送一对多");
        }
    }

    /**
     * 和一对多一样,2个接收器都是均匀接收所有消息
     * 由于每一条消息只能被一个topic消费,所以应该是2个接收器各消费50次
     */
    @Test
    public void manyToMany() {
        for (int i = 0; i < 100; i++) {
            sender1.send("1发送多对多");
            sender2.send("2发送多对多");
        }
    }

    /**
     * springboot以及完美的支持对象的发送和接收，不需要格外的配置。
     */
    @Test
    public void sendObj() {
        User user = new User();
        user.setId(1);
        user.setUsername("hu");
        user.setPassword("123");
        objSender.sendObj(user);
    }

    /**
     * 我已经声明了一个交换机fanoutExchange
     * 同时有三个队列连接在此交换机上
     * 当我对该交换机fanoutExchange发送消息时
     * 三个队列将会接收到我发送的消息
     */
    @Test
    public void sendMsg() {
        messageSender.send1();
    }
}
