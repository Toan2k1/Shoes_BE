package com.example.shoebe.repository;

import com.example.shoebe.model.User;
import com.example.shoebe.model.cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<cart,Long> {
    List<cart> findByUser(User user);
}
