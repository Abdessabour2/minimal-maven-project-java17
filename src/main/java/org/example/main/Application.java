package org.example.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Properties;

@SpringBootApplication
@RestController
public class Application {

    private final Properties properties = loadProperties();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/")
    public String home() {
        //String version = properties.getProperty("version", "-");
        return String.format("Hello World");
    }

    private Properties loadProperties() {
        Properties props = new Properties();
        try {
            props.load(Application.class.getClassLoader().getResourceAsStream("app.properties"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return props;
    }
}
