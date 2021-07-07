package com.example.demo.Controller;

import com.example.demo.Dto.StudentsDto;
import com.example.demo.Mapper.StudentsMapper;
import com.example.demo.Model.Students;
import com.example.demo.Service.StudentsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("students")
public class StudentsController {

    private StudentsMapper studentsMapper;
    private StudentsService studentsService;

    public StudentsController(StudentsMapper studentsMapper, StudentsService studentsService) {
        this.studentsMapper = studentsMapper;
        this.studentsService = studentsService;
    }

    @PostMapping("/create")
    public StudentsDto create(@RequestBody StudentsDto studentDto){
        return studentsMapper.toStudentsDto(studentsService.create(studentsMapper.toStudents(studentDto)));
    }

}
