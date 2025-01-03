package com.chandu.e_commerce.repository;

import com.chandu.e_commerce.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoryForSort extends PagingAndSortingRepository<Product,Integer>
{

}
