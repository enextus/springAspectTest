package com.example.aspect;

import com.example.aspect.service.MathService;
import com.example.aspect.service.SimpleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Properties;

@SpringBootApplication
public class AspectApplication {
    private static final Logger logger = LoggerFactory.getLogger(AspectApplication.class);

    public static void main(String[] args) {
        clearLog();

        ConfigurableApplicationContext context = SpringApplication.run(AspectApplication.class, args);

        SimpleService service = context.getBean(SimpleService.class);
        service.performAction("My message!", 10);  // При вызове этого метода также сработают методы аспекта.

        MathService mathService = context.getBean(MathService.class);
        mathService.computeDifference(1000, 45);
        mathService.computeSum(888, 42);

    }

    private static void clearLog() {
        String defaultLogFilePath = "logs/app.log"; // Значение по умолчанию
        String logFilePath = getLogFilePathFromProperties().orElse(defaultLogFilePath);

        try {
            PrintWriter writer = new PrintWriter(logFilePath);
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e) {
            logger.error("Error clearing the log file.", e);
        }
    }

    private static Optional<String> getLogFilePathFromProperties() {
        Properties properties = new Properties();
        try {
            FileInputStream in = new FileInputStream("src/main/resources/application.properties");
            properties.load(in);
            in.close();

            String logFileName = properties.getProperty("logging.file.name");
            return Optional.ofNullable(logFileName);
        } catch (IOException e) {
            logger.warn("Unable to read log file path from application.properties.", e);
            return Optional.empty();
        }
    }

}
