package vn.hoidanit.laptopshop.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "users")
public class User extends BaseEntity{
    
    @NotEmpty()
    @Pattern(regexp="^[a-zA-Z0-9 ]{1,}$", message = "Name Field must be at least 10 characters long, no special character, and number is allowed")
    @Size(min = 10, message = "Name Field must be at least 10 characters long, no special character, and number is allowed")
    private String fullName; 

    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    
    private String email;
    
    @Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$",
             message="Password must contain at least 8 characters, including one lowercase letter, one uppercase letter, one number, and one special character")
    private String password; 

    private String address; 

    @Pattern(regexp="^0\\d{9}$", message = "Phone number must be 10 digits starting with 0")
    private String phone;

    private String avatar;

    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;

    @OneToMany(mappedBy= "user")
    private List<Order> orders;

    public String getFullName() {
        return fullName;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }
    @Override
    public String toString() {
        return "User [id=" + getId() + ", fullName=" + fullName + ", email=" + email + ", password=" + password
                + ", address=" + address + ", phone=" + phone + ", avatar=" + avatar + ", getFormattedCreatedAt()="
                + getFormattedCreatedAt() + ", getFormattedUpdatedAt()=" + getFormattedUpdatedAt() + "]";
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public List<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    


}
