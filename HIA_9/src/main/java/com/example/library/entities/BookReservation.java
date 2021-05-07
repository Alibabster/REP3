package com.example.library.entities;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name= "book_reservations")
@Component
@Data
public class BookReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_reservation_id")
    private Integer id;
    @Column(name="member_id")
    private Integer member_id;
    @Column(name="book_id")
    private Integer book_id;
    @Column(name = "reserved_date")
    private String reserved_date;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "book_id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private Book book;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "member_id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private Member member;

    public BookReservation(Integer member_id, Integer book_id, String reserved_date) {
        this.member_id = member_id;
        this.book_id = book_id;
        this.reserved_date = reserved_date;
    }

    public BookReservation(){

    }
}
