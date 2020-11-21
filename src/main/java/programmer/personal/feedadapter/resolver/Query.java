package programmer.personal.feedadapter.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import programmer.personal.feedadapter.model.FeedEntry;
import programmer.personal.feedadapter.model.FeedEntryDescription;
import programmer.personal.feedadapter.repository.FeedEntryDescriptionRepository;
import programmer.personal.feedadapter.repository.FeedEntryRepository;

@Component
public class Query implements GraphQLQueryResolver {
    private final FeedEntryRepository feedEntryRepository;
    private final FeedEntryDescriptionRepository feedEntryDescriptionRepository;
    @Autowired
    public Query(FeedEntryRepository feedEntryRepository, FeedEntryDescriptionRepository feedEntryDescriptionRepository) {
        this.feedEntryRepository = feedEntryRepository;
        this.feedEntryDescriptionRepository = feedEntryDescriptionRepository;
    }
    public Iterable<FeedEntry> findAllFeedEntries() {
        return feedEntryRepository.findAll();
    }
    public Iterable<FeedEntryDescription> findAllFeedEntryDescriptions() {
        return feedEntryDescriptionRepository.findAll();
    }
}