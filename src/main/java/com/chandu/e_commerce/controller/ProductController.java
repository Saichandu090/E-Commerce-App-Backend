package com.chandu.e_commerce.controller;

import com.chandu.e_commerce.responsedto.JSONResponseDTO;
import com.chandu.e_commerce.requestdto.ProductRequestDTO;
import com.chandu.e_commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController
{
    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<JSONResponseDTO> addProduct(@RequestBody ProductRequestDTO productRequestDTO)
    {
        return productService.addProduct(productRequestDTO);
    }
}
