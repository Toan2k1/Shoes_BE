package com.example.shoebe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "`product`")
@Data
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String categoryName;
    private String image;
    private String size;
    private String price;
    private String description;
    private String quantity;
    private String color;
    private boolean isDelete;

    @JsonIgnore
    @ManyToOne
    private category category;

    public product() {
    }



    public product(String name,String categoryName, String size, String price, String color, String description, String quantity, category category) {
        this.name = name;
        this.categoryName = categoryName;
        this.size = size;
        this.price = price;
        this.category = category;
        this.color = color;
        this.description = description;
        this.quantity = quantity;
    }
}
