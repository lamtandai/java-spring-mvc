package vn.hoidanit.laptopshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.hoidanit.laptopshop.domain.Cart;
import vn.hoidanit.laptopshop.domain.User;

public interface CartRepo extends JpaRepository<Cart, Long>{
    Cart findByUser(User user);
    Optional findById(Long id);
    Cart save(Cart cart);
}
