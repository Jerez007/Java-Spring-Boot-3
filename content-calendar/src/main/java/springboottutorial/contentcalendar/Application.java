package springboottutorial.contentcalendar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import springboottutorial.contentcalendar.config.ContentCalendarProperties;
import springboottutorial.contentcalendar.model.Content;
import springboottutorial.contentcalendar.model.Status;
import springboottutorial.contentcalendar.model.Type;
import springboottutorial.contentcalendar.repository.ContentRepository;

import java.time.LocalDateTime;
import java.util.Arrays;

@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
