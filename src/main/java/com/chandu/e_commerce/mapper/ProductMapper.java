package com.chandu.e_commerce.mapper;

import com.chandu.e_commerce.model.Product;
import com.chandu.e_commerce.requestdto.ProductRequestDTO;

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
}
