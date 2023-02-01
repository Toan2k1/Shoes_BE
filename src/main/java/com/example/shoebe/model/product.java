package com.example.shoebe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "`product`")
@Data
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String categoryName;
    private String avatar;
    private String size;
    private double price;
    @Column(length = 5000)
    private String description;
    private int quantity;
    private String color;
    private boolean isDelete;
    @JsonManagedReference
    @OneToMany(mappedBy = "product")
    private List<ImageModel> image;
    @JsonIgnore
    @ManyToOne
    private category category;

    public product() {
    }


    public product(String categoryName, String name, String color, String size, double price, String description, String avatar, int quantity, com.example.shoebe.model.category category) {
        this.name = name;
        this.categoryName = categoryName;
        this.size = size;
        this.price = price;
        this.category = category;
        this.color = color;
        this.description = description;
        this.quantity = quantity;
        this.avatar=avatar;
    }
}
