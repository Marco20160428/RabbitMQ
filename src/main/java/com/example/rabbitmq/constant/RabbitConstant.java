package com.example.rabbitmq.constant;

/**
 * @Author Simple&Happiness
 * @Date 2021/1/16 15:34
 * @Description
 **/
public class RabbitConstant {

    // Direct
    public static final String DIRECT_QUEUE_ONE = "direct_queue_one";

    public static final String DIRECT_EXCHANGE_ONE = "direct_exchange_one";
    public static final String DIRECT_EXCHANGE_LONELY = "direct_exchange_lonely";


    // Topic
    public static final String TOPIC_QUEUE_ONE = "topic_queue_one";
    public static final String TOPIC_QUEUE_TWO = "topic_queue_two";

    public static final String TOPIC_EXCHANGE_ONE = "topic_exchange_one";

    public final static String TOPIC_MAN = "topic.man";
    public final static String TOPIC_WOMAN = "topic.woman";


    // Fanout
    public static final String FANOUT_QUEUE_A = "fanout_queue_a";
    public static final String FANOUT_QUEUE_B = "fanout_queue_b";
    public static final String FANOUT_QUEUE_C = "fanout_queue_c";

    public static final String FANOUT_EXCHANGE = "fanout_exchange";

}
