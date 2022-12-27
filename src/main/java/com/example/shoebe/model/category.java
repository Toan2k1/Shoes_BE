package com.example.shoebe.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "`category`")
@Data
public class category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean isDelete;

    @JsonManagedReference
    @OneToMany(mappedBy = "category")
    private List<product> products;

    public category() {
    }

    public category(String name) {
        this.name = name;
    }
}
