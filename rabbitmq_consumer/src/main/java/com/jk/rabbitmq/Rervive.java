package com.jk.rabbitmq;

import com.jk.pojo.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Rervive {
    @RabbitListener(queues = "string")
    public void rervice(String hello){
        System.out.println(hello);
    }
    @RabbitListener(queues = "ontoMany")
    public void rerviceOne(String message){
        System.out.println("service1"+message);
    }
    @RabbitListener(queues = "ontoMany")
    public void rerviceTwo(String message){
        System.out.println("service2"+message);
    }
    @RabbitListener(queues = "user")
    public void TestUser(User user){
        System.out.println(user.getUserName()+" "+user.getPassword());
    }
    @RabbitListener(queues = "manytoMany")
    public void rerviceManyOne(String message){
        System.out.println("service1  "+message);
    }
    @RabbitListener(queues = "manytoMany")
    public void rerviceManyTwo(String message){
        System.out.println("service2  "+message);
    }
}
