package projectsmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectsmanagement.entity.ProjectEntity;

public interface ProjectRepository extends JpaRepository<ProjectRepository, Long>
{
    ProjectEntity findProjectById(Long id);
}
