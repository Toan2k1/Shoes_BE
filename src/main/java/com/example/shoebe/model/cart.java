package com.example.shoebe.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    @OneToOne
    private product product;
    private int quantity;
    private double totalPrice;
    @OneToOne
    private User user;


    public cart(product product, User user) {
        this.product = product;
        this.user = user;
    }

    public cart() {

    }
}
