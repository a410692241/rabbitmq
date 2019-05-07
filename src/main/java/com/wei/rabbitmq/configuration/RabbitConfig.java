package com.wei.rabbitmq.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

    @Bean
    public Queue getQueue() {
        return new Queue("hello");
    }

    @Bean
    public Queue getObj() {
        return new Queue("obj");
    }

    @Bean
    Queue queueMessage() {
        return new Queue("topic.message");
    }

    @Bean
    Queue queueMessages() {
        return new Queue("topic.messages");
    }


    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("exange");
    }

    @Bean
    Binding bindingExangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
}
