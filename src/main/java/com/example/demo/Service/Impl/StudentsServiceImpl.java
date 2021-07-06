package com.example.demo.Service.Impl;

import com.example.demo.Model.Students;
import com.example.demo.Repository.StudentsRepo;
import com.example.demo.Service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsServiceImpl implements StudentsService {

    @Autowired
    private StudentsRepo studentsRepo;

    @Override
    public Students findStuden(Long id) {
        return studentsRepo.findById(id).orElse(null);
    }

    @Override
    public Students create(Students student) {
        return studentsRepo.save(student);
    }

    @Override
    public List<Students> getAll() {
        return (List<Students>) studentsRepo.findAll();
    }

    @Override
    public void delete(Long id) {
        studentsRepo.deleteById(id);
    }

    @Override
    public Students update(Students student) {
        return studentsRepo.save(student);
    }
}
