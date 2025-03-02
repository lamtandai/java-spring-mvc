package vn.hoidanit.laptopshop.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.hoidanit.laptopshop.service.UserService;


@Controller
public class UserController {
    final private UserService userService;
    
    public UserController(UserService userService) {
         this.userService = userService;
    }
    
    @RequestMapping("/")
    public String getHomePage(){
        String test = this.userService.handleHelloWord();
        return "hello";
    }
}
// @RestController
// public class UserController {
//     final private UserService userService;
    
//     public UserController(UserService userService) {
//         this.userService = userService;
//     }

//     @GetMapping("/")
//     public String getHomePage (){
//         return this.userService.handleHelloWord();
//     }
//     int [] arr1 = {1,2,3}; 
//     int []arr2 = new int[6];
    
// }
