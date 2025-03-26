package vn.hoidanit.laptopshop.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class CartDetailId implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // Default constructor required for JPA
    public CartDetailId() {}

    public CartDetailId(Cart cart, Product product) {
        this.cart = cart;
        this.product = product;
    }

    // Getters, setters, hashCode, equals
    @Override
    public int hashCode() {
        return Objects.hash(cart, product);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CartDetailId other = (CartDetailId) obj;
        return Objects.equals(cart, other.cart) && Objects.equals(product, other.product);
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
