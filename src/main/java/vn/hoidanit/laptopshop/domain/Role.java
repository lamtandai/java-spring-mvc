package vn.hoidanit.laptopshop.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;
    private String role_name;

    @OneToMany(mappedBy = "role")
    private List<User> user;

    public int getRole_id() {
        return id;
    }

    public void setRole_id(short role_id) {
        this.id = role_id;
    }

    public String getRole_string() {
        return role_name;
    }

    public void setrole_name(String role_name) {
        this.role_name = role_name;
    }

    @Override
    public String toString() {
        return "Role [role_id=" + id + ", role_name=" + role_name + ", getFormattedCreatedAt()="
                + getFormattedCreatedAt() + ", getFormattedUpdatedAt()=" + getFormattedUpdatedAt() + "]";
    }

}
