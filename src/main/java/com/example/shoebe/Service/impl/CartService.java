package com.example.shoebe.Service.impl;

import com.example.shoebe.config.JwtAuthenticationFilter;
import com.example.shoebe.model.User;
import com.example.shoebe.model.cart;
import com.example.shoebe.model.product;
import com.example.shoebe.model.request.cartRequest.addCartRequest;
import com.example.shoebe.repository.CartRepository;
import com.example.shoebe.repository.UserRepository;
import com.example.shoebe.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {


    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private productRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    public cart addToCart(addCartRequest request) {
        product product = productRepository.findById(request.getId()).get();
        String username = JwtAuthenticationFilter.CURRENT_USER;

        User user = null;

        if (username != null) {
            user = userRepository.findByUsername(username);
        }
        if (product != null && user != null) {
            cart cart = new cart();
            cart.setProduct(product);
            cart.setUser(user);
            cart.setQuantity(request.getQuantity());
            cart.setTotalPrice(request.getQuantity() * product.getPrice());
            return cartRepository.save(cart);
        }

        return null;
    }
    public List<cart> getCartDetails() {
        String username = JwtAuthenticationFilter.CURRENT_USER;

        User user = userRepository.findByUsername(username);
        return cartRepository.findByUser(user);
    }

    public boolean deleteCart(long id) {
        if(cartRepository.existsById(id)){
            cartRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
