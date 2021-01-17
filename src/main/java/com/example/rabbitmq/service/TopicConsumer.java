package com.example.rabbitmq.service;

import com.example.rabbitmq.constant.RabbitConstant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author Simple&Happiness
 * @Date 2021/1/17 9:37
 * @Description
 **/
@Component
public class TopicConsumer {

    @RabbitListener(queues = RabbitConstant.TOPIC_QUEUE_ONE)
    @RabbitHandler
    public void processWoman(Map testMessage) {
        System.out.println("消费者收到 queues topic.man 消息: " + testMessage.toString());
    }

    @RabbitListener(queues = RabbitConstant.TOPIC_QUEUE_TWO)
    @RabbitHandler
    public void processMan(Map testMessage) {
        System.out.println("消费者收到 queues topic.woman 消息: " + testMessage.toString());
    }
}
