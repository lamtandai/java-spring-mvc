package vn.hoidanit.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UserService;

@Controller
public class UserController {

    final private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        String test = this.userService.handleHelloWord();
        model.addAttribute("model1", test);
        return "hello";
    }

    @RequestMapping("/admin")
    public String getAllUser(Model model) {
        List<User> list_user = this.userService.handleGetUserByEmail("mukhanh123@gmail.com");
        System.out.println(list_user);
        return "hello";
        // return file jsp, not url
    }

    @RequestMapping("/admin/user")
    @SuppressWarnings("empty-statement")
    public String listUser(Model model) {
        List<User> listUser = this.userService.handleGetUserSortedByCreated();
        model.addAttribute("listUser", listUser);
        return "admin/user/tableUser";
    }

    @RequestMapping(value = "/admin/user/create")
    public String createUser(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/createUser";
    }

    @PostMapping(value = "/admin/user/create")
    public String saveUser(@ModelAttribute("newUser") User newUser) {
        this.userService.handleSaveUser(newUser);
        return "redirect:/admin/user/create";
    }

    @GetMapping(value = "/admin/user/view/{id}")
    public String getUserPage(Model model, @PathVariable long id) {
        User user = this.userService.handleGetUserById(id);
        model.addAttribute("user", user);
        return "admin/user/userDetail";
    }

    @GetMapping(value = "/admin/user/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        User user = this.userService.handleGetUserById(id);
        model.addAttribute("user", user);
        return "admin/user/updateUser";
    }

    @PostMapping(value = "/admin/user/update/{id}")
    public String updateUser(@ModelAttribute("user") User updatedUser) {
        User currentUser = this.userService.handleGetUserById(updatedUser.getId());
        currentUser.setAddress(updatedUser.getAddress());
        currentUser.setFullName(updatedUser.getFullName());
        currentUser.setPhone(updatedUser.getPhone());
        this.userService.handleSaveUser(currentUser);
        return "redirect:/admin/user/view/{id}";
    }

    @GetMapping(value = "/admin/user/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        this.userService.handleDeleteById(id);
        return "redirect:/admin/user";
    }
}
