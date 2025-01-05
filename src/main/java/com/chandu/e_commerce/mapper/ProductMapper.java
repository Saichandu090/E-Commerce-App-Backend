package com.chandu.e_commerce.mapper;

import com.chandu.e_commerce.model.Product;
import com.chandu.e_commerce.requestdto.ProductRequestDTO;
import com.chandu.e_commerce.responsedto.ProductResponseDTO;

public class ProductMapper
{
    public Product convertIntoProduct(ProductRequestDTO productRequestDTO)
    {
        Product product=new Product();
        product.setProductId(productRequestDTO.getId());
        product.setProductName(productRequestDTO.getProductName());
        product.setBrandId(productRequestDTO.getBrandId());
        product.setCategoryId(productRequestDTO.getCategoryId());
        product.setProductDiscount(productRequestDTO.getProductDiscount());
        product.setProductDescription(productRequestDTO.getProductDescription());
        product.setProductQuantity(productRequestDTO.getProductQuantity());
        product.setProductPrice(productRequestDTO.getProductPrice());
        product.setProductRating(productRequestDTO.getProductRating());
        product.setProductImage(productRequestDTO.getProductImage());
        return product;
    }

    public ProductResponseDTO convertToResponse(Product savedProduct)
    {
        return ProductResponseDTO.builder()
                .productId(savedProduct.getProductId())
                .productName(savedProduct.getProductName())
                .productRating(savedProduct.getProductRating())
                .productImage(savedProduct.getProductImage())
                .productQuantity(savedProduct.getProductQuantity())
                .productDiscount(savedProduct.getProductDiscount())
                .productDescription(savedProduct.getProductDescription())
                .productPrice(savedProduct.getProductPrice()).build();
    }

    public Product mapToUpdatedProduct(Product product)
    {
        return Product.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .productDescription(product.getProductDescription())
                .productImage(product.getProductImage())
                .productPrice(product.getProductPrice())
                .productQuantity(product.getProductQuantity())
                .productRating(product.getProductRating())
                .productDiscount(product.getProductDiscount())
                .categoryId(product.getCategoryId())
                .brandId(product.getBrandId())
                .build();
    }
}
