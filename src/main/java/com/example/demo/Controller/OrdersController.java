package com.example.demo.Controller;

import com.example.demo.Dto.OrdersDto;
import com.example.demo.Mapper.OrdersMapper;
import com.example.demo.Model.Orders;
import com.example.demo.Service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrdersMapper ordersMapper;

    @PostMapping
    public OrdersDto creat(OrdersDto orderDto){
        return ordersMapper.toOrdersDto(ordersService.create(ordersMapper.toOrders(orderDto)));
    }

}
