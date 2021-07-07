package com.example.demo.Repository;

import com.example.demo.Model.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepo extends CrudRepository<Orders, Long> {
    Orders findByStudentId(Long id);
}
