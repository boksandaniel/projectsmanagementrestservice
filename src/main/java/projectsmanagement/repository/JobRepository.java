package projectsmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectsmanagement.entity.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity, Long>
{
    JobEntity findOneJobByTitle(String jobTitle);
}
