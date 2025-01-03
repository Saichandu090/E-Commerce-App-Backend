package com.chandu.e_commerce.serviceimpl;

import com.chandu.e_commerce.responsedto.JSONResponseDTO;
import com.chandu.e_commerce.requestdto.ProductRequestDTO;
import com.chandu.e_commerce.repository.ProductRepository;
import com.chandu.e_commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService
{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<JSONResponseDTO> addProduct(ProductRequestDTO productRequestDTO)
    {
        return new ResponseEntity<>(new JSONResponseDTO(), HttpStatus.BAD_REQUEST);
    }
}
