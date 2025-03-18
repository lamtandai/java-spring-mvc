package vn.hoidanit.laptopshop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @NotEmpty()
    @Pattern(regexp="^[a-zA-Z ]{1,}$", message = "ProductName must be at least 10 characters long, no special character, and number is allowed")
    @Size(min = 1, message = "ProductName must be at least 10 characters long, no special character, and number is allowed")
    private String proName;
    

    @Min(value = 0, message="PriceValue must be non-negative")
    private double price;

    private String image;

    @Min(value = 0, message="QuantityValue must be non-negative")
    private long quantity;

    private long sold;

    private String manufactor;

    private String target;

    @Column(columnDefinition="MEDIUMTEXT")
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
