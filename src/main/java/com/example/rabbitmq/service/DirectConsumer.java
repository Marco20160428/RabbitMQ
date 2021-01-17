package com.example.rabbitmq.service;

import com.example.rabbitmq.constant.RabbitConstant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author Simple&Happiness
 * @Date 2021/1/16 21:02
 * @Description
 **/
@Component
public class DirectConsumer {

    @RabbitListener(queues = RabbitConstant.DIRECT_QUEUE_ONE)//监听的队列名称 direct_queue_one
    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("DirectReceiver direct_queue_one process 消费者收到消息  : " + testMessage.toString());
    }

    @RabbitListener(queues = RabbitConstant.DIRECT_QUEUE_ONE)//监听的队列名称 direct_queue_one
    @RabbitHandler
    public void process2(Map testMessage) {
        System.out.println("DirectReceiver direct_queue_one process2 消费者收到消息  : " + testMessage.toString());
    }
}
