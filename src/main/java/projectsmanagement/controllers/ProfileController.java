package projectsmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import projectsmanagement.entity.User;
import projectsmanagement.services.TaskService;
import projectsmanagement.services.UserService;

import java.security.Principal;

@Controller
public class ProfileController
{
    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @GetMapping("/profile")
    public String showProfile(Model model, Principal principal)
    {
        String email = principal.getName();
        User user = userService.findOne(email);

        model.addAttribute("tasks", taskService.findUserTask(user));

        return "views/userProfile";
    }
}
