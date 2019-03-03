package projectsmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectsmanagement.entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Long>
{

}
