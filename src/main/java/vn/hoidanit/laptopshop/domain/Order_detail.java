package vn.hoidanit.laptopshop.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="order_detail")
public class Order_detail extends BaseEntity{

    private long quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name= "pro_id")
    private Product product;

    @Override
    public String toString() {
        return "Order_detail [quantity=" + quantity + ", price=" + price + ", order=" + order + ", product=" + product
                + ", getFormattedCreatedAt()=" + getFormattedCreatedAt() + ", getFormattedUpdatedAt()="
                + getFormattedUpdatedAt() + "]";
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
}
