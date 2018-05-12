
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author lucas
 */
@SpringBootApplication(scanBasePackages = {"lab"})
@EnableJpaRepositories(basePackages = {"lab"})
@EntityScan(basePackages = {"lab"})
public class StarterApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(StarterApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(StarterApplication.class, args);
    }
}
