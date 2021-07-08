package com.example.demo.Service;

import com.example.demo.Dto.OrdersDto;
import com.example.demo.Model.Orders;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrdersService {

    Orders findStuden(Long id);
    Orders create(Orders oreder);
    List<Orders> getAll();
    void delete(Long id);
    Orders update(Orders order);
    ResponseEntity<String> requestOrder(OrdersDto orderDto);
    ResponseEntity<String> processRequest(OrdersDto orderDto);
    ResponseEntity<String> decideOnRequest(OrdersDto orderDto);
}
