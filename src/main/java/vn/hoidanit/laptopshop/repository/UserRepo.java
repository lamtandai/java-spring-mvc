package vn.hoidanit.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.hoidanit.laptopshop.domain.User;
import java.util.List;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @SuppressWarnings({ "null", "unchecked" })
    @Override
    User save(User newUser);
    List<User> findByEmail(String email);
}
