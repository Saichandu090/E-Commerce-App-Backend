package com.chandu.e_commerce.service;

import com.chandu.e_commerce.model.Product;
import com.chandu.e_commerce.repository.ProductRepository;
import com.chandu.e_commerce.requestdto.ProductRequestDTO;
import com.chandu.e_commerce.responsedto.JSONResponseDTO;
import com.chandu.e_commerce.serviceimpl.ProductServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTests
{
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    public void ProductService_AddProduct_ReturnTheSameProduct()
    {
        ProductRequestDTO requestDTO=ProductRequestDTO.builder()
                .productImage("Laptop")
                .productDiscount(78)
                .productQuantity(748)
                .productPrice(7899)
                .productName("Asus ROG")
                .productDescription("Gaming laptop")
                .productRating(4.5)
                .brandId(5)
                .categoryId(8)
                .id(7894578).build();

        Product product=Product.builder()
                .productImage("Laptop")
                .productDiscount(78)
                .productQuantity(748)
                .productPrice(7899)
                .productName("Asus ROG")
                .productDescription("Gaming laptop")
                .productRating(4.5)
                .brandId(5)
                .categoryId(8)
                .productId(7894578).build();

        when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);

        ResponseEntity<JSONResponseDTO> res=productService.addProduct(requestDTO);

        Assertions.assertThat(res.getStatusCode()).isSameAs(HttpStatus.CREATED);
        Assertions.assertThat(res.getBody().getData()).isNotNull();
    }


    @Test
    public void ProductService_FindAllProducts_ReturnAllProducts()
    {
        List<Product> products= Collections.singletonList(Mockito.mock(Product.class));

        when(productRepository.findAll()).thenReturn(products);

        ResponseEntity<JSONResponseDTO> res=productService.findAllProducts();

        Assertions.assertThat(res.getStatusCode()).isSameAs(HttpStatus.OK);
    }
}