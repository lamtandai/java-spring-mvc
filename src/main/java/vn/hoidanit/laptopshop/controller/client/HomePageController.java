package vn.hoidanit.laptopshop.controller.client;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.domain.dto.loginDTO;
import vn.hoidanit.laptopshop.domain.dto.registerDTO;
import vn.hoidanit.laptopshop.service.ProductService;
import vn.hoidanit.laptopshop.service.UserService;

@Controller
public class HomePageController {

    final private ProductService productService;
    final private UserService userService;
    final private PasswordEncoder passwordEncoder;

    public HomePageController(ProductService productService, UserService userService, PasswordEncoder passwordEncoder) {
        this.productService = productService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping(value="/")
    public String getHomePage(Model model){
        List<Product> listProduct = this.productService.hanldeListAllPrduct();
        model.addAttribute("listProduct", listProduct);
        return "client/homepage/show";
    }

    @GetMapping(value="/register")
    public String userRegister(Model model){
        model.addAttribute("registerUser", new registerDTO());
        return "client/auth/register";
    }

    @PostMapping(value="/register")
    public String verifyUserRegister(
        @ModelAttribute("registerUser")@Valid registerDTO registerUser,
        BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()){
            return "client/auth/register";
        }
        User registeredUser = this.userService.registerDTOtoUser(registerUser);
        registeredUser.setPassword(this.passwordEncoder.encode(registeredUser.getPassword()));
        registeredUser.setRole(this.userService.handleGetRoleByName("User"));
        this.userService.handleSaveUser(registeredUser);
        return "redirect:/login";
    }

    @GetMapping(value="/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginUser", new loginDTO());
        return "client/auth/login";
    }

    @PostMapping(value="/login")
    public String verifyUserLogin(
        @ModelAttribute("loginUser")@Valid loginDTO loginUser,
        BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()){
            return "client/auth/login";
        }
        return "redirect:/";
    }

    @GetMapping(value="/accessDenied")
    public String getDeniedpage(){
        
        return "client/auth/deny";
    }
}
