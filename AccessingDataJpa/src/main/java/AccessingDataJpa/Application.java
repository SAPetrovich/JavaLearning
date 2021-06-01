package AccessingDataJpa;

import lombok.extern.java.Log;
//import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Optional;

@SpringBootApplication
//@Slf4j
@Log
public class Application {

    public static void main(String[] args) {
        //SpringApplication.run(Application.class);
        SpringApplication application = new SpringApplication(Application.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }

    @Bean
    public CommandLineRunner demoSave(CustomerRepository repository) {
        return (args) -> {
            log.info("demoSave");
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));
            log.info("");
        };
    }

    @Bean
    public CommandLineRunner demoFindAll(CustomerRepository repository) {
        return (args) -> {
            log.info("demoFindAll");
            log.info("┌──────────────────────────────────────────");
            repository.findAll().forEach(customer -> log.info("│ "+customer.toString()));
//            for (Customer customer : repository.findAll()) {
//                log.info("│ "+customer.toString());
//            }
            log.info("└──────────────────────────────────────────");
        };
    }

    @Bean
    public CommandLineRunner demoFindByLastName(CustomerRepository repository) {
        return (args) -> {
            log.info("demoFindByLastName");
            Arrays.asList("Bauer","Farmer").forEach(name -> {
                log.info("Customer found with findByLastName('"+name+"'}):" );
                log.info("┌──────────────────────────────────────────");
                repository.findByLastName(name).forEach(bauer -> log.info("│ "+bauer.toString()));
                log.info("└──────────────────────────────────────────");
            });
            log.info("");
        };
    }

    @Bean
    public CommandLineRunner demoFindById(CustomerRepository repository) {
        return (args) -> {
            log.info("demoFindById");
            Arrays.asList(1,10).forEach(id -> {
                Optional<Customer> customer = repository.findById(id);
                if (!customer.isPresent()) {
                    //log.info("Customer with findById({}) not found", id);
                    log.info("Customer with findById("+id+") not found");
                } else {
                    log.info("Customer found with findById("+id+"): "+customer);
                }
            });
            log.info("");
        };
    }

}
