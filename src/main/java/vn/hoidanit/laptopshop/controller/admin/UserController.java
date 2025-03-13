package vn.hoidanit.laptopshop.controller.admin;
import java.io.IOException;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UploadService;
import vn.hoidanit.laptopshop.service.UserService;

@Controller
public class UserController {

    final private UserService userService;
    final private UploadService uploadService;
    final private PasswordEncoder passwordEncoder;
    
    public UserController(UserService userService, UploadService uploadService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.uploadService = uploadService;
        this.passwordEncoder = passwordEncoder;

    }

// Get admin's all users
    @RequestMapping("/admin/user")
    @SuppressWarnings("empty-statement")
    public String listUser(Model model) {
        List<User> listUser = this.userService.handleGetUserSortedByCreated();
        model.addAttribute("listUser", listUser);
        return "admin/user/show";
    }

// Create user 
    @RequestMapping(value = "/admin/user/create")
    public String createNewUser(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

// Save user that have just created
    @PostMapping(value = "/admin/user/create")
    public String saveNewUser(
        @ModelAttribute("newUser") User newUser, 
        @RequestParam("avatarFile") MultipartFile file) throws IOException{

        // set appropriate fields for new users 
        newUser.setAvatar(this.uploadService.handleSaveUploadFile(file, "avatar"));
        newUser.setPassword(this.passwordEncoder.encode(newUser.getPassword()));
        newUser.setRole(this.userService.handleGetRoleByName(newUser.getRole().getRole_name()));
        // 
        
        this.userService.handleSaveUser(newUser);
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
    public String updateUser(
        @ModelAttribute("user") User updatedUser,
        @RequestParam("avatarFile") MultipartFile file)throws IOException {
        User currentUser = this.userService.handleGetUserById(updatedUser.getId());
        currentUser.setAddress(updatedUser.getAddress());
        currentUser.setFullName(updatedUser.getFullName());

        currentUser.setPhone(updatedUser.getPhone());
        
        if (file != null && !file.isEmpty()) {
            currentUser.setAvatar(this.uploadService.handleSaveUploadFile(file, "avatar"));
        }
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
