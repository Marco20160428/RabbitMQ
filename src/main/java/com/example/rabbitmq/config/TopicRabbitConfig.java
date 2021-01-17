package com.example.rabbitmq.config;

import com.example.rabbitmq.constant.RabbitConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Simple&Happiness
 * @Date 2021/1/17 9:23
 * @Description
 **/
@Configuration
public class TopicRabbitConfig {

    // 绑定到 TopicExchangeOne   routing key topic.man
    @Bean
    public Queue getTopicQueueOne(){
        return new Queue(RabbitConstant.TOPIC_QUEUE_ONE, true);
    }

    // 绑定到 TopicExchangeOne   routing key topic.woman
    @Bean
    public Queue getTopicQueueTwo(){
        return new Queue(RabbitConstant.TOPIC_QUEUE_TWO, true);
    }

    @Bean
    public TopicExchange getTopicExchangeOne() {
        return new TopicExchange(RabbitConstant.TOPIC_EXCHANGE_ONE);
    }

    //将 QueueOne 和 ExchangeOne 绑定,而且绑定的键值为 topic.man
    //这样只要是消息携带的路由键是topic.man,才会分发到该队列
    @Bean
    public Binding bindingExchangeMessage() {
        return BindingBuilder.bind(getTopicQueueOne()).to(getTopicExchangeOne()).with(RabbitConstant.TOPIC_MAN);
    }

    // 将 QueueTwo 和 ExchangeOne 绑定,而且绑定的键值为用上通配路由键规则 topic.#
    // 这样只要是消息携带的路由键是以topic.开头,都会分发到该队列
    @Bean
    public Binding bindingExchangeMessage2() {
        return BindingBuilder.bind(getTopicQueueTwo()).to(getTopicExchangeOne()).with("topic.#");
    }
}
