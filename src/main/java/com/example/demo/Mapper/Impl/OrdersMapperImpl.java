package com.example.demo.Mapper.Impl;

import com.example.demo.Dto.OrdersDto;
import com.example.demo.Mapper.OrdersMapper;
import com.example.demo.Model.Orders;

public class OrdersMapperImpl implements OrdersMapper {
    @Override
    public Orders toOrders(OrdersDto orderDto) {
        Orders order = new Orders();
        order.setId(orderDto.getId());
        order.setComment(orderDto.getComment());
        order.setAddDate(orderDto.getAddDate());
        order.setNavidate(orderDto.getNavidate());
        order.setEndDate(orderDto.getEndDate());
        order.setSchoolAddress(orderDto.getSchoolAddress());
        order.setSchoolName(orderDto.getSchoolName());
        order.setStatus(orderDto.getStatus());
        order.setStudent(orderDto.getStudent());
        return order;
    }

    @Override
    public OrdersDto toOrdersDto(Orders order) {
        OrdersDto orderDto = new OrdersDto();
        orderDto.setId(order.getId());
        orderDto.setComment(order.getComment());
        orderDto.setAddDate(order.getAddDate());
        orderDto.setNavidate(order.getNavidate());
        orderDto.setEndDate(order.getEndDate());
        orderDto.setSchoolAddress(order.getSchoolAddress());
        orderDto.setSchoolName(order.getSchoolName());
        orderDto.setStatus(order.getStatus());
        orderDto.setStudent(order.getStudent());
        return orderDto;
    }
}
