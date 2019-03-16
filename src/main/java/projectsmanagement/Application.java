package projectsmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import projectsmanagement.entity.User;
import projectsmanagement.services.UserService;


@SpringBootApplication
public class Application implements  CommandLineRunner
{
    @Autowired
    private UserService userService;

    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }

    public void run(String... args) throws Exception
    {
        User newAdmin = new User("admin@mail.com", "Admin", "123456");
        userService.createAdmin(newAdmin);
    }

}
