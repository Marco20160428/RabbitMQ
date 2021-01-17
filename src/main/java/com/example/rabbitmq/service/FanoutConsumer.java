package com.example.rabbitmq.service;

import com.example.rabbitmq.constant.RabbitConstant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author Simple&Happiness
 * @Date 2021/1/17 10:46
 * @Description
 **/
@Component
public class FanoutConsumer {

    @RabbitListener(queues = RabbitConstant.FANOUT_QUEUE_A)
    @RabbitHandler
    public void processA(Map testMessage) {
        System.out.println("FANOUT_QUEUE_A 消费者收到消息  : " +testMessage.toString());
    }

    @RabbitListener(queues = RabbitConstant.FANOUT_QUEUE_B)
    @RabbitHandler
    public void processB(Map testMessage) {
        System.out.println("FANOUT_QUEUE_B 消费者收到消息  : " +testMessage.toString());
    }

    @RabbitListener(queues = RabbitConstant.FANOUT_QUEUE_C)
    @RabbitHandler
    public void processC(Map testMessage) {
        System.out.println("FANOUT_QUEUE_C 消费者收到消息  : " +testMessage.toString());
    }
}
