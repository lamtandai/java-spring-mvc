package vn.hoidanit.laptopshop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.service.ProductService;


@Controller
public class ProductClientController {

   final private ProductService productService; 

    public ProductClientController(ProductService productService){
        this.productService = productService ;
    }

    @GetMapping(value = "/product/detail/{id}")
    public String getProuctDetail(Model model, @PathVariable long id) {
        Product product = this.productService.handleGetProductById(id);
        model.addAttribute("product", product);
        return "client/product/detail";
    }
}
