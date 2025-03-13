package vn.hoidanit.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.repository.ProductRepo;
@Service
public class ProductService {
    private final ProductRepo productRepo;
    public ProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    public Product handleGetProductById(long id){
        return this.productRepo.findById(id);
    }

    public Product handelSaveNewProduct(Product newProduct){
        return this.productRepo.save(newProduct);
    }

    public List<Product> hanldeListAllPrduct(){
        return this.productRepo.findAllByOrderByCreatedAtDesc();
    }

    public void handleDeleteById(long id){
        this.productRepo.deleteById(id);
    }
}
