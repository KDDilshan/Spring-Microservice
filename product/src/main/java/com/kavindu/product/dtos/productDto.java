package com.kavindu.product.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class productDto {
    private int id;
    private int productId;
    private String productName;
    private String description;
    private int    forSale;
}
