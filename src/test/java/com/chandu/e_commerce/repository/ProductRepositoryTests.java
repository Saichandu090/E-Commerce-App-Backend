package com.chandu.e_commerce.repository;

import com.chandu.e_commerce.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryTests
{
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void ProductRepository_SaveAll_ReturnSavedProduct()
    {
        //Arrange
        Product product=Product.builder()
                .productName("Laptop")
                .productPrice(899.36)
                .productDescription("Used for Coding")
                .productImage("---")
                .productQuantity(78)
                .productRating(4.5)
                .build();

        //Act
        Product savedProduct=productRepository.save(product);

        //Assert
        assertNotNull(savedProduct);
    }

    @Test
    public void ProductRepository_FindAll_ReturnAllSavedProducts()
    {
        Product product1=Product.builder()
                .productName("Laptop")
                .productPrice(899.36)
                .productDescription("Used for Coding")
                .productImage("---")
                .productQuantity(78)
                .productRating(4.5)
                .productId(1)
                .build();

        Product product2=Product.builder()
                .productId(2)
                .productName("Mouse")
                .productPrice(8199.36)
                .productDescription("Used for Pointing")
                .productImage("---")
                .productQuantity(78)
                .productRating(4.5)
                .build();

        productRepository.save(product1);
        productRepository.save(product2);

        List<Product> products=productRepository.findAll();

        assertEquals(2,products.size());
    }
}
