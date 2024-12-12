package com.kavindu.product.controllers;

import com.kavindu.product.dtos.productDto;
import com.kavindu.product.services.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/product/")
public class productContoller {

    @Autowired
    public productService productService;

    @GetMapping("/getAll")
    public List<productDto> getProducts(){
        return productService.getAllproducts();
    }

    @GetMapping("/getone/{id}")
    public productDto getProduct(@PathVariable int id){
        return productService.getProductById(id);
    }

    @PostMapping("/create")
    public productDto createProduct(@RequestBody productDto product){
        return productService.CreateProdcut(product);
    }

    @PutMapping("/update")
    public productDto updateProduct(@RequestBody productDto product){
        return productService.UpdateProdcut(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return productService.DeleteProdcut(id);
    }


    
}
