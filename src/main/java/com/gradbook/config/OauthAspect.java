package com.gradbook.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class OauthAspect {

    /*@Autowired
    private KafkaTemplate<String, String> template;*/

    @Autowired
    private KafkaTemplate<String, String > template;



    @After("execution( *  com.gradbook.controllers..*.*(..))")
    public void tracing(JoinPoint joinPoint){
        this.template.send("ums_logger","The method executed--->");
        System.out.println("the logger--->"+joinPoint.getSignature().toString());
    }

}
