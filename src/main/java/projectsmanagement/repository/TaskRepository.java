package projectsmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectsmanagement.entity.Task;
import projectsmanagement.entity.User;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long>
{

    List<Task> findByUser(User user);
}
