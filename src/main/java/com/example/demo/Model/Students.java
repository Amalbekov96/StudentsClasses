package com.example.demo.Model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @DateTimeFormat(pattern="dd-MM-yyyy HH:mm")
    private Date birthDate;
    private String phone;

}
