package springboottutorial.contentcalendar.repository;


import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import springboottutorial.contentcalendar.model.Content;
import springboottutorial.contentcalendar.model.Status;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {

    // At runtime, this will get turned into a query.  It utilizes the Spring Data JPA query creation mechanism.
    List<Content> findAllByTitleContains(String keyword);

    // Compared to the code above, this one uses manual query creation
    @Query("""
        SELECT * FROM Content
        where status = :status
    """)
    List<Content> listByStatus(@Param("status") Status status);
}
