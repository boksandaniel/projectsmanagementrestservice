package projectsmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectsmanagement.entity.TaskEntity;
import projectsmanagement.entity.UserEntity;
import projectsmanagement.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService
{
    @Autowired
    private TaskRepository taskRepository;

    public void addTask(TaskEntity taskEntity, UserEntity userEntity)
    {
        taskEntity.setUserEntity(userEntity);
        taskRepository.save(taskEntity);
    }

    public List<TaskEntity> findUserTask(UserEntity userEntity)
    {
        return taskRepository.findByUser(userEntity);
    }
}
