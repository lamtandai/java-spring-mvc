package vn.hoidanit.laptopshop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    private String proName;
    private double price;
    private String image;
    
    private long quantity;
    private long sold;
    private String manufactor;
    private String target;

    private String detailDesc;
    private String shortDesc;

    public String getDetailDesc(){
        return this.detailDesc;
    }
    public String getShortDesc(){
        return this.shortDesc;
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
        return "Product [id=" + getId() + ", pro_name=" + proName + ", price=" + price + ", image=" + image
                +", quantity=" + quantity + ", sold=" + sold + ", manufactor=" + manufactor + ", target=" + target
                + ", getFormattedCreatedAt()=" + getFormattedCreatedAt() + ", getFormattedUpdatedAt()="
                + getFormattedUpdatedAt() + "]";
    }
    public String getProName() {
        return proName;
    }
    public void setProName(String proName) {
        this.proName = proName;
    }
    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
    }
    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

}
