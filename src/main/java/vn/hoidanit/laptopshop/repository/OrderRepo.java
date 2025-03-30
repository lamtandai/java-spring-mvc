package vn.hoidanit.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.hoidanit.laptopshop.domain.Order;
@Repository
public interface OrderRepo extends  JpaRepository<Order, Long>{
    Order save(Order order);
}
