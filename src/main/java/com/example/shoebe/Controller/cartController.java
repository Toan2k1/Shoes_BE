package com.example.shoebe.Controller;

import com.example.shoebe.Service.impl.CartService;
import com.example.shoebe.model.cart;
import com.example.shoebe.model.request.cartRequest.addCartRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Cart")
public class cartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/addToCart")
    public cart addToCart(@RequestBody addCartRequest request) {
        return cartService.addToCart(request);
    }
    @GetMapping("/getCartDetails")
    public List<cart> getCartDetails() {
        return cartService.getCartDetails();
    }
    @DeleteMapping("/deleteCart/{id}")
    Boolean deleteProduct(@PathVariable long id){
        return  cartService.deleteCart(id);
    }
}
