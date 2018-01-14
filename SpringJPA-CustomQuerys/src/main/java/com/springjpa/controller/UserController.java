package com.springjpa.controller;


import com.springjpa.Services.UserService;
import com.springjpa.model.User;
import com.springjpa.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Jimmy Ismael Pena on 2/26/2017.
 */
@Controller
public class UserController {

    /*@Autowired
    UserRepository userRepository;*/

    @Autowired
    UserService userService;

    @GetMapping("/SaveUser")
    public String customerForm(Model model) {
        model.addAttribute("user", new User());
        return "SaveUser";
    }

    @PostMapping("/SaveUser")
    public String customerSubmit(@ModelAttribute User user) {
        System.out.println(user);
        userService.saveUser(user);
        return "SaveUser";
    }

    @GetMapping("ShowUsers")
    public String showAllUsers(Model model) {
        model.addAttribute("user", userService.listAllUsers());
        return "ShowUsers";
    }

    @GetMapping("ByFirstName")
    public String getUsersByFirstName(Model model, @RequestParam("userName") String userName) {
        System.out.println(userName);
        model.addAttribute("user", userService.getUsersByFirstName(userName));

        return "ShowUsers";
    }

    @GetMapping("ByLastName")
    public String getUsersByLastName(Model model, @RequestParam("userLastName") String userLastName) {
        System.out.println(userLastName);
        model.addAttribute("user", userService.getUsersByLastName(userLastName));

        return "ShowUsers";
    }
}
