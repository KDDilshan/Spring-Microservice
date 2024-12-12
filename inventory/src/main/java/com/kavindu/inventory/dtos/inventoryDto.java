package com.kavindu.inventory.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class inventoryDto {
    private int id;
    private int itemId;
    private int productId;
    private int quantity;
}
