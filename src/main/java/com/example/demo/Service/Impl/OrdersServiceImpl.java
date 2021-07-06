package com.example.demo.Service.Impl;

import com.example.demo.Model.Orders;
import com.example.demo.Repository.OrdersRepo;
import com.example.demo.Service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersRepo ordersRepo;

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
}
