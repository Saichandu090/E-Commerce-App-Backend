package com.chandu.e_commerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product
{
    @Id
    private long productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private String productImage;
    private int productQuantity;
    private double productRating;
    private int productDiscount;
    private int categoryId;
    private int brandId;

    @OneToMany
    private List<Cart> carts;
}
