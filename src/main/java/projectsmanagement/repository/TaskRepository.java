package projectsmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectsmanagement.entity.TaskEntity;
import projectsmanagement.entity.UserEntity;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntity, Long>
{

    List<TaskEntity> findByUser(UserEntity userEntity);
}
