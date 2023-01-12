package com.example.shoebe.repository;
import com.example.shoebe.model.ImageModel;
import com.example.shoebe.model.product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StorageRepository extends JpaRepository<ImageModel,Long> {
    List<ImageModel> findByIsDelete(boolean deleteStatus);

}
