package springboottutorial.contentcalendar.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

// CommandLineRunner runs after dependency injection happens, as the application is started up
// This is one way of loading data and will this class file here as an example, but it is not used
// The other way can be seen in the Application.java file which uses CommandLineRunner
//@Component
public class DataLoader implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello");
    }
}
