package com.jk.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Fanout {
    @RabbitListener(queues="fanout.A")
    public void fanoutReveiceA(String message){
        System.out.println(message);
    }
    @RabbitListener(queues="fanout.B")
    public void fanoutReveiceB(String message){
        System.out.println(message);
    }
    @RabbitListener(queues="fanout.C")
    public void fanoutReveiceC(String message){
        System.out.println(message);
    }
}
