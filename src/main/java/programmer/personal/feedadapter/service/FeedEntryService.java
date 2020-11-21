package programmer.personal.feedadapter.service;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import programmer.personal.feedadapter.model.FeedEntry;
import programmer.personal.feedadapter.repository.FeedEntryRepository;

import java.util.List;

@Log
@Service
public class FeedEntryService {
    @Autowired
    private FeedEntryRepository feedEntryRepository;

    public FeedEntry save(FeedEntry feedEntry) {
        return feedEntryRepository.save(feedEntry);
    }

    public List<FeedEntry> findAll() {
        return feedEntryRepository.findAll();
    }

    public void deleteAll() {
        feedEntryRepository.deleteAll();
    }

    public void deleteFeedEntryBy(FeedEntry feedEntry) {
        feedEntryRepository.delete(feedEntry);
    }

    public FeedEntry existsByUrl(String url){
        return feedEntryRepository.existsByUrl(url);
    }
}
