package com.example.demo.Service;

import com.example.demo.Model.Orders;
import com.example.demo.Model.Students;

import java.util.List;

public interface StudentsService {
    Students findStuden(Long id);
    Students create(Students student);
    List<Students> getAll();
    void delete(Long id);
    Students update(Students student);

}
