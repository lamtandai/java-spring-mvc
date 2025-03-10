package vn.hoidanit.laptopshop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="pro_detail")
public class Pro_detail extends BaseEntity{
    
    @MapsId
    @OneToOne
    private Product product;
    
    private String pro_detail_desc;
    public String getPro_detail_desc() {
        return pro_detail_desc;
    }
    public void setPro_detail_desc(String pro_detail_desc) {
        this.pro_detail_desc = pro_detail_desc;
    }
    private String pro_short_desc;
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public String getPro_short_desc() {
        return pro_short_desc;
    }
    public void setPro_short_desc(String pro_short_desc) {
        this.pro_short_desc = pro_short_desc;
    }
    @Override
    public String toString() {
        return "Pro_detail [product=" + product + ", pro_detail_desc=" + pro_detail_desc + ", pro_short_desc="
                + pro_short_desc + "]";
    }
}
