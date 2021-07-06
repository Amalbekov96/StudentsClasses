package com.example.demo.Mapper;

import com.example.demo.Dto.OrdersDto;
import com.example.demo.Model.Orders;

public interface OrdersMapper {
    Orders toOrders(OrdersDto orderDto);
    OrdersDto toOrdersDto(Orders order);
}
