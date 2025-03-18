package vn.hoidanit.laptopshop.controller.admin;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.service.ProductService;
import vn.hoidanit.laptopshop.service.UploadService;

@Controller
public class ProductController {
    final private UploadService uploadService;
    final private ProductService productService;

    public ProductController(UploadService uploadService, ProductService productService) {
        this.uploadService = uploadService;
        this.productService = productService;
    }

    @RequestMapping("/admin/product")
    public String getAllProduct(Model model) {
        List<Product> listProduct = this.productService.hanldeListAllPrduct();
        model.addAttribute("listProduct", listProduct);
        return "admin/product/show";
    }

    @GetMapping(value = "/admin/product/create")
    public String createNewProduct(Model model) {
        model.addAttribute("newProduct", new Product());
        return "admin/product/create";
    }

    @PostMapping(value = "/admin/product/create")
    public String saveNewProduct(
            @ModelAttribute("newProduct")@Valid Product newProduct,
            BindingResult bindingResult,
            @RequestParam("laptopImage") MultipartFile file) throws IOException {
        if (bindingResult.hasErrors()) {
            return "/admin/product/create";
        }
        List<FieldError> errors = bindingResult.getFieldErrors();
        for (FieldError error : errors) {
            System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
        }

        newProduct.setImage(this.uploadService.handleSaveUploadFile(file, "product"));
        this.productService.handelSaveNewProduct(newProduct);
        return "redirect:/admin/product/create";
    }

    @GetMapping("/admin/product/update/{id}")
    public String getUpdateProductPage(Model model, @PathVariable long id) {
        Product product = this.productService.handleGetProductById(id);
        model.addAttribute("product", product);
        return "/admin/product/update";
    }

    @GetMapping("/admin/product/view/{id}")
    public String viewProductPage(Model model, @PathVariable long id) {
        Product product = this.productService.handleGetProductById(id);
        model.addAttribute("product", product);
        return "/admin/product/detail";
    }

    @PostMapping("/admin/product/update/{id}")
    public String saveUpdatedProduct(
            @ModelAttribute("product")@Valid Product product,
            BindingResult bindingResult,
            @RequestParam("laptopImage") MultipartFile file) throws IOException {

        if (bindingResult.hasErrors()) {
            return "/admin/product/update/{id}";
        }

        Product currentProduct = this.productService.handleGetProductById(product.getId());
        currentProduct.setProName(product.getProName());
        currentProduct.setManufactor(product.getManufactor());
        currentProduct.setDetailDesc(product.getDetailDesc());
        currentProduct.setShortDesc(product.getShortDesc());
        currentProduct.setPrice(product.getPrice());
        currentProduct.setQuantity(product.getQuantity());
        currentProduct.setTarget(product.getTarget());
        if (!file.isEmpty()) {
            currentProduct.setImage(this.uploadService.handleSaveUploadFile(file, "product"));
        }
        this.productService.handelSaveNewProduct(currentProduct);
        return "redirect:/admin/product/view/{id}";
    }

    @GetMapping(value = "/admin/product/delete/{id}")
    public String deleteUProduct(@PathVariable long id) {
        this.productService.handleDeleteById(id);
        return "redirect:/admin/product";
    }
}
