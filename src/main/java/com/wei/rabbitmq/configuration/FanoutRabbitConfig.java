package com.wei.rabbitmq.configuration;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitConfig {

    @Bean
    public Queue AMessage() {
        return new Queue("fanout.A");
    }

    @Bean
    public Queue BMessage() {
        return new Queue("fanout.B");
    }

    @Bean
    public Queue CMessage() {
        return new Queue("fanout.C");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingExchangeA(Queue AMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("TopicExchange");
    }

    @Bean
    Binding topicBindA(Queue AMessage, TopicExchange topicExchange) {
        return BindingBuilder.bind(AMessage).to(topicExchange).with("*.wei.#");
    }

    @Bean
    Binding topicBindB(Queue BMessage, TopicExchange topicExchange) {
        return BindingBuilder.bind(BMessage).to(topicExchange).with("*.wei.#");
    }

    @Bean
    Binding topicBindC(Queue CMessage, TopicExchange topicExchange) {
        return BindingBuilder.bind(CMessage).to(topicExchange).with("*.wei.#");
    }

}