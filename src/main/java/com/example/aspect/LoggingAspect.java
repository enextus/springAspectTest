package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.example.aspect.service.*.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        logger.info("Метод " + joinPoint.getSignature().getName() + " вызван!");
        System.out.println("Метод " + joinPoint.getSignature().getName() + " вызван!");

        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            logger.debug("Аргумент " + (i + 1) + ": " + args[i]);
            System.out.println("Аргумент " + (i + 1) + ": " + args[i]);
        }
    }

    @After("execution(* com.example.aspect.service.*.*(..))")
    public void afterMethod(JoinPoint joinPoint) {
        logger.info("Метод " + joinPoint.getSignature().getName() + " завершен!");
        System.out.println("Метод " + joinPoint.getSignature().getName() + " завершен!");
    }

}
