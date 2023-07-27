package com.example.aspect;

import com.example.aspect.service.SimpleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AspectApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AspectApplication.class, args);
        SimpleService service = context.getBean(SimpleService.class);
        service.performAction();  // При вызове этого метода также сработают методы аспекта.
    }

}
