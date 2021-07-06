package com.example.demo.Dto;

import lombok.Data;

import java.util.Date;

@Data
public class StudentsDto {

    private long id;
    private String name;
    private Date birthDate;

}
