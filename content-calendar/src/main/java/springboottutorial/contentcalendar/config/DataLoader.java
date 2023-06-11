package springboottutorial.contentcalendar.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Component;
import springboottutorial.contentcalendar.model.Content;
import springboottutorial.contentcalendar.repository.ContentRepository;

import java.io.InputStream;
import java.util.List;

// CommandLineRunner runs after dependency injection happens, as the application is started up
// This is one way of loading data and will this class file here as an example, but it is not used
// The other way can be seen in the Application.java file which uses CommandLineRunner
@Component
public class DataLoader implements CommandLineRunner {

    private final ContentRepository repository;
    private final ObjectMapper objectMapper;  // Create objects out of json and deserialize them

    public DataLoader(ContentRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/content.json")) {
            repository.saveAll(objectMapper.readValue(inputStream, new TypeReference<List<Content>>(){}));
        }
    }
}
