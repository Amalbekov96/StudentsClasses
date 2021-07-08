package com.example.demo.Mapper.Impl;

import com.example.demo.Dto.StudentsDto;
import com.example.demo.Mapper.StudentsMapper;
import com.example.demo.Model.Students;
import org.springframework.stereotype.Service;

@Service
public class StudentsMapperImpl implements StudentsMapper {

    @Override
    public Students toStudents(StudentsDto studentsDto) {
        return StudentsMapper.INSTANCE.toStudents(studentsDto);
    }

    @Override
    public StudentsDto toStudentsDto(Students students) {
        return StudentsMapper.INSTANCE.toStudentsDto(students);
    }


//    @Override
//    public Students toStudents(StudentsDto studentsDto) {
//        Students student = new Students();
//        student.setId(studentsDto.getId());
//        student.setName(studentsDto.getName());
//        student.setBirthDate(studentsDto.getBirthDate());
//        student.setPhone(studentsDto.getPhone());
//        return student;
//    }
//
//    @Override
//    public StudentsDto toStudentsDto(Students students) {
//        StudentsDto studentDto = new StudentsDto();
//        studentDto.setId(students.getId());
//        studentDto.setName(students.getName());
//        studentDto.setBirthDate(students.getBirthDate());
//        studentDto.setPhone(students.getPhone());
//        return studentDto;
//    }


}
