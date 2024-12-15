package com.kavindu.order.controllers;

import com.kavindu.order.common.orderResponse;
import com.kavindu.order.dtos.orderDto;
import com.kavindu.order.services.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/order/")
public class orderContoller {
    @Autowired
    public orderService orderService;

    @GetMapping("/getAll")
    public List<orderDto> getAllOrders(){
        return orderService.getOrders();
    }

    @GetMapping("/getone/{id}")
    public orderDto getOrderById(@PathVariable int id){
        return orderService.getOrderById(id);
    }

    @PostMapping("/create")
    public orderResponse createOrder(@RequestBody orderDto orderDto){
        return  orderService.CreateOrder(orderDto);
    }

    @PutMapping("/update")
    public orderDto updateOrder(@RequestBody orderDto orderDto){
        return  orderService.UpdateOrder(orderDto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable int id){
        return orderService.DeleteOrder(id);
    }





}
