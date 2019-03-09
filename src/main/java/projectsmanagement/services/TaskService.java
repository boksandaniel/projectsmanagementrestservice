package projectsmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectsmanagement.entity.Task;
import projectsmanagement.entity.User;
import projectsmanagement.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService
{
    @Autowired
    private TaskRepository taskRepository;

    public void addTask(Task task, User userEntity)
    {
        task.setUser(userEntity);
        taskRepository.save(task);
    }

    public List<Task> findUserTask(User userEntity)
    {
        return taskRepository.findByUser(userEntity);
    }
}
