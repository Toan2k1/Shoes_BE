package com.example.shoebe.repository;

import com.example.shoebe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
    public interface UserRepository extends JpaRepository<User, Long> {
        User findByUsername(String username);
        User findById(String id);
    public User findByMobile(String mobile);


    List<User> findByIsDelete(boolean deleteStatus);

}

