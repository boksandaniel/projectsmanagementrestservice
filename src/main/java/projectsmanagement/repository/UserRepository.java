package projectsmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectsmanagement.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long>
{
    Optional<UserEntity> findOneByUserName(String userName);
    Optional<UserEntity> findOneByEmail(String email);
}
