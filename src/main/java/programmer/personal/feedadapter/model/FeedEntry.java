package programmer.personal.feedadapter.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "feedentries")
public class FeedEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @OneToOne(mappedBy="feedEntry", cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @PrimaryKeyJoinColumn
    private FeedEntryDescription feedEntryDescription;
    private String title;
    private String author;
    private LocalDateTime publicationDate;
    @Column(columnDefinition = "TEXT")
    private String url;
    private String imageUrl;

    public FeedEntry() {
    }

    public FeedEntry(FeedEntryDescription feedEntryDescription, String title, String author, LocalDateTime publicationDate, String url, String imageUrl) {
        this.feedEntryDescription = feedEntryDescription;
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.url = url;
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedEntry feedEntry = (FeedEntry) o;
        return id.equals(feedEntry.id);
    }

    @Override
    public String toString() {
        return "FeedEntry{" +
                "id=" + id +
                ", feedEntryDescription=" + feedEntryDescription +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationDate=" + publicationDate +
                ", url='" + url + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }


    public FeedEntryDescription getFeedEntryDescription() {
        return feedEntryDescription;
    }

    public void setFeedEntryDescription(FeedEntryDescription feedEntryDescription) {
        if (feedEntryDescription==null) {
            if (this.feedEntryDescription!=null) {
                this.feedEntryDescription.setFeedEntry(null);
            }
        }
        else {
            feedEntryDescription.setFeedEntry(this);
        }
        this.feedEntryDescription = feedEntryDescription;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

