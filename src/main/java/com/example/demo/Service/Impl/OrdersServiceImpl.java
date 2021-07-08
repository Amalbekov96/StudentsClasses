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
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> requestOrder(OrdersDto orderDto) {

        StudentsDto studentDto = studentsService.findOrCreate(orderDto.getStudentDto());

        Orders orderTemp = ordersMapper.toOrders(orderDto);

        List<OrdersDto> orderDtoList = OrdersMapper.INSTANCE.toOrderDtoList(ordersRepo.findByStudentId(orderTemp.getStudent().getId()));

        if(orderDtoList.isEmpty()) {
            ordersRepo.save(ordersMapper.toOrders(orderDto));
            return new ResponseEntity<String>("Your request is accepted", HttpStatus.OK);
        } else {
            for(OrdersDto oldOrder : orderDtoList){
                if (oldOrder.getEndDate() == null) {
                    if (oldOrder.getStatus().equals(OrderStatus.PROCESSED)) {
                        return new ResponseEntity<String>("Already requested and in the process.", HttpStatus.OK);
                    } else {
                        oldOrder.setStatus(OrderStatus.CANCELLED);
                        oldOrder.setEndDate(new Date());
                        orderDto.setEndDate(null);
                        orderDto.setNavidate(null);
                        orderDto.setComment(null);
                        ordersRepo.saveAll(ordersMapper.toOrderList(orderDtoList));
                        orderDto.setStatus(OrderStatus.NEW);
                        ordersRepo.save(ordersMapper.toOrders(orderDto));
                        return new ResponseEntity<String>("Your request is accepted", HttpStatus.OK);
                    }

                } else {
                    orderDto.setEndDate(null);
                    orderDto.setNavidate(null);
                    orderDto.setComment(null);
                    orderDto.setStatus(OrderStatus.NEW);
                    ordersRepo.save(ordersMapper.toOrders(orderDto));
                    return new ResponseEntity<String>("Your request is accepted", HttpStatus.OK);
                }
            }
            return new ResponseEntity<String>("Empty List", HttpStatus.BAD_REQUEST);
        }
    }


    @Override
    public ResponseEntity<String> processRequest(OrdersDto orderDto) {

        Orders oldOrders = ordersRepo.findById(orderDto.getId()).orElseThrow(()-> new OrderNotFoundException());
        OrdersDto oldOrderDto= ordersMapper.toOrdersDto(oldOrders);

        if(oldOrderDto.getStatus().equals(OrderStatus.NEW)){
            oldOrderDto.setStatus(OrderStatus.PROCESSED);
            oldOrderDto.setNavidate(new Date());
            ordersRepo.save(ordersMapper.toOrders(oldOrderDto));
            return new ResponseEntity<String>("Order is taken to process", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Bad order status", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> decideOnRequest(OrdersDto orderDto) {

        Orders oldOrders = ordersRepo.findById(orderDto.getId()).orElseThrow(()-> new OrderNotFoundException());
        OrdersDto oldOrderDto= ordersMapper.toOrdersDto(oldOrders);

        if(orderDto.getStatus().equals(OrderStatus.APPROVED)){
            oldOrderDto.setStatus(orderDto.getStatus());
            oldOrderDto.setComment(orderDto.getComment());
            ordersRepo.save(ordersMapper.toOrders(oldOrderDto));
            return new ResponseEntity<String>("Your order is Approved!!", HttpStatus.OK);
        } else if (orderDto.getStatus().equals(OrderStatus.DENEID)){
            return new ResponseEntity<String>("Your Request is Denied, please read the comment", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Bad order status", HttpStatus.BAD_REQUEST);
        }
    }


}
