package com.jk.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Topic {
    @Autowired
    RabbitTemplate rabbitTemplate;
    //规则投递消息
    public void topicMessage(){
        rabbitTemplate.convertAndSend("topicExchange","topic.message","ok");
    }
    public void topicMessages(){
        rabbitTemplate.convertAndSend("topicExchange","topic.messages","ok");
    }
    public void topicMessagess(){
        rabbitTemplate.convertAndSend("topicExchange","topic.messages.all","ok");
    }
}