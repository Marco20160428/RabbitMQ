package com.example.rabbitmq.config;

import com.example.rabbitmq.constant.RabbitConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Simple&Happiness
 * @Date 2021/1/17 10:11
 * @Description
 **/
@Configuration
public class FanoutRabbitConfig {

    /**
     *  创建三个队列 ：fanout.A   fanout.B  fanout.C
     *  将三个队列都绑定在交换机 fanoutExchange 上
     *  因为是扇型交换机, 路由键无需配置,配置也不起作用
     */
    @Bean
    public Queue queueA() {
        return new Queue(RabbitConstant.FANOUT_QUEUE_A);
    }

    @Bean
    public Queue queueB() {
        return new Queue(RabbitConstant.FANOUT_QUEUE_B);
    }

    @Bean
    public Queue queueC() {
        return new Queue(RabbitConstant.FANOUT_QUEUE_C);
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(RabbitConstant.FANOUT_EXCHANGE);
    }

    @Bean
    Binding bindingExchangeA() {
        return BindingBuilder.bind(queueA()).to(fanoutExchange());
    }

    @Bean
    Binding bindingExchangeB() {
        return BindingBuilder.bind(queueB()).to(fanoutExchange());
    }

    @Bean
    Binding bindingExchangeC() {
        return BindingBuilder.bind(queueC()).to(fanoutExchange());
    }

}
