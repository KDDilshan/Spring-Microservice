package com.kavindu.order.services;

import com.kavindu.order.dtos.orderDto;
import com.kavindu.order.entities.order;
import com.kavindu.order.repositories.orderRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class orderService {
    @Autowired
    public orderRepo orderRepo;

    @Autowired
    public ModelMapper modelMapper;

    public List<orderDto> getOrders() {
        List<order> orders=orderRepo.findAll();
        return modelMapper.map(orders,new TypeToken<List<orderDto>>(){}.getType());
    }
    public orderDto getOrderById(int id) {
        order order=orderRepo.findById(id).get();
        return modelMapper.map(order,orderDto.class);
    }

    public orderDto CreateOrder(orderDto orderDto) {
         orderRepo.save(modelMapper.map(orderDto,order.class));
         return orderDto;

    }

    public orderDto UpdateOrder(orderDto orderDto) {
        orderRepo.save(modelMapper.map(orderDto,order.class));
        return orderDto;
    }
     public String DeleteOrder(int id) {
        orderRepo.deleteById(id);
        return "Order deleted";
     }

}
