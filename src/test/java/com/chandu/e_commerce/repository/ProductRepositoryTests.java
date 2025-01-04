package com.chandu.e_commerce.repository;

import com.chandu.e_commerce.model.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
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
        Assertions.assertThat(savedProduct).isNotNull();
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

        Assertions.assertThat(products.size()).isEqualTo(2);
    }

    @Test
    public void ProductRepository_FindById_ReturnSavedProduct()
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
        productRepository.save(product);
        Product rs=productRepository.findById(product.getProductId()).get();

        //Assert
        Assertions.assertThat(rs).isNotNull();
    }

    //Custom Query Testing
    @Test
    public void ProductRepository_FindByCategoryId_ReturnAllSavedProducts()
    {
        Product product1=Product.builder()
                .productName("Laptop")
                .productPrice(899.36)
                .productDescription("Used for Coding")
                .productImage("---")
                .productQuantity(78)
                .productRating(4.5)
                .productId(1)
                .categoryId(1)
                .build();

        Product product2=Product.builder()
                .productId(2)
                .categoryId(1)
                .productName("Mouse")
                .productPrice(8199.36)
                .productDescription("Used for Pointing")
                .productImage("---")
                .productQuantity(78)
                .productRating(4.5)
                .build();

        Product product3=Product.builder()
                .productId(4)
                .categoryId(2)
                .productName("Mouse")
                .productPrice(8199.36)
                .productDescription("Used for Pointing")
                .productImage("---")
                .productQuantity(78)
                .productRating(4.5)
                .build();

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        List<Product> products=productRepository.findByCategoryId(2);

        Assertions.assertThat(products.size()).isEqualTo(1);
    }

    @Test
    public void ProductRepository_UpdateProduct_ReturnSavedProduct()
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
        productRepository.save(product);
        Product rs=productRepository.findById(product.getProductId()).get();

        rs.setProductImage("Url");
        rs.setProductDescription("Laptop for sale");
        rs.setProductDiscount(78);

        Product updatedProduct=productRepository.save(rs);

        //Assert
        Assertions.assertThat(updatedProduct.getProductDiscount()).isEqualTo(78);
        Assertions.assertThat(updatedProduct.getProductName()).isNotNull();
    }

    @Test
    public void ProductRepository_DeleteProduct_ReturnProductNotNull()
    {
        //Arrange
        Product product=Product.builder()
                .productName("Laptop")
                .productPrice(899.36)
                .productDescription("Used for Coding")
                .productImage("---")
                .productId(2)
                .productQuantity(78)
                .productRating(4.5)
                .build();

        //Act
        productRepository.save(product);

        productRepository.deleteById(product.getProductId());

        Optional<Product> result=productRepository.findById(product.getProductId());
        //Assert
        Assertions.assertThat(result).isEmpty();
    }
}
