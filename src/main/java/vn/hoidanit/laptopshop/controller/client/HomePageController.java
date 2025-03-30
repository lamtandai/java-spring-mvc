package vn.hoidanit.laptopshop.controller.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import vn.hoidanit.laptopshop.domain.Cart;
import vn.hoidanit.laptopshop.domain.CartDetail;
import vn.hoidanit.laptopshop.domain.CartDetailId;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.domain.dto.CartItem;
import vn.hoidanit.laptopshop.domain.dto.ConsigneeDTO;
import vn.hoidanit.laptopshop.domain.dto.PurchaseRequestDTO;
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

    @GetMapping(value = "/")
    public String getHomePage(Model model) {
        List<Product> listProduct = this.productService.hanldeListAllPrduct();
        model.addAttribute("listProduct", listProduct);
        return "client/homepage/show";
    }

    @GetMapping(value = "/register")
    public String userRegister(Model model) {
        model.addAttribute("registerUser", new registerDTO());
        return "client/auth/register";
    }

    @PostMapping(value = "/register")
    public String verifyUserRegister(
            @ModelAttribute("registerUser") @Valid registerDTO registerUser,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "client/auth/register";
        }
        User registeredUser = this.userService.registerDTOtoUser(registerUser);
        registeredUser.setPassword(this.passwordEncoder.encode(registeredUser.getPassword()));
        registeredUser.setRole(this.userService.handleGetRoleByName("User"));
        this.userService.handleSaveUser(registeredUser);
        return "redirect:/login";
    }

    @GetMapping(value = "/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginUser", new loginDTO());
        return "client/auth/login";
    }

    @PostMapping(value = "/login")
    public String verifyUserLogin(
            @ModelAttribute("loginUser") @Valid loginDTO loginUser,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "client/auth/login";
        }
        return "redirect:/";
    }

    @GetMapping(value = "/accessDenied")
    public String getDeniedpage() {
        return "client/auth/deny";
    }

    @GetMapping(value = "/add-product-to-cart/{id}")
    public String addProductToCart(Model model, @PathVariable long id, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            User user = userService.handleGetUserById((long) session.getAttribute("id"));
            Product product = this.productService.handleGetProductById(id);
            this.productService.handleAddProductToCart(user, product, session);
        }
        return "redirect:/";
    }

    @GetMapping(value = "/cart")
    public String getCartCheckOut(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        User user = userService.handleGetUserById((long) session.getAttribute("id"));
        Cart cart = user.getCart();

        List<CartDetail> cartDetails = cart == null ? new ArrayList<>() :cart.getCartDetails();

        long totalPrice = 0;
        for (CartDetail elem : cartDetails) {
            totalPrice += elem.getTotalPrice();
        }

        PurchaseRequestDTO purchaseRequestDTO = new PurchaseRequestDTO();
        List <CartItem> items = new ArrayList<>();

        for (CartDetail elem : cartDetails) {
            CartItem item = new CartItem();
            items.add(item);
        }
        purchaseRequestDTO.setCartList(items);

        model.addAttribute("cartDetails", cartDetails);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("purchaseRequestDTO", purchaseRequestDTO );

        return "client/cart/cart";
    }
    
    @PostMapping(value="/delete-cart-product/{cart_id}/{product_id}")
    public String deleteProductInCart(
        @PathVariable long cart_id, 
        @PathVariable long product_id,
        HttpServletRequest request){
        // delete product in cart-detail

        Cart cart = new Cart();
        cart.setId(cart_id);

        Product product = new Product();
        product.setId(product_id);

        CartDetailId cartDetailId = new CartDetailId(cart,product);
        HttpSession session = request.getSession(false);
        int sum = this.productService.handleDeleteProductInCart(cartDetailId);
        session.setAttribute("cartSum", sum);
        
        return "redirect:/cart";
    }

    @PostMapping(value="/purchase-verify")
    public String getPurchaseVerify(
        Model model, 
        @ModelAttribute("purchaseRequestDTO") PurchaseRequestDTO cart,
        HttpServletRequest request
        ){

        HttpSession session = request.getSession();
        User user = userService.handleGetUserById((long) session.getAttribute("id"));
        ConsigneeDTO consignee = new ConsigneeDTO();
        if (cart == null){
            return "redirect:/cart";
        }
        
        this.productService.handleUpdateCartBeforePurchase(cart.getCartList(),user.getCart());
        
        long totalPrice = 0;
        for (CartDetail elem : user.getCart().getCartDetails()) {
            totalPrice += elem.getTotalPrice();
        }
        
        model.addAttribute("cart", user.getCart());
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("user", user);
        model.addAttribute("consignee", consignee);
        return "client/cart/checkout";
    } 
    @PostMapping(value="/order-verify")
    public String getOrderVerify(
        Model model, 
        @ModelAttribute("consignee") ConsigneeDTO consignee,
        HttpServletRequest request
        ){

        HttpSession session = request.getSession();
        User currentUser = new User();
        currentUser.setId((long) session.getAttribute("id"));
        this.productService.handleVerifyOrder(currentUser, session, consignee);
       
        return "redirect:/";
    } 
}
