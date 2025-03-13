package vn.hoidanit.laptopshop.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.hoidanit.laptopshop.domain.Role;


@Repository
public interface RoleRepo extends JpaRepository<Role, Long>{
    Role findByroleName(String name);
}
