package com.example.demo.Service;

import com.example.demo.Dto.OrdersDto;
import com.example.demo.Model.Orders;

import java.util.List;

public interface OrdersService {

    Orders findStuden(Long id);
    Orders create(Orders oreder);
    List<Orders> getAll();
    void delete(Long id);
    Orders update(Orders order);
    String requestOrder(OrdersDto orderDto);
    String processRequest(OrdersDto orderDto);
}
