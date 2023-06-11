package springboottutorial.contentcalendar.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import springboottutorial.contentcalendar.model.Content;
import springboottutorial.contentcalendar.model.Status;
import springboottutorial.contentcalendar.repository.ContentCollectionRepository;
import springboottutorial.contentcalendar.repository.ContentJdbcTemplateRepository;
import springboottutorial.contentcalendar.repository.ContentRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
@CrossOrigin // allows cors
public class ContentController {

    // This was previously private final ContentCollectionRepository repository;
    // We no longer need to use ContentCollectionRepository and create methods to interact with the database
    // because Spring Data JPA provides those CRUD operations
    private final ContentRepository repository;
    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Content> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!"));
    }

    @ResponseStatus(HttpStatus.CREATED) // returns response when new content is created
    @PostMapping("")
    public void create(@Valid @RequestBody Content content) {
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id) {
        if(!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!");
        }
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

   // This example demonstrates storing specific queries in order to find content that contains a keyword.
   // It utilizes the Spring Data JPA query creation mechanism.
   @GetMapping("/filter/{keyword}")
    public List<Content> findByTitle(@PathVariable String keyword)  {
       return repository.findAllByTitleContains(keyword);
   }

   // This one uses manual query creation
    @GetMapping("/filter/status/{status}")
    public List<Content> findByStatus(@PathVariable Status status) {
        return repository.listByStatus(status);
    }


}
