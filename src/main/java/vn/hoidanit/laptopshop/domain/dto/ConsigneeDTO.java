package vn.hoidanit.laptopshop.domain.dto;

import jakarta.persistence.Embeddable;

@Embeddable
public class ConsigneeDTO {

    private String fullName;
    private String address;
    private String phone;
    
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
