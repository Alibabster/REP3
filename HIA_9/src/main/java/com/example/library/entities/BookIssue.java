package com.example.library.entities;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name= "bookissues")
@Component
@Data
public class BookIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_issue_id")
    private Integer id;
    @Column(name="member_id")
    private Integer member_id;
    @Column(name="book_id")
    private Integer book_id;
    @Column(name = "issued_date")
    private String issued_date;
    @Column(name = "return_date")
    private String return_date;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "book_id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private Book book;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "member_id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private Member member;

    public BookIssue(Integer member_id, Integer book_id, String issued_date, String return_date) {
        this.member_id = member_id;
        this.book_id = book_id;
        this.issued_date = issued_date;
        this.return_date = return_date;
    }

    public BookIssue(){

    }
}
