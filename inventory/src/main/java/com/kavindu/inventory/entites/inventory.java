package com.kavindu.inventory.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class inventory {
    @Id
    private int id;

    private int itemId;
    private int productId;
    private int quantity;
}
