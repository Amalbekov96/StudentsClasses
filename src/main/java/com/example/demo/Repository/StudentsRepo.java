package com.example.demo.Repository;

import com.example.demo.Model.Students;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface StudentsRepo extends CrudRepository<Students, Long> {
}
