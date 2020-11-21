package programmer.personal.feedadapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.yml")
public class FeedAdapterApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeedAdapterApplication.class, args);
	}

}
