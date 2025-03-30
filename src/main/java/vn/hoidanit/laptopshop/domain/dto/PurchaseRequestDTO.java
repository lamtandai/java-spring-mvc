package vn.hoidanit.laptopshop.domain.dto;

import java.util.List;

public class PurchaseRequestDTO {
    List <CartItem> cartList;

    public List<CartItem> getCartList() {
        return cartList;
    }

    public void setCartList(List<CartItem> cartList) {
        this.cartList = cartList;
    }
    
}
