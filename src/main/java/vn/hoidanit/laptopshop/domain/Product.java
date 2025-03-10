package vn.hoidanit.laptopshop.domain;

import jakarta.persistence.Entity;

import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    private String pro_name;
    private double price;
    private String image;
    
    private long quantity;
    private long sold;
    private String manufactor;
    private String target;

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getSold() {
        return sold;
    }

    public void setSold(long sold) {
        this.sold = sold;
    }

    public String getManufactor() {
        return manufactor;
    }

    public void setManufactor(String manufactor) {
        this.manufactor = manufactor;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "Product [id=" + getId() + ", pro_name=" + pro_name + ", price=" + price + ", image=" + image
                +", quantity=" + quantity + ", sold=" + sold + ", manufactor=" + manufactor + ", target=" + target
                + ", getFormattedCreatedAt()=" + getFormattedCreatedAt() + ", getFormattedUpdatedAt()="
                + getFormattedUpdatedAt() + "]";
    }

}
