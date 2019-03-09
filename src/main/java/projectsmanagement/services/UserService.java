package projectsmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import projectsmanagement.entity.Role;
import projectsmanagement.entity.User;
import projectsmanagement.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public void createUser(User user)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = new Role("USER");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setUserRoles(roles);
        userRepository.save(user);
    }

    public void createAdmin(User user)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = new Role("ADMIN");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setUserRoles(roles);
        userRepository.save(user);
    }

    public User findOne(String email)
    {
        return userRepository.findByEmail(email);
    }
}
