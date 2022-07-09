package myApp.Controller;

import myApp.Service.UserService;
import myApp.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/")
    public String saveUser(@ModelAttribute("newUser") User newUser) {
        userService.create(newUser);
        return "redirect:/";
    }

    @GetMapping("/")
    public String getAllUsers(Model model) {
        List<User> list = userService.readAll();
        model.addAttribute("users", list);
        System.out.println(list);
        return "users";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable(name = "id") long id,
                          Model model) {
        model.addAttribute("user", userService.read(id));
        return "update";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("updateUser") User updateUser,
                             @PathVariable(name = "id") long id) {
        updateUser.setId(id);
        System.out.println(updateUser);
        userService.update(updateUser);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") long id) {
        userService.delete(id);
        return "redirect:/";
    }
}
