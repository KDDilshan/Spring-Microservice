package com.kavindu.product.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class product {
    @Id
    private int id;
    private int productId;
    private String productName;
    private String description;
    private int forSale;


}
