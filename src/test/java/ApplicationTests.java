import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import projectsmanagement.entity.Task;
import projectsmanagement.entity.User;
import projectsmanagement.services.TaskService;
import projectsmanagement.services.UserService;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.List;

@SpringBootTest
public class ApplicationTests
{
    @Autowired
    UserService userService;

    @Autowired
    TaskService taskService;

    @Before
    public void test()
    {
        {
            User user = new User("test@user.com", "testUser", "123456");
            userService.createUser(user);
        }

        {
            User admin = new User("test@admin.com", "testAdmin", "123456");
            userService.createAdmin(admin);

        }

        Task userTask = new Task("11/03/03", new SimpleDateFormat("MM-dd-yyyy"), new SimpleDateFormat("MM-dd-yyyy"), "work");
        User user = userService.findOne("test@user.com");
        taskService.addTask(userTask, user);
    }

    @Test
    public void testIfUserExists() throws Exception
    {
        User user = userService.findOne("test@user.com");
        assertNotNull(user);
        User adminEntity = userService.findOne("test@admin.com");
        assertEquals(adminEntity.getEmail(),"test@admin.com");
    }

    @Test
    public  void testIfTaskExists() throws  Exception
    {
        User userEntity = userService.findOne("user@sdadasda");
        List<Task> task = taskService.findUserTask(userEntity);
        assertNotNull(task);
    }
}
