package com.chandu.e_commerce.requestdto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO
{
    private long id;
    private String productName;
    private String productDescription;
    private double productPrice;
    private String productImage;
    private int productQuantity;
    private double productRating;
    private int productDiscount;
    private int categoryId;
    private int brandId;
}
