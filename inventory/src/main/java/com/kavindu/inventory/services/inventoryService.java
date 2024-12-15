package com.kavindu.inventory.services;

import com.kavindu.inventory.dtos.inventoryDto;
import com.kavindu.inventory.entites.inventory;
import com.kavindu.inventory.repositories.inventoryRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class inventoryService {

    @Autowired
    public inventoryRepo inventoryRepo;

    @Autowired
    public ModelMapper modelMapper;


    public List<inventoryDto> getAlInventoryProducts() {
        List<inventory> inventoryList = inventoryRepo.findAll();
        return modelMapper.map(inventoryList, new TypeToken<List<inventoryDto>>(){}.getType());
    }

    public inventoryDto getoneProduct(int id) {
        inventory inventroryProduct= inventoryRepo.findByItemId(id);
        return modelMapper.map(inventroryProduct, new TypeToken<inventoryDto>(){}.getType());
    }

    public inventoryDto createProduct(inventoryDto inventroryProduct) {
      inventoryRepo.save(modelMapper.map(inventroryProduct,inventory.class));
      return inventroryProduct;
    }

    public inventoryDto updateProduct(inventoryDto inventoryDto){
        inventoryRepo.save(modelMapper.map(inventoryDto,inventory.class));
        return inventoryDto;
    }

    public String deleteProduct(int id) {
        inventoryRepo.deleteById(id);
        return "Product in the inventory is deleted";
    }
}
