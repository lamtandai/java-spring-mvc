package vn.hoidanit.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import vn.hoidanit.laptopshop.domain.Cart;
import vn.hoidanit.laptopshop.domain.CartDetail;
import vn.hoidanit.laptopshop.domain.CartDetailId;
import vn.hoidanit.laptopshop.domain.Order;
import vn.hoidanit.laptopshop.domain.OrderDetail;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.domain.dto.CartItem;
import vn.hoidanit.laptopshop.domain.dto.ConsigneeDTO;
import vn.hoidanit.laptopshop.repository.CartDetailRepo;
import vn.hoidanit.laptopshop.repository.CartRepo;
import vn.hoidanit.laptopshop.repository.OrderDetailRepo;
import vn.hoidanit.laptopshop.repository.OrderRepo;
import vn.hoidanit.laptopshop.repository.ProductRepo;

@Service
public class ProductService {
    private final ProductRepo productRepo;
    private final CartRepo cp;
    private final CartDetailRepo cdp;
    private final OrderRepo orderRepo;
    private final OrderDetailRepo orderDetailRepo;
    public ProductService(ProductRepo productRepo, CartRepo cp, CartDetailRepo cdp, OrderRepo orderRepo, OrderDetailRepo orderDetailRepo) {
        this.productRepo = productRepo;
        this.cp = cp;
        this.cdp = cdp;
        this.orderRepo = orderRepo;
        this.orderDetailRepo = orderDetailRepo;
    }

    public Product handleGetProductById(long id) {
        return this.productRepo.findById(id);
    }

    public Product handelSaveNewProduct(Product newProduct) {
        return this.productRepo.save(newProduct);
    }

    public List<Product> hanldeListAllPrduct() {
        return this.productRepo.findAllByOrderByCreatedAtDesc();
    }

    public void handleDeleteById(long id) {
        this.productRepo.deleteById(id);
    }

    public void handleAddProductToCart(User user, Product product, HttpSession session) {
        Cart cart = this.cp.findByUser(user);

        if (cart == null) {
            Cart newCart = new Cart();
            newCart.setUser(user);
            // save newCart then return to cart
            cart = this.cp.save(newCart);
        }

        CartDetailId cdId = new CartDetailId();
        cdId.setCart(cart);
        cdId.setProduct(product);

        Optional<CartDetail> cartDetail = this.handleCheckProductExistsInCart(cdId);

        if (cartDetail.isEmpty()) {
            CartDetail newCartDetail = new CartDetail();
            newCartDetail.setCartDetailId(cdId);
            newCartDetail.setPrice((float) product.getPrice());
            newCartDetail.setQuantity(1);
            this.cdp.save(newCartDetail);

            // update cart'sum
            int cartSum = cart.getSum() + 1;
            cart.setSum(cartSum);
            this.cp.save(cart);

            // update session cart's sum
            if (cartSum >= 100) {
                cartSum = 99;
            }
            session.setAttribute("cartSum", cartSum);
            return;
        }

        CartDetail cd = cartDetail.get();
        cd.setQuantity(cd.getQuantity() + 1);
        // save cartDetail
        this.cdp.save(cd);
    }

    @SuppressWarnings("unchecked")
    public Optional<CartDetail> handleCheckProductExistsInCart(CartDetailId cartDetailId) {
        return this.cdp.findById(cartDetailId);
    }

    public List<CartDetail> handleShowCart() {
        return this.cdp.findAllByOrderByUpdatedAtDesc();
    }

    public int handleDeleteProductInCart(CartDetailId cartDetailId) {
        this.cdp.deleteById(cartDetailId);

        Optional<Cart> cart = this.cp.findById(cartDetailId.getCart().getId());

        Cart realCart = cart.get();
        int sum = realCart.getSum() - 1;
        realCart.setSum(sum);
        this.cp.save(realCart);

        return sum;

    }

    public Cart handleSaveCart(Cart cart) {
        return this.cp.save(cart);
    }

    public void handleUpdateCartBeforePurchase(List <CartItem> cartDetails, Cart cart){
        
        for (CartItem cartDetail: cartDetails){
            Product product = this.productRepo.findById(cartDetail.getProductId());
            CartDetailId cartDetailId = new CartDetailId(cart, product);

            Optional <CartDetail> cd = this.cdp.findById(cartDetailId);

            CartDetail real_cd = cd.get();
            real_cd.setQuantity(cartDetail.getQuantity());
            
        }
        
    }
    public Cart handleReturnUserCart(User user){
        return this.cp.findByUser(user);
    }

    public void handleVerifyOrder(User user, HttpSession session, ConsigneeDTO consigneeDTO){
        //create order
        Order order = new Order();
        order.setUser(user);
        System.out.println("ConsigneeDTO: " + consigneeDTO.getFullName() + ", " + 
                   consigneeDTO.getAddress() + ", " + consigneeDTO.getPhone());
        order.setConsignee(consigneeDTO);
        order = this.orderRepo.save(order);

        //create orderDetail
        //Step1: take cartDetail from cart
        Cart cart = this.cp.findByUser(user);
        if(cart != null){
            List <CartDetail> cartDetails = cart.getCartDetails();
            if (cartDetails != null){
                for(CartDetail cartDetail : cartDetails){
                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setOrder(order);
                    orderDetail.setProduct(cartDetail.getCartDetailId().getProduct());
                    orderDetail.setQuantity(cartDetail.getQuantity());
                    orderDetail.setPrice(cartDetail.getPrice());
                    this.orderDetailRepo.save(orderDetail);
                }
                // step2: delete cartDetail
                for(CartDetail cartDetail : cartDetails){
                    this.cdp.deleteById(cartDetail.getCartDetailId());
                }
                
                cart.setSum(0);
                System.out.println("=========Print cart information=======");
                System.out.println(cart.getCartDetails());
                for (CartDetail cartDetail : cart.getCartDetails()) {
                    System.out.println(cartDetail.getCartDetailId().getCart().getId());
                    System.out.println(cartDetail.getCartDetailId().getProduct().getId());

                }
                System.out.println("=========Print cart information=======");

                //step3 
                session.setAttribute("sum", 0);
            }
        }
    }
}
