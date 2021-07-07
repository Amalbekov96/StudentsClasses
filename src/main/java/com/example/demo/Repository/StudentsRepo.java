package com.example.demo.Repository;

import com.example.demo.Model.Students;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepo extends CrudRepository<Students, Long> {
    Students findByPhone(String phone);
}
