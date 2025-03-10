package vn.hoidanit.laptopshop.controller.admin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UploadService;
import vn.hoidanit.laptopshop.service.UserService;

@Controller
public class UserController {

    final private UserService userService;
    final private UploadService uploadService;

    public UserController(UserService userService, UploadService uploadService) {
        this.userService = userService;
        this.uploadService = uploadService;
    }

// homepage
    @RequestMapping("/")
    public String getHomePage(Model model) {
        String test = this.userService.handleHelloWord();
        model.addAttribute("model1", test);
        return "hello";
    }

// Get admin's dashboard
    @RequestMapping("/admin/user")
    @SuppressWarnings("empty-statement")
    public String listUser(Model model) {
        List<User> listUser = this.userService.handleGetUserSortedByCreated();
        model.addAttribute("listUser", listUser);
        return "admin/user/show";
    }

// Create user 
    @RequestMapping(value = "/admin/user/create")
    public String createUser(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

// Save user that have just created
    @PostMapping(value = "/admin/user/create")
    public String saveUser(
        @ModelAttribute("newUser") User newUser, 
        @RequestParam("avatarFile") MultipartFile file) throws IOException {
        
        String userAvatar = this.uploadService.handleSaveUploadFile(file, "avatar");
        // this.userService.handleSaveUser(newUser);
        return "redirect:/admin/user/create";
    }

// Get user by Id
    @GetMapping(value = "/admin/user/view/{id}")
    public String getUserPage(Model model, @PathVariable long id) {
        User user = this.userService.handleGetUserById(id);
        model.addAttribute("user", user);
        return "admin/user/detail";
    }
// Get user whose information is gonna be modified
    @GetMapping(value = "/admin/user/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        User user = this.userService.handleGetUserById(id);
        model.addAttribute("user", user);
        return "admin/user/update";
    }

//Save user have just modified
    @PostMapping(value = "/admin/user/update/{id}")
    public String updateUser(@ModelAttribute("user") User updatedUser) {
        User currentUser = this.userService.handleGetUserById(updatedUser.getId());
        currentUser.setAddress(updatedUser.getAddress());
        currentUser.setFullName(updatedUser.getFullName());
        currentUser.setPhone(updatedUser.getPhone());
        this.userService.handleSaveUser(currentUser);
        return "redirect:/admin/user/view/{id}";
    }

// Delete user by Id
    @GetMapping(value = "/admin/user/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        this.userService.handleDeleteById(id);
        return "redirect:/admin/user";
    }
}
