package projectsmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import projectsmanagement.entity.Role;
import projectsmanagement.entity.User;
import projectsmanagement.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collections;
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
        return userRepository.findOneByEmail(email);
    }

    public boolean isUserPresent(String email)
    {
        User user = userRepository.findOneByEmail(email);
        if(user !=null)
            return true;
        return false;
    }

    public List<User> findByName(String name)
    {
        return userRepository.findByNameLike("%"+name+"%");
    }
}
