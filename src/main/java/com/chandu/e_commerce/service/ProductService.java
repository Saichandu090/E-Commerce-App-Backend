package com.chandu.e_commerce.service;

import com.chandu.e_commerce.responsedto.JSONResponseDTO;
import com.chandu.e_commerce.requestdto.ProductRequestDTO;
import org.springframework.http.ResponseEntity;

public interface ProductService
{
    JSONResponseDTO addProduct(ProductRequestDTO productRequestDTO);

    JSONResponseDTO findAllProducts();

    JSONResponseDTO getProductById(Long id);

    JSONResponseDTO updateProduct(Long id,ProductRequestDTO requestDTO);

    JSONResponseDTO deleteProduct(Long id);
}
