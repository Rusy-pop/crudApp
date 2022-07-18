package myApp.controller;

import myApp.service.UserService;
import myApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("/")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String saveUser(@ModelAttribute("newUser") User newUser) {
        userService.createUser(newUser);
        return "redirect:/";
    }

    @GetMapping
    public String getAllUsers(Model model) {
        List<User> list = userService.readAllUsers();
        model.addAttribute("users", list);
        System.out.println(list);
        return "users";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable(name = "id") long id,
                          Model model) {
        model.addAttribute("user", userService.readUserById(id));
        return "update";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("updateUser") User updateUser,
                             @PathVariable(name = "id") long id) {
        updateUser.setId(id);
        System.out.println(updateUser);
        userService.updateUser(updateUser);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable(name = "id") long id) {
        User user = userService.readUserById(id);
        userService.deleteUserById(id);
        return "redirect:/";
    }
}
