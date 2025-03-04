package vn.hoidanit.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping("/admin/user")
    public String createUser(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/createUser";
    }

    @RequestMapping(value = "/admin/user/createUser1", method = RequestMethod.POST)
    public String getUser(Model model, @ModelAttribute("newUser") User newUser) {
        this.userService.handleSaveUser(newUser);
        return "hello";
    }
    @RequestMapping("/admin")
    public String getAllUser(Model model) {
        List <User> list_user = this.userService.handleGetUserByEmail("mukhanh123@gmail.com");
        System.out.println(list_user);
        return "hello";
    }

}
// @RestController
// public class UserController {
// final private UserService userService;

// public UserController(UserService userService) {
// this.userService = userService;
// }

// @GetMapping("/")
// public String getHomePage (){
// return this.userService.handleHelloWord();
// }
// int [] arr1 = {1,2,3};
// int []arr2 = new int[6];

// }
