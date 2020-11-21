package programmer.personal.feedadapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import programmer.personal.feedadapter.model.FeedEntry;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface FeedEntryRepository extends JpaRepository<FeedEntry, Long> {
    @Query(value="select f.* from FEEDENTRIES f where f.URL = ?1", nativeQuery = true)
    FeedEntry existsByUrl(@Param("url") String url);
}
