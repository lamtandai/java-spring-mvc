package vn.hoidanit.laptopshop.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    private String roleName;
    private String description;
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = "role")
    private List<User> user;


    public String getRole_string() {
        return roleName;
    }

    public void setrole_name(String role_name) {
        this.roleName = role_name;
    }

    @Override
    public String toString() {
        return "Role [role_id=" + getId() + ", role_name=" + roleName + ", getFormattedCreatedAt()="
                + getFormattedCreatedAt() + ", getFormattedUpdatedAt()=" + getFormattedUpdatedAt() + "]";
    }

    public String getRole_name() {
        return roleName;
    }

    public void setRole_name(String role_name) {
        this.roleName = role_name;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

}
