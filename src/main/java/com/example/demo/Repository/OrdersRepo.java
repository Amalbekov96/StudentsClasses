package com.example.demo.Repository;

import com.example.demo.Model.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepo extends CrudRepository<Orders, Long> {
    List<Orders> findByStudentId(Long id);
}
