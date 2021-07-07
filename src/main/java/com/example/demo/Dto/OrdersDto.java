package com.example.demo.Dto;

import com.example.demo.Model.Enum.OrderStatus;
import com.example.demo.Model.Students;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
public class OrdersDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String schoolName;
    private String schoolAddress;
    @CreationTimestamp
    @DateTimeFormat(pattern="dd-MM-yyyy HH:mm")
    private Date addDate;
    private Date endDate;
    private Date navidate;
    private OrderStatus status;
    private String comment;
    @ManyToOne
    private StudentsDto studentDto;
}
