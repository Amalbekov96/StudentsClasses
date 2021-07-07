package com.example.demo.Dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class StudentsDto {

    private long id;
    private String name;
    @DateTimeFormat(pattern="dd-MM-yyyy HH:mm")
    private Date birthDate;
    private String phone;

}
