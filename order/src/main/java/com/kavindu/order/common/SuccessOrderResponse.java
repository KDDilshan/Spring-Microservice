package com.kavindu.order.common;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.kavindu.order.dtos.orderDto;
import lombok.Getter;

@Getter
public class SuccessOrderResponse implements orderResponse{
    @JsonUnwrapped
    private final orderDto order;

    public SuccessOrderResponse(orderDto order) {
        this.order = order;
    }


}
