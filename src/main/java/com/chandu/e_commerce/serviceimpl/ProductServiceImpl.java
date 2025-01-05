package com.chandu.e_commerce.serviceimpl;

import com.chandu.e_commerce.exception.ProductNotFoundException;
import com.chandu.e_commerce.mapper.ProductMapper;
import com.chandu.e_commerce.model.Product;
import com.chandu.e_commerce.responsedto.JSONResponseDTO;
import com.chandu.e_commerce.requestdto.ProductRequestDTO;
import com.chandu.e_commerce.repository.ProductRepository;
import com.chandu.e_commerce.responsedto.ProductResponseDTO;
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

        ProductResponseDTO responseDTO=productMapper.convertToResponse(savedProduct);

        return new ResponseEntity<>(new JSONResponseDTO(true,"Product saved successfully", List.of(responseDTO)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<JSONResponseDTO> findAllProducts()
    {
        List<Product> products=productRepository.findAll();
        List<ProductResponseDTO> responseDTOS=products.stream().map(p->new ProductResponseDTO(p.getProductId(),p.getProductName(),p.getProductDescription(),p.getProductPrice(),p.getProductImage(),p.getProductQuantity(),p.getProductRating(),p.getProductDiscount())).toList();
        return new ResponseEntity<>(new JSONResponseDTO(true,"All products fetched",responseDTOS),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<JSONResponseDTO> getProductById(Long id)
    {
        Product product=productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("Product Not Found"));
        ProductResponseDTO responseDTO=productMapper.convertToResponse(product);
        return new ResponseEntity<>(new JSONResponseDTO(true,"Product Fetched successfully",List.of(responseDTO)),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<JSONResponseDTO> updateProduct(Long id, ProductRequestDTO requestDTO)
    {
        Product product=productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("Product not found"));
        Product updatedProduct=productMapper.mapToUpdatedProduct(product);

        Product savedProduct=productRepository.save(updatedProduct);

        ProductResponseDTO responseDTO=productMapper.convertToResponse(savedProduct);
        return new ResponseEntity<>(new JSONResponseDTO(true,"Product updated successfully",List.of(responseDTO)),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<JSONResponseDTO> deleteProduct(Long id)
    {
        Product product=productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("Product not found"));
        productRepository.delete(product);
        return new ResponseEntity<>(new JSONResponseDTO(true,"Product deleted successfully",null),HttpStatus.OK);
    }
}
