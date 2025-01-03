package com.chandu.e_commerce.controller;

import com.chandu.e_commerce.repository.ProductRepository;
import com.chandu.e_commerce.requestdto.ProductRequestDTO;
import com.chandu.e_commerce.service.ProductService;
import com.chandu.e_commerce.serviceimpl.ProductServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(controllers = ProductController.class)
class ProductControllerTest
{
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ProductService productService;

    @Test
    public void addProductTest() throws Exception
    {
        ProductRequestDTO requestDTO=new ProductRequestDTO(1);
        String reqBody=objectMapper.writeValueAsString(requestDTO);

        mockMvc.perform(post("/api/v1/product/addProduct")
                .contentType(MediaType.APPLICATION_JSON)
                .content(reqBody))
                .andExpect(status().isUnauthorized());
    }
}