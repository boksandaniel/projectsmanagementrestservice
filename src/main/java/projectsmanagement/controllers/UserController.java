package projectsmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projectsmanagement.entity.User;
import projectsmanagement.repository.UserRepository;
import projectsmanagement.services.UserService;


@Controller
public class UserController
{
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String userList(Model model, @SortDefault("name") @RequestParam(defaultValue = "") String name)
    {
        model.addAttribute("users", userService.findByName(name));
        return "views/userList";
    }

    @RequestMapping("users/delete{email}")
    public String deleteUser(@RequestParam("email") String email)
    {
        userRepository.delete(userRepository.findOneByEmail(email));
        return "redirect:/users";
    }
}
