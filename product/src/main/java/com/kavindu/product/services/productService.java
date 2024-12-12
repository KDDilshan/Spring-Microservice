package com.kavindu.product.services;

import com.kavindu.product.dtos.productDto;
import com.kavindu.product.entities.product;
import com.kavindu.product.respositories.productRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productService {
    @Autowired
    public productRepo productRepo;

    @Autowired
    public ModelMapper  modelMapper;


    public List<productDto> getAllproducts() {
        List<product> products = productRepo.findAll();
        return modelMapper.map(products,new TypeToken<List<productDto>>(){}.getType());
    }

    public productDto getProductById(int id) {
        product product =productRepo.findById(id).get();
        return modelMapper.map(product,productDto.class);
    }

    public productDto CreateProdcut(productDto productDto) {
        productRepo.save(modelMapper.map(productDto,product.class));
        return productDto;
    }

    public productDto UpdateProdcut(productDto productDto) {
        productRepo.save(modelMapper.map(productDto,product.class));
        return productDto;
    }

    public String DeleteProdcut(int id) {
        productRepo.deleteById(id);
        return "Product deleted";
    }
}
