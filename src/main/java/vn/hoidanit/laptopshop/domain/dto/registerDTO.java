package vn.hoidanit.laptopshop.domain.dto;

import vn.hoidanit.laptopshop.service.RegisterChecked;
import vn.hoidanit.laptopshop.service.StrongPassword;

@RegisterChecked
public class registerDTO {
    private String firstName;
    private String lastName;
    private String email;
    @StrongPassword
    private String password;
    private String confirmPassword;
    private String phone;
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
