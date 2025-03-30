package vn.hoidanit.laptopshop.domain;

import java.util.List;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import vn.hoidanit.laptopshop.domain.dto.ConsigneeDTO;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @Embedded
    private ConsigneeDTO consignee;

    private double total_price;
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> order_details;

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public double getTotal_price() {
        return total_price;
    }

    @Override
    public String toString() {
        return "Order [id=" + getId() + ", total_price=" + total_price + ", getFormattedCreatedAt()="
                + getFormattedCreatedAt() + ", getFormattedUpdatedAt()=" + getFormattedUpdatedAt() + "]";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderDetail> getOrder_details() {
        return order_details;
    }

    public void setOrder_details(List<OrderDetail> order_details) {
        this.order_details = order_details;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ConsigneeDTO getConsignee() {
        return consignee;
    }

    public void setConsignee(ConsigneeDTO consignee) {
        this.consignee = consignee;
    }

    // user_id

}
