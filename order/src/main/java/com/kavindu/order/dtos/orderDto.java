package com.kavindu.order.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class orderDto {
    private int id;
    private int itemId;
    private String orderDate;
    private int amount;
}
