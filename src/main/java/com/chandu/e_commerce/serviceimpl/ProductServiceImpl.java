package com.chandu.e_commerce.serviceimpl;

import com.chandu.e_commerce.mapper.ProductMapper;
import com.chandu.e_commerce.model.Product;
import com.chandu.e_commerce.responsedto.JSONResponseDTO;
import com.chandu.e_commerce.requestdto.ProductRequestDTO;
import com.chandu.e_commerce.repository.ProductRepository;
import com.chandu.e_commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService
{
    @Autowired
    private ProductRepository productRepository;

    private final ProductMapper productMapper=new ProductMapper();

    @Override
    public ResponseEntity<JSONResponseDTO> addProduct(ProductRequestDTO productRequestDTO)
    {
        Product product=productMapper.convertIntoProduct(productRequestDTO);

        Product savedProduct=productRepository.save(product);

        return new ResponseEntity<>(new JSONResponseDTO(true,"Product saved successfully", List.of(savedProduct)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<JSONResponseDTO> findAllProducts()
    {
        List<Product> products=productRepository.findAll();
        return new ResponseEntity<>(new JSONResponseDTO(true,"All products fetched",products),HttpStatus.OK);
    }
}
