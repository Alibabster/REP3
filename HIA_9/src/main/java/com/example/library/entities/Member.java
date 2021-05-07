package com.example.library.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name= "members")
@Component
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Integer id;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "account_id")
    private Integer account_id;

    @OneToOne(fetch=FetchType.LAZY,	optional=false)
    @JoinColumn(name="account_id",nullable=false, insertable = false, updatable = false)
    private	Account	account;

    public Member(Integer id, String fullname) {
        this.id = id;
        this.fullname = fullname;
    }

    public Member(){}
}
