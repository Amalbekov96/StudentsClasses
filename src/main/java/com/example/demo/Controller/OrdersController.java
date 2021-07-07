package com.example.demo.Controller;

import com.example.demo.Dto.OrdersDto;
import com.example.demo.Mapper.OrdersMapper;
import com.example.demo.Model.Orders;
import com.example.demo.Service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("orders")
public class OrdersController {

    private OrdersService ordersService;
    private OrdersMapper ordersMapper;

    public OrdersController(OrdersService ordersService, OrdersMapper ordersMapper) {
        this.ordersService = ordersService;
        this.ordersMapper = ordersMapper;
    }

    @PostMapping("/sendRequest")
    public String creat(@RequestBody OrdersDto orderDto){
        return ordersService.requestOrder(orderDto);
    }

    @PostMapping("processesRequest")
    public String process(@RequestBody OrdersDto orderDto)
    {
        return ordersService.processRequest(orderDto);
    }

}
