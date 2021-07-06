package com.example.demo.Dto;

import com.example.demo.Model.Enum.OrderStatus;
import com.example.demo.Model.Students;
import lombok.Data;

import java.util.Date;

@Data
public class OrdersDto {

    private long id;
    private String schoolName;
    private String schoolAddress;
    private Date addDate;
    private Date endDate;
    private Date navidate;
    private OrderStatus status;
    private String comment;
    private Students student;
}
