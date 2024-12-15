package com.kavindu.inventory.repositories;

import com.kavindu.inventory.entites.inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface inventoryRepo extends JpaRepository<inventory, Integer> {

    inventory findByItemId(int itemId);

}
