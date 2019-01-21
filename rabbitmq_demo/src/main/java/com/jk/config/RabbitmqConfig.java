package com.jk.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {
    @Bean
    public Queue hello(){
        return new Queue("string");
    }
    @Bean
    public Queue onetoMany(){
        return new Queue("ontoMany");
    }
    @Bean
    public Queue sendUser(){
        return new Queue("user");
    }
    @Bean
    public Queue sendMany(){
        return new Queue("manytoMany");
    }
}
