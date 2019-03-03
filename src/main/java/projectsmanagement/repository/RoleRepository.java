package projectsmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectsmanagement.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, String>
{
}
