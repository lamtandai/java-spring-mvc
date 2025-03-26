package vn.hoidanit.laptopshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.hoidanit.laptopshop.domain.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @SuppressWarnings({ "null", "unchecked" })
    @Override
    
    User save(User newUser);
    User findByEmail(String email);
    List<User> findAllByOrderByCreatedAtDesc();
    void deleteById(long Id);
    User findById(long id);
    boolean existsByEmail(String email);
}
