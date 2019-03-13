package projectsmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectsmanagement.entity.Role;

public interface RoleRepository extends JpaRepository<Role, String>
{
}
