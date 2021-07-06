package com.example.demo.Model;

import com.example.demo.Model.Enum.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String schoolName;
    private String schoolAddress;
    private Date addDate;
    private Date endDate;
    private Date navidate;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private String comment;
    @ManyToOne
    private Students student;

}
