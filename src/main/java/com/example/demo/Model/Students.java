package com.example.demo.Model;

import lombok.Data;

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

    private Date birthDate;

}
