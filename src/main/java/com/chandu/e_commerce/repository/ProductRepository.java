package com.chandu.e_commerce.repository;

import com.chandu.e_commerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>
{
    List<Product> findByCategoryId(int categoryId);

    Optional<Product> findById(Long id);
}
