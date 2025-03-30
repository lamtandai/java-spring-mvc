package vn.hoidanit.laptopshop.domain.dto;

public class CartItem {
    private long cart_id;
    private long product_id;
    private int quantity;

    public Long getCartId() {
        return cart_id;
    }
    public void setCartId(long cartId) {
        this.cart_id = cartId;
    }
    public long getProductId() {
        return product_id;
    }
    public void setProductId(long productId) {
        this.product_id = productId;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
