package com.chandu.e_commerce.responsedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDTO
{
    private long productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private String productImage;
    private int productQuantity;
    private double productRating;
    private int productDiscount;
}
