package programmer.personal.feedadapter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "feedadapter")
@Data
public class SpringBootConfig {
    private static String fixedDelay;
    private String url;
    private int newsnum;

    public static String getFixedDelay() {
        return fixedDelay;
    }

    public static void setFixedDelay(String fixedDelay) {
        SpringBootConfig.fixedDelay = fixedDelay;
    }

    public String getUrl() {
        return url;
    }

    public SpringBootConfig setUrl(String url) {
        this.url = url;
        return this;
    }

    public int getNewsnum() {
        return newsnum;
    }

    public void setNewsnum(int newsnum) {
        this.newsnum = newsnum;
    }
}
