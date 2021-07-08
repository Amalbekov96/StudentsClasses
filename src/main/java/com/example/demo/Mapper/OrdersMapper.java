package com.example.demo.Mapper;

import com.example.demo.Dto.OrdersDto;
import com.example.demo.Dto.StudentsDto;
import com.example.demo.Model.Orders;
import com.example.demo.Model.Students;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface OrdersMapper {

    OrdersMapper INSTANCE = Mappers.getMapper(OrdersMapper.class);

    Orders toOrders(OrdersDto orderDto);
    OrdersDto toOrdersDto(Orders order);
    List<Orders> toOrderList(List<OrdersDto> orderDtoList);
    List<OrdersDto> toOrderDtoList(List<Orders> orderList);
    Students toStudents(StudentsDto studentDto);
}
