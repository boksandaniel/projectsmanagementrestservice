package projectsmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan
public class Application
        implements CommandLineRunner
{
    private final static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args)
    {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        SpringApplication.exit(context);
    }

    @Override
    public void run(String... args) throws Exception
    {
        logger.info("Application started successfuly.");
    }
}
