package vn.hoidanit.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import vn.hoidanit.laptopshop.domain.Cart;
import vn.hoidanit.laptopshop.domain.CartDetail;
import vn.hoidanit.laptopshop.domain.CartDetailId;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.CartDetailRepo;
import vn.hoidanit.laptopshop.repository.CartRepo;
import vn.hoidanit.laptopshop.repository.ProductRepo;
@Service
public class ProductService {
    private final ProductRepo productRepo;
    private final CartRepo cp;
    private final CartDetailRepo cdp;
    public ProductService(ProductRepo productRepo,CartRepo cp,CartDetailRepo cdp ){
        this.productRepo = productRepo;
        this.cp = cp;
        this.cdp = cdp;
    }

    public Product handleGetProductById(long id){
        return this.productRepo.findById(id);
    }

    public Product handelSaveNewProduct(Product newProduct){
        return this.productRepo.save(newProduct);
    }

    public List<Product> hanldeListAllPrduct(){
        return this.productRepo.findAllByOrderByCreatedAtDesc();
    }

    public void handleDeleteById(long id){
        this.productRepo.deleteById(id);
    }

    public void handleAddProductToCart(User user, Product product, HttpSession session){
        Cart cart = this.cp.findByUser(user);

        if (cart == null){
            Cart newCart = new Cart();
            newCart.setUser(user);
            // save newCart then return to cart
            cart = this.cp.save(newCart);
        }
       
        CartDetailId cdId = new CartDetailId();
        cdId.setCart(cart);
        cdId.setProduct(product);

        Optional<CartDetail> cartDetail = this.handleCheckProductExistsInCart(cdId);
        
        if (cartDetail.isEmpty()){
            CartDetail newCartDetail = new CartDetail();
            newCartDetail.setCartDetailId(cdId);
            newCartDetail.setPrice( (float) product.getPrice());
            newCartDetail.setQuantity(1);
            this.cdp.save(newCartDetail);

            //update cart'sum
            int cartSum = cart.getSum() + 1;
            cart.setSum(cartSum);
            this.cp.save(cart);

            //update session cart's sum
            if (cartSum >= 100){
                cartSum = 99;
            }
            session.setAttribute("cartSum",cartSum);
            return;
        }

        CartDetail cd = cartDetail.get();
        cd.setQuantity(cd.getQuantity() + 1);
        // save cartDetail
        this.cdp.save(cd);
    }

    @SuppressWarnings("unchecked")
    public Optional<CartDetail> handleCheckProductExistsInCart(CartDetailId cartDetailId){
        return this.cdp.findById(cartDetailId);
    }

    public List <CartDetail> handleCartList(){
        return this.cdp.findAllByOrderByUpdatedAtDesc();
    }
}
