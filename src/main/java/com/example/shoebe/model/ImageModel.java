package com.example.shoebe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name="image_model")
@Data
@AllArgsConstructor
@Builder

public class ImageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;
    private boolean isDelete;
    private String productName;

    @Lob
    @Type(type = "org.hibernate.type.ImageType")
    private byte[] imageData;
    @JsonIgnore
    @ManyToOne
    private product product;

    public ImageModel() {
    }


    public ImageModel(String productName, com.example.shoebe.model.product product) {
        this.product = product;
        this.productName = productName;
    }


}
