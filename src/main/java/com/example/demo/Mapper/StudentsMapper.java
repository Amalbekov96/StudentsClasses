package com.example.demo.Mapper;

import com.example.demo.Dto.StudentsDto;
import com.example.demo.Model.Students;

public interface StudentsMapper {

    Students toStudents(StudentsDto studentsDto);
    StudentsDto toStudentsDto(Students students);
}
