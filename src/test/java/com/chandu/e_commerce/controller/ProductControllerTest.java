package com.chandu.e_commerce.controller;

import com.chandu.e_commerce.model.Product;
import com.chandu.e_commerce.requestdto.ProductRequestDTO;
import com.chandu.e_commerce.responsedto.JSONResponseDTO;
import com.chandu.e_commerce.responsedto.ProductResponseDTO;
import com.chandu.e_commerce.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(controllers = ProductController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class ProductControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    private Product product;

    private ProductRequestDTO requestDTO;

    @BeforeEach
    public void init()
    {
        product=Product.builder()
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

        requestDTO=ProductRequestDTO.builder()
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
    }

    @Test
    public void ProductController_AddProduct_ReturnCREATED() throws Exception
    {
        Long id=1L;
        JSONResponseDTO responseDTO=productService.getProductById(id);
        given(productService.addProduct(ArgumentMatchers.any())).willReturn(responseDTO);

        ResultActions response=mockMvc.perform(post("/api/v1/product/addProduct")
                .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding(StandardCharsets.UTF_8.name())
                .content(objectMapper.writeValueAsString(requestDTO)));

        response.andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void ProductController_GetProductById_ReturnProduct() throws Exception
    {
        JSONResponseDTO responseDTO=new JSONResponseDTO(true,"", List.of(new ProductResponseDTO()));
        given(productService.getProductById(ArgumentMatchers.any())).willReturn(responseDTO);

        ResultActions response=mockMvc.perform(get("/api/v1/product/getProduct/1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding(StandardCharsets.UTF_8.name()));

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void ProductController_GetAllProducts_ReturnProducts() throws Exception
    {
        JSONResponseDTO responseDTO=productService.findAllProducts();
        given(productService.findAllProducts()).willReturn(responseDTO);

        ResultActions response=mockMvc.perform(get("/api/v1/product/getAllProducts")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding(StandardCharsets.UTF_8.name()));

        response.andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void ProductController_UpdateProduct_UpdateProduct() throws Exception
    {
        Long id=1L;
        JSONResponseDTO responseDTO=productService.updateProduct(id,requestDTO);
        given(productService.updateProduct(ArgumentMatchers.any(),ArgumentMatchers.any())).willReturn(responseDTO);

        ResultActions response=mockMvc.perform(put("/api/v1/product/updateProduct/1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding(StandardCharsets.UTF_8.name())
                .content(objectMapper.writeValueAsString(requestDTO)));

        response.andExpect(MockMvcResultMatchers.status().isAccepted());
    }

    @Test
    public void ProductController_DeleteProduct_DeleteProduct() throws Exception
    {
        Long id=1L;
        JSONResponseDTO responseDTO=productService.deleteProduct(id);
        given(productService.deleteProduct(ArgumentMatchers.any())).willReturn(responseDTO);

        ResultActions response=mockMvc.perform(delete("/api/v1/product/deleteProduct/1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding(StandardCharsets.UTF_8.name()));

        response.andExpect(MockMvcResultMatchers.status().isAccepted());
    }
}