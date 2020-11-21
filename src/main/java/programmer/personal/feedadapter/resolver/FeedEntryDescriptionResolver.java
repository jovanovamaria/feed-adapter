package programmer.personal.feedadapter.resolver;

import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import programmer.personal.feedadapter.model.FeedEntry;
import programmer.personal.feedadapter.model.FeedEntryDescription;
import programmer.personal.feedadapter.repository.FeedEntryRepository;

import java.util.Optional;

@Component
public class FeedEntryDescriptionResolver implements GraphQLResolver<FeedEntryDescription> {
    private FeedEntryRepository feedEntryRepository;
    @Autowired
    public FeedEntryDescriptionResolver(FeedEntryRepository feedEntryRepository) {
        this.feedEntryRepository = feedEntryRepository;
    }

    public Optional<FeedEntry> getFeedEntry (FeedEntryDescription feedEntryDescription) {
        return feedEntryRepository.findById(feedEntryDescription.getFeedEntry().getId());
    }
}

