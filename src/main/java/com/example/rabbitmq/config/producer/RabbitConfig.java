package com.example.rabbitmq.config.producer;

import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Simple&Happiness
 * @Date 2021/1/17 11:34
 * @Description
 **/
@Configuration
public class RabbitConfig {

    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);

        //设置开启Mandatory,才能触发回调函数,无论消息推送结果怎么样都强制调用回调函数
        rabbitTemplate.setMandatory(true);

        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                System.out.println("ConfirmCallback:     "+"相关数据："+correlationData);
                System.out.println("ConfirmCallback:     "+"确认情况："+ack);
                System.out.println("ConfirmCallback:     "+"原因："+cause);
            }
        });

        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {
            @Override
            public void returnedMessage(ReturnedMessage returnedMessage) {
                System.out.println("ReturnsCallback:     "+"消息："+returnedMessage.getMessage());
                System.out.println("ReturnsCallback:     "+"回应码："+returnedMessage.getReplyCode());
                System.out.println("ReturnsCallback:     "+"回应信息："+returnedMessage.getReplyText());
                System.out.println("ReturnsCallback:     "+"交换机："+returnedMessage.getExchange());
                System.out.println("ReturnsCallback:     "+"路由键："+returnedMessage.getRoutingKey());
            }
        });

        return rabbitTemplate;
    }

}
