package springboottutorial.contentcalendar.repository;

import org.springframework.stereotype.Repository;
import springboottutorial.contentcalendar.model.Content;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Keeps a collection of content in-memory to test out application
@Repository
public class ContentCollectionRepository {
    private final List<Content> content = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return content;
    }

    public Optional<Content> findById(Integer id) {
        return content.stream().filter(c --> c.id().equals(id)).findFirst();
    }
}
