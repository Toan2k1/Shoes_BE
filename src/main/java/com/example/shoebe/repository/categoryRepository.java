package com.example.shoebe.repository;

import com.example.shoebe.model.category;
import com.example.shoebe.model.product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface categoryRepository extends JpaRepository<category,Long> {
    List<category> findByIsDelete(boolean deleteStatus);
    Optional<category> findByName(String name);

}
