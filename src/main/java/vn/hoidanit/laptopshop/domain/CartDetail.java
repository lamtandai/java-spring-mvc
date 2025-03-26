package vn.hoidanit.laptopshop.domain;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_details")
@EntityListeners(AuditingEntityListener.class) 
public class CartDetail {
    
    @EmbeddedId
    private CartDetailId cartDetailId;
    
    private float price;

    private int quantity;
    
    @CreationTimestamp
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private Instant createdAt;

    @CreationTimestamp
    @LastModifiedDate
    @Column(nullable = false)
    private Instant updatedAt;

    // Getters
    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
    public String getFormattedCreatedAt() {
        return formatDateTime(createdAt);
    }

    public String getFormattedUpdatedAt() {
        return formatDateTime(updatedAt);
    }

    private String formatDateTime(Instant instant) {
        if (instant == null) return "N/A";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                                                       .withZone(ZoneId.systemDefault());
        return formatter.format(instant);
    }
    
    public CartDetailId getCartDetailId() {
        return cartDetailId;
    }

    public void setCartDetailId(CartDetailId cartDetailId) {
        this.cartDetailId = cartDetailId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public float getTotalPrice(){
        return price * quantity;
    }
}
