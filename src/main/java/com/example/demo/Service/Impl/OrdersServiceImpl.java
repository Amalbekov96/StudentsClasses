package com.example.demo.Service.Impl;

import com.example.demo.Dto.OrdersDto;
import com.example.demo.Dto.StudentsDto;
import com.example.demo.Exception.OrderNotFoundException;
import com.example.demo.Mapper.OrdersMapper;
import com.example.demo.Mapper.StudentsMapper;
import com.example.demo.Model.Enum.OrderStatus;
import com.example.demo.Model.Orders;
import com.example.demo.Model.Students;
import com.example.demo.Repository.OrdersRepo;
import com.example.demo.Repository.StudentsRepo;
import com.example.demo.Service.OrdersService;
import com.example.demo.Service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    private OrdersRepo ordersRepo;
    private StudentsRepo studentsRepo;
    private StudentsService studentsService;
    private OrdersMapper ordersMapper;
    private StudentsMapper studentsMapper;

    public OrdersServiceImpl(OrdersRepo ordersRepo, StudentsRepo studentsRepo, StudentsService studentsService, OrdersMapper ordersMapper, StudentsMapper studentsMapper) {
        this.ordersRepo = ordersRepo;
        this.studentsRepo = studentsRepo;
        this.studentsService = studentsService;
        this.ordersMapper = ordersMapper;
        this.studentsMapper = studentsMapper;
    }

    @Override
    public Orders findStuden(Long id) {
        return ordersRepo.findById(id).orElse(null);
    }

    @Override
    public Orders create(Orders oreder) {
        return ordersRepo.save(oreder);
    }

    @Override
    public List<Orders> getAll() {
        return (List<Orders>) ordersRepo.findAll();
    }

    @Override
    public void delete(Long id) {
        ordersRepo.deleteById(id);
    }

    @Override
    public Orders update(Orders order) {
        return ordersRepo.save(order);
    }

    @Override
    public String requestOrder(OrdersDto orderDto) {

        StudentsDto studentDto = studentsService.findOrCreate(orderDto.getStudentDto());

        Orders order = ordersRepo.findByStudentId(ordersMapper.toOrders(orderDto).getStudent().getId());

        if(order == null) {
            ordersRepo.save(ordersMapper.toOrders(orderDto));
            return "Your request is accepted";
        } else {
            OrdersDto oldOrder = ordersMapper.toOrdersDto(order);

            if (oldOrder.getEndDate() == null) {
                if (oldOrder.getStatus().equals(OrderStatus.PROCESSED)) {
                    return "Already requested and in the process.";
                } else {
                    oldOrder.setStatus(OrderStatus.CANCELLED);
                    oldOrder.setEndDate(new Date());
                    orderDto.setEndDate(null);
                    orderDto.setNavidate(null);
                    orderDto.setComment(null);
                    ordersRepo.save(ordersMapper.toOrders(orderDto));
                    return "Your request is accepted";
                }
            } else {
                orderDto.setEndDate(null);
                orderDto.setNavidate(null);
                orderDto.setComment(null);
                ordersRepo.save(ordersMapper.toOrders(orderDto));
                return "Your request is accepted";
            }
        }
    }


    @Override
    public String processRequest(OrdersDto orderDto) {

        try{
            OrdersDto oldOrderDto = ordersMapper.toOrdersDto(ordersRepo.findById(ordersMapper.toOrders(orderDto).getId()).orElseThrow(()-> new OrderNotFoundException()));
            oldOrderDto.setNavidate(new Date());

            if(orderDto.getStatus().equals(OrderStatus.APPROVED)){
                oldOrderDto.setStatus(orderDto.getStatus());
                oldOrderDto.setComment(orderDto.getComment());
            } else {
                oldOrderDto.setStatus(orderDto.getStatus());
                oldOrderDto.setComment(orderDto.getComment());
                oldOrderDto.setEndDate(new Date());
            }
            ordersRepo.save(ordersMapper.toOrders(oldOrderDto));
            return "processed";
        } catch (OrderNotFoundException e){
            System.out.println(e.toString());
            return e.toString();
        }
    }


}
