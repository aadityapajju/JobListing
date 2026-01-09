package com.Hirist.JobListing.AOPImpl;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //@Before("execution(* com.hirist.joblisting.controller.*.*(..))")
    @Before("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void log(JoinPoint joinPoint){
        //System.out.println("➡️ Entering: " + joinPoint.getSignature());
        LOGGER.info("➡️ Entering: " + joinPoint.getSignature());
    }

    @AfterReturning(
            pointcut = "execution(* com.hirist.joblisting.controller.*.*(..))",
            returning = "response"
    )
    public void logAfter(JoinPoint joinPoint, Object response) {
        System.out.println("⬅️ Exiting: " + joinPoint.getSignature());
        System.out.println("Response: " + response);
    }
}
