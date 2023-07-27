package com.example.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.aspect.service.*.*(..))")
    public void beforeMethod() {
        System.out.println("Метод вызван!");
    }

    @After("execution(* com.example.aspect.service.*.*(..))")
    public void afterMethod() {
        System.out.println("Метод завершен!");
    }
}
