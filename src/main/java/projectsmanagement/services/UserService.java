package projectsmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import projectsmanagement.entity.RoleEntity;
import projectsmanagement.entity.UserEntity;
import projectsmanagement.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public void createUser(UserEntity user)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        RoleEntity userRole = new RoleEntity("USER");
        List<RoleEntity> roles = new ArrayList<>();
        roles.add(userRole);
        user.setUserRoles(roles);
        userRepository.save(user);
    }

    public void createAdmin(UserEntity user)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        RoleEntity userRole = new RoleEntity("ADMIN");
        List<RoleEntity> roles = new ArrayList<>();
        roles.add(userRole);
        user.setUserRoles(roles);
        userRepository.save(user);
    }

    public UserEntity findOne(String email)
    {
        return userRepository.findOne(email);
    }
}
