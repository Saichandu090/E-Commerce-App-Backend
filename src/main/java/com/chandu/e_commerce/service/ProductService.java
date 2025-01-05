package com.chandu.e_commerce.service;

import com.chandu.e_commerce.responsedto.JSONResponseDTO;
import com.chandu.e_commerce.requestdto.ProductRequestDTO;
import org.springframework.http.ResponseEntity;

public interface ProductService
{
    ResponseEntity<JSONResponseDTO> addProduct(ProductRequestDTO productRequestDTO);

    ResponseEntity<JSONResponseDTO> findAllProducts();

    ResponseEntity<JSONResponseDTO> getProductById(Long id);

    ResponseEntity<JSONResponseDTO> updateProduct(Long id,ProductRequestDTO requestDTO);

    ResponseEntity<JSONResponseDTO> deleteProduct(Long id);
}
