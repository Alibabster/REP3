package com.example.library.entities;

import lombok.Data;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "publishers")
@Component
@Data
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "publisher_id")
    private Integer id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.EAGER)
    private List<Book> books;

    public Publisher(String name) {
        this.name = name;
    }
    public Publisher(){
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
