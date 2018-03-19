package com.apress.spring;

import com.apress.spring.service.JournalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootWebApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringBootWebApplication.class);
//    @Bean
//    InitializingBean saveData(JournalRepository repo) {
//        return () -> {
//            repo.save(new Journal("Get to know Spring Boot",
//                    "Today I will learn Spring Boot", "01/01/2016"));
//            repo.save(new Journal("Simple Spring Boot Project",
//                    "I will do my first Spring Boot Project", "01/02/2016"));
//            repo.save(new Journal("Spring Boot Reading",
//                    "Read more about Spring Boot", "02/01/2016"));
//            repo.save(new Journal("Spring Boot in the Cloud",
//                    "Spring Boot using Cloud Foundry", "03/01/2016"));
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }

    @Bean
    CommandLineRunner start(JournalService service){
        return args -> {
            log.info("@@ Inserting Data....");
//            service.insertData();
            log.info("@@ findAll() call...");
            service.findAll().forEach(entry -> log.info(entry.toString()));
        };
    }
}