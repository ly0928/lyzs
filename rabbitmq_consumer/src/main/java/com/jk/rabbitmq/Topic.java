package com.jk.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Topic {
    @RabbitListener(queues = "topic.message")
    public void topMessage(String message){
        System.out.println("topic.message1"+message);
    }
    @RabbitListener(queues = "topic.messages")
    public void topMessages(String message){
        System.out.println("topic.message2"+message);
    }
}
