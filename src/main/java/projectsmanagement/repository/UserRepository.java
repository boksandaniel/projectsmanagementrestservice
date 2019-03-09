package projectsmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectsmanagement.entity.User;


public interface UserRepository extends JpaRepository<User, String>
{
    User findByEmail(String email);

}
