package com.example.library.entities;


import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name= "accounts")
@Component
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private Integer id;
    @Column(name = "phone_number")
    private String phone_number;
    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy="account",fetch=FetchType.LAZY)
    private	Member	member;

}
