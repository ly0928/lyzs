package com.jk.controller;

import com.jk.rabbitmq.Fanout;
import com.jk.rabbitmq.Send;
import com.jk.rabbitmq.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbtimqController {
    @Autowired
    Send send;
    @Autowired
    Fanout fanout;
    @Autowired
    Topic topic;
    @GetMapping("/string")
    public void hello(){
        send.send();
    }
    @GetMapping("/ontToMany")
    public void ontToMany(){
        for(int i=0;i<10;i++){
            send.Sender("send"+i);
        }
    }
    @GetMapping("/fanout")
    public void fanout(){
        fanout.fanout();
    }
    @GetMapping("/topic")
    public void topic(){
        topic.topicMessage();
        topic.topicMessages();
        topic.topicMessagess();
    }
    @GetMapping("TestUser")
    public void TestUser(){
        send.SendUser();
    }
    @GetMapping("/manytoMany")
    public void manytoMany(){
        for(int i=0;i<10;i++){
            send.Sender1(" "+i);
            send.Sender2(" "+i);
        }
    }
}
