package pl.edu.wszib.vocabtool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@PropertySource("classpath:db.properties")
public class VocabToolApplication {

//    public static final Logger logger = LoggerFactory.getLogger(VocabToolApplication.class);
//
//    public void hello() {
//        logger.info("hello");
//    }
    public static void main(String[] args) {
        SpringApplication.run(VocabToolApplication.class, args);
    }

}
