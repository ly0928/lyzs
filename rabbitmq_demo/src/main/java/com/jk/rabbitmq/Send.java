package com.jk.rabbitmq;

import com.jk.pojo.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Send {
    @Autowired
    RabbitTemplate rabbitTemplate;
    //一对一
    public void send(){
        rabbitTemplate.convertAndSend("string","1to1");
    }
    //一对多
    public void Sender(String message){
        rabbitTemplate.convertAndSend("ontoMany",message);
    }
    //多对多
    public void Sender1(String message){
        rabbitTemplate.convertAndSend("manytoMany","sender1"+message);
    }
    //多对多
    public void Sender2(String message){
        rabbitTemplate.convertAndSend("manytoMany","sender2"+message);
    }
    //实体类传输
    public void SendUser(){
        User user = new User();
        user.setUserName("ly");
        user.setPassword("aa");
        rabbitTemplate.convertAndSend("user",user);
    }
}
