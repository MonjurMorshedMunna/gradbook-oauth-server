package com.gradbook.config;

import com.gradbook.models.ActivityLogger;
import com.gradbook.models.user.User;
import com.gradbook.models.user.UserRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@Aspect
public class OauthAspect {

    /*@Autowired
    private KafkaTemplate<String, String> template;*/

  @Autowired
  private KafkaTemplate<String, String> template;

  @Autowired
  private UserRepository userRepository;


  @After("execution( *  com.gradbook.controllers..*.*(..))")
  public void tracing(JoinPoint joinPoint) throws Exception {
    ActivityLogger activityLogger = new ActivityLogger();
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    User user = userRepository.findByEmail(authentication.getName());
    activityLogger.setUserId(user.getId().toString());
    activityLogger.setClassName(joinPoint.getClass().getName());
    activityLogger.setMethodName(joinPoint.getSignature().getName());
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    activityLogger.setAccessTime(timestamp);

    ObjectMapper mapper = new ObjectMapper();
    String jsonToString = mapper.writeValueAsString(activityLogger);
    this.template.send("ums_logger", jsonToString);
  }

}
