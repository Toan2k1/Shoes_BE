package com.example.shoebe.repository;

import com.example.shoebe.model.category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface categoryRepository extends JpaRepository<category,Long> {
    List<category> findByIsDelete(boolean deleteStatus);

}
