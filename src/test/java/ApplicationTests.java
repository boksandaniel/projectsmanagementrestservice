import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import projectsmanagement.entity.TaskEntity;
import projectsmanagement.entity.UserEntity;
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
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @Before
    public void test()
    {
        {
            UserEntity userEntity = new UserEntity("test@user.com", "testUser", "123445");
            userService.createUser(userEntity);
        }

        {
            UserEntity userEntity = new UserEntity("test@admin.com", "testAdminr", "123445");
            userService.createAdmin(userEntity);

        }

        TaskEntity userTask = new TaskEntity("11/03/03", new SimpleDateFormat("MM-dd-yyyy"), new SimpleDateFormat("MM-dd-yyyy"), "work");
        UserEntity user = userService.findOne("user@sdadasda");
        taskService.addTask(userTask, user);
    }

    @Test
    public void testIfUserExists() throws Exception
    {
        UserEntity userEntity = userService.findOne("test@user.com");
        assertNotNull(userEntity);
        UserEntity adminEntity = userService.findOne("test@admin.com");
        assertEquals(adminEntity.getEmail(),"test@admin.com");
    }

    @Test
    public  void testIfTaskExists() throws  Exception
    {
        UserEntity userEntity = userService.findOne("user@sdadasda");
        List<TaskEntity> taskEntity = taskService.findUserTask(userEntity);
        assertNotNull(taskEntity);
    }
}
