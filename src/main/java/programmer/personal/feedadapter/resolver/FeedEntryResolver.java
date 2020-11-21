package programmer.personal.feedadapter.resolver;

import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import programmer.personal.feedadapter.model.FeedEntry;
import programmer.personal.feedadapter.model.FeedEntryDescription;
import programmer.personal.feedadapter.repository.FeedEntryDescriptionRepository;

@Component
public class FeedEntryResolver implements GraphQLResolver<FeedEntry> {

    private FeedEntryDescriptionRepository feedEntryDescriptionRepository;
    @Autowired
    public FeedEntryResolver(FeedEntryDescriptionRepository feedEntryDescriptionRepository) {
        this.feedEntryDescriptionRepository = feedEntryDescriptionRepository;
    }

    public FeedEntryDescription getFeedEntry(FeedEntry feedEntry) {
        return feedEntryDescriptionRepository.findById(feedEntry.getFeedEntryDescription().getId()).orElse(null);
    }
}