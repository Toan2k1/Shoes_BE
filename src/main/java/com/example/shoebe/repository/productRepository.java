package com.example.shoebe.repository;

import com.example.shoebe.model.category;
import com.example.shoebe.model.product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface productRepository extends JpaRepository<product,Long> {
    List<product> findByIsDelete(boolean deleteStatus);

    Optional<product> findByName(String name);


}
