package vn.hoidanit.laptopshop.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.hoidanit.laptopshop.domain.CartDetail;
import vn.hoidanit.laptopshop.domain.CartDetailId;

public interface CartDetailRepo extends JpaRepository<CartDetail, CartDetailId>{
    CartDetail save(CartDetail cd);
    Optional findById(CartDetailId cartDetailId);
    void deleteById(CartDetailId cartDetailId);
    List <CartDetail> findAllByOrderByUpdatedAtDesc();
}
