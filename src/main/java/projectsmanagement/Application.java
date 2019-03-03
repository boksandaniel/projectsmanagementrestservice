package projectsmanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class Application  implements CommandLineRunner
{

    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception
    {
    }
}