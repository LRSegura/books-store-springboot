package com.laboratory.bookstorebackend;

import com.laboratory.bookstorebackend.model.Writer;
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
}
