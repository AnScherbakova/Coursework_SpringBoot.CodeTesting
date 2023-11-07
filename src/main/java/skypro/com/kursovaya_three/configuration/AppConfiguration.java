package skypro.com.kursovaya_three.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import skypro.com.kursovaya_three.service.UtilService;

import java.util.Random;

@Configuration
public class AppConfiguration {
    @Bean
    public Random random() {
        return new Random();
    }

    @Bean
    public UtilService utilService() {
        return new UtilService();
    }
}
