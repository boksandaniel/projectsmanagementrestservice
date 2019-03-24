package projectsmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectsmanagement.entity.User;

import java.util.List;


public interface UserRepository extends JpaRepository<User, String>
{
    List<User> findByNameLike(String name);

    User findOneByEmail(String email);
}
