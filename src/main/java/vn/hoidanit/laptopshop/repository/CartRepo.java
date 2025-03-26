package vn.hoidanit.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.hoidanit.laptopshop.domain.Cart;
import vn.hoidanit.laptopshop.domain.User;

public interface CartRepo extends JpaRepository<Cart, Long>{
    Cart findByUser(User user);
    Cart save(Cart cart);
}
