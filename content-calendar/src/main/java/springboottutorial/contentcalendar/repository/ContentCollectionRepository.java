package springboottutorial.contentcalendar.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import springboottutorial.contentcalendar.model.Content;
import springboottutorial.contentcalendar.model.Status;
import springboottutorial.contentcalendar.model.Type;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Keeps a collection of content in-memory to test out application
@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }


    public void save(Content content) {
        contentList.add(content);
    }

    @PostConstruct
    private void init() {
        Content content = new Content(1,
                "My first Blog Post",
                "My first blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "");

        contentList.add(content);
    }

}
