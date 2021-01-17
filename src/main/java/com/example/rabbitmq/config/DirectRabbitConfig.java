package com.example.rabbitmq.config;

import com.example.rabbitmq.constant.RabbitConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Simple&Happiness
 * @Date 2021/1/16 15:32
 * @Description
 **/
@Configuration
public class DirectRabbitConfig {

    // durable:是否持久化,默认是false,持久化队列：会被存储在磁盘上，当消息代理重启时仍然存在，暂存队列：当前连接有效
    // exclusive:默认也是false，只能被当前创建的连接使用，而且当连接关闭后队列即被删除。此参考优先级高于durable
    // autoDelete:是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除。
    // return new Queue("direct_queue_one",true,true,false);

    //一般设置一下队列的持久化就好,其余两个就是默认false
    @Bean
    public Queue directQueueOne(){
        return new Queue(RabbitConstant.DIRECT_QUEUE_ONE, true);
    }

    //Direct交换机 起名：direct_exchange_one
    @Bean
    DirectExchange directExchangeOne() {
        return new DirectExchange(RabbitConstant.DIRECT_EXCHANGE_ONE,true,false);
    }

    //绑定  将队列和交换机绑定, 并设置用于匹配键：DirectRoutingOne
    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(directQueueOne()).to(directExchangeOne()).with("DirectRoutingOne");
    }

    //Direct交换机 起名：direct_lonely_exchange
    @Bean
    DirectExchange lonelyDirectExchange() {
        return new DirectExchange(RabbitConstant.DIRECT_EXCHANGE_LONELY);
    }
}
