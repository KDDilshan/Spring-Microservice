package com.kavindu.order.services;

import com.kavindu.inventory.dtos.inventoryDto;
import com.kavindu.order.common.ErrorOrderResponse;
import com.kavindu.order.common.SuccessOrderResponse;
import com.kavindu.order.common.orderResponse;
import com.kavindu.order.dtos.orderDto;
import com.kavindu.order.entities.order;
import com.kavindu.order.repositories.orderRepo;
import com.kavindu.product.dtos.productDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;

@Service
public class orderService {
    @Autowired
    public orderRepo orderRepo;

    @Autowired
    public ModelMapper modelMapper;

    private final WebClient productWebClient;

    private final WebClient inventoryWebClient;

    public orderService(WebClient inventoryWebClient,WebClient productWebClient, ModelMapper modelMapper, orderRepo orderRepo) {
        this.productWebClient = productWebClient;
        this.inventoryWebClient = inventoryWebClient;
        this.modelMapper = modelMapper;
        this.orderRepo = orderRepo;
    }

    public List<orderDto> getOrders() {
        List<order> orders=orderRepo.findAll();
        return modelMapper.map(orders,new TypeToken<List<orderDto>>(){}.getType());
    }
    public orderDto getOrderById(int id) {
        order order=orderRepo.findById(id).get();

        return modelMapper.map(order,orderDto.class);
    }

    public orderResponse CreateOrder(orderDto orderDto) {

        Integer itemId=orderDto.getItemId();
        try {
            inventoryDto inventoryResponse=inventoryWebClient.get()
                                        .uri(uriBuilder -> uriBuilder.path("/item/{itemId}").build(itemId))
                                        .retrieve()
                                        .bodyToMono(inventoryDto.class)
                                        .block();
            assert inventoryResponse != null;

            Integer productId=inventoryResponse.getProductId();

            productDto productResponse=productWebClient.get()
                            .uri(uriBuilder -> uriBuilder.path("/getone/{id}").build(productId))
                            .retrieve()
                            .bodyToMono(productDto.class)
                            .block();

            assert productResponse != null;

            if(inventoryResponse.getQuantity()>0){
                if(productResponse.getForSale()==1){
                    orderRepo.save(modelMapper.map(orderDto,order.class));
                }
                else {
                    return new ErrorOrderResponse("product not for sale! Please try Later");
                }

                return new SuccessOrderResponse(orderDto);
            }
            else {
                return new ErrorOrderResponse("item not Awilable Please try Later");
            }
        }
        catch (WebClientResponseException e) {
            if(e.getStatusCode().is5xxServerError()){
                return new ErrorOrderResponse("item not found !");
            }

            e.printStackTrace();
        }
        return null;
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
