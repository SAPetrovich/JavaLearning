package com.github.SAPetrovich.AccessingDataJpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Optional;

@SpringBootApplication
@Slf4j  // Использование библиотеки протоколирования org.slf4j
//@Log // Использование библиотеки протоколирования java.util.logging
public class Application {

    public static void main(String[] args) {
        //SpringApplication.run(Application.class);
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

    @Bean
    public CommandLineRunner demoFindAll(CustomerRepository repository) {
        return (args) -> {
            log.info("┌───────── FindAll:");
            repository.findAll()
                    .forEach(customer -> log.info("│ {}", customer.toString()));
            log.info("└──────────────────────────────────────────");
        };
    }

    @Bean
    public CommandLineRunner demoFindByLastName(CustomerRepository repository) {
        return (args) -> {
            Arrays.asList("Bauer","Farmer")
                    .forEach(name -> {
                        log.info("┌───────── findByLastName('{}'):", name);
                        repository.findByLastName(name).forEach(bauer -> log.info("│ {}", bauer.toString()));
                        log.info("└──────────────────────────────────────────");
                    });
        };
    }

    @Bean
    public CommandLineRunner demoFindById(CustomerRepository repository) {
        return (args) -> {
            log.info("┌───────── FindById:");
            Arrays.asList(1,10).forEach(id -> {
                Optional<Customer> customer = repository.findById(id);
                log.info("│ findById({}): {}, isPresent={}", id, customer, customer.isPresent());
            });
            log.info("└──────────────────────────────────────────");
        };
    }

}
