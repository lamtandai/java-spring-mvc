package vn.hoidanit.laptopshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.hoidanit.laptopshop.domain.Product;


public interface ProductRepo extends JpaRepository<Product, Long>{
    Product findById(long id);

    @SuppressWarnings({ "null", "unchecked" })
    @Override
    Product save(Product newProduct);
    void deleteById(long Id);
    List<Product> findAllByOrderByCreatedAtDesc();
}
