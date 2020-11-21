package programmer.personal.feedadapter.model;

import javax.persistence.*;

@Entity
@Table(name = "feedentrydescriptions")
public class FeedEntryDescription {
    @Id
    @Column(name = "feedEntry_id")
//    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String value;

    private String type;
    private String mode;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    @JoinColumn(name = "feedEntry_id",
            nullable = false, updatable = false)
    private FeedEntry feedEntry;



    public FeedEntryDescription() {
    }

    public FeedEntryDescription(String value, String type, String mode, FeedEntry feedEntry) {
        this.value = value;
        this.type = type;
        this.mode = mode;
        this.feedEntry = feedEntry;
    }

    public Long getId() {
        return id;
    }

    public FeedEntryDescription setId(Long id) {    // added FeedEntryDescription instead of void
        this.id = id;
        return this;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public FeedEntry getFeedEntry() {
        return feedEntry;
    }

    public FeedEntryDescription setFeedEntry(FeedEntry feedEntry) {
        this.feedEntry = feedEntry;
        return this;
    }
}
