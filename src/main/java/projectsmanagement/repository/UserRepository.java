package projectsmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectsmanagement.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, String>
{
}
