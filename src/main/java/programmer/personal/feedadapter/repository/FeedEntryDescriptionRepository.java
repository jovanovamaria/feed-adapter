package programmer.personal.feedadapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import programmer.personal.feedadapter.model.FeedEntryDescription;

public interface FeedEntryDescriptionRepository extends JpaRepository<FeedEntryDescription, Long> {
}
