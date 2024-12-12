package com.kavindu.inventory.contollers;

import com.kavindu.inventory.dtos.inventoryDto;
import com.kavindu.inventory.services.inventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/inventory/")
public class inventoryContoller {

    @Autowired
    public inventoryService inventoryService;

    @GetMapping("/iproducts")
    public List<inventoryDto> getAllInventory(){
        return inventoryService.getAlInventoryProducts();
    }

    @GetMapping("/iproduct/{id}")
    public inventoryDto getInventoryById(@PathVariable int id){
        return inventoryService.getoneProduct(id);
    }

    @PostMapping("/create")
    public inventoryDto createInventory(@RequestBody inventoryDto inventoryDto){
        return inventoryService.createProduct(inventoryDto);
    }

    @PutMapping("/update")
    public inventoryDto updateInventory(@RequestBody inventoryDto inventoryDto){
        return inventoryService.updateProduct(inventoryDto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteInventory(@PathVariable Integer id){
        return inventoryService.deleteProduct(id);
    }
}
