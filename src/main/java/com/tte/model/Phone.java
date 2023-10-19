package com.tte.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import java.util.UUID;
import lombok.Data;

import java.util.Date;
import java.util.UUID;
@Data
@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String number;
    private String citycode;
    private String countrycode;
 

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

   
}