package vn.hoidanit.laptopshop.domain;

import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id; 
    private String fullName; 
    private String email; 
    private String password; 
    private String address; 
    private String phone;
    
    @Override
    public String toString() {
        return "User [id=" + id + ", fullName=" + fullName + ", email=" + email + ", password=" + password
                + ", address=" + address + ", phone=" + phone + "]";
    }
    public long getId() {
        return id;
    }
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
    public void setId(long id) {
        this.id = id;
    } 

    


}
