package com.laboratory.bookstorebackend.util;

import com.laboratory.bookstorebackend.model.Customer;
import com.laboratory.bookstorebackend.model.Writer;
import com.laboratory.bookstorebackend.model.repository.CustomerRepository;
import com.laboratory.bookstorebackend.model.repository.WriterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDataBase {

    private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);

    @Bean
    CommandLineRunner initDatabase(WriterRepository repository){
        return args -> {
            log.info("PreLoading " + repository.save(new Writer("John","Doe")));
            log.info("PreLoading " + repository.save(new Writer("Louis","Doe")));

        };
    }

    @Bean
    CommandLineRunner initDatabaseCustomer(CustomerRepository repository){
        return args -> {
            log.info("PreLoading " + repository.save(new Customer("Jade","Doe")));
            log.info("PreLoading " + repository.save(new Customer("Sara","Doe")));

        };
    }
}
