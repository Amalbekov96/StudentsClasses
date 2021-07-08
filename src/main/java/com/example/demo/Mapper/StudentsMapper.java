package com.example.demo.Mapper;

import com.example.demo.Dto.StudentsDto;
import com.example.demo.Model.Students;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentsMapper {

    StudentsMapper INSTANCE = Mappers.getMapper(StudentsMapper.class);

    Students toStudents(StudentsDto studentsDto);
    StudentsDto toStudentsDto(Students students);
}
