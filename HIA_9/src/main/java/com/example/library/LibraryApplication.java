package com.example.library;

import com.example.library.config.SpringConfiguration;
import com.example.library.entities.*;
import com.example.library.services.*;

import java.util.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.SimpleDateFormat;

@SpringBootApplication
public class LibraryApplication {

    public static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
    public static BookService bookService = context.getBean(BookService.class);
    public static MemberService memberService = context.getBean(MemberService.class);
    public static BookIssueService bookIssueService = context.getBean(BookIssueService.class);
    public static BookReservationService bookReservationService = context.getBean(BookReservationService.class);
    public static PublisherService publisherService = context.getBean(PublisherService.class);
    public static Scanner in = new Scanner(System.in);


    public static void main(String[] args) {

        int choice = -1;
        while (true) {


            System.out.println("1. Check Catalogue");
            System.out.println("2. Issue a Book");
            System.out.println("3. Show lists");
            System.out.println("0. Exit");

            choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:

                    int list;

                    System.out.println("1. Catalogue by Genre");
                    System.out.println("2. Catalogue by Author");
                    System.out.println("3. All available books");
                    System.out.println("4. All books");

                    list = in.nextInt();
                    in.nextLine();

                    switch (list) {
                        case 1:
                            System.out.println("Available Genres: 1.Novel     2.Fantasy    3.Crime    4.Crime");
                            Integer genre_id = in.nextInt();
                            for(Book book : bookService.getAll()){
                                for(Genre genre : book.getGenres()){
                                    if(genre.getId()==genre_id){
                                        System.out.println(book.toString());
                                    }
                                }
                            }
                            break;
                        case 2:
                            System.out.println("Inout Author: ");
                            String author = in.nextLine();
                            for(Book book : bookService.getAll()){
                                    if(book.getAuthor().equals(author)){
                                        System.out.println(book.toString());
                                }
                            }
                            break;
                        case 3:
                            for(Book book : bookService.getAll()){
                                if(book.getAuthor().equals("available")){
                                    System.out.println(book.toString());
                                }
                            }
                            break;
                        case 4:
                            System.out.println(bookService.getAll());
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Input member's ID: ");
                    Integer member_id = in.nextInt();
                    in.nextLine();

                    System.out.println("All books: ");
                    System.out.println(bookService.getAll());

                    System.out.println("Book's ID: ");
                    Integer book_id = in.nextInt();

                    Member member = memberService.getById(member_id);
                    Book book = bookService.getById(book_id);

                    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
                    Date date = new Date(System.currentTimeMillis());
                    String issue_date = formatter.format(date);


                    if(book.getStatus().equals("available"))
                    {
                        BookIssue bookIssue = new BookIssue(member_id,book_id,issue_date,"10 days");
                        bookIssueService.create(bookIssue);
                    } else {
                        System.out.println("Current book is not available! Do you want to reserve it?:   1.Yes     2.No");
                        int select = in.nextInt();
                        in.nextLine();
                        if(select==1){
                            BookReservation bookReservation = new BookReservation(member_id,book_id,issue_date);
                            bookReservationService.create(bookReservation);
                        }
                    }
                    break;
                case 3:
                    int var;

                    System.out.println("1. All issued books");
                    System.out.println("2. All reserved books");
                    System.out.println("3. All members");
                    System.out.println("4. All publishers");


                    var = in.nextInt();
                    in.nextLine();

                    switch (var) {
                        case 1:
                            System.out.println(bookIssueService.getAll());
                            break;
                        case 2:
                            System.out.println(bookReservationService.getAll());
                            break;
                        case 3:
                            System.out.println(memberService.getAll());
                            break;
                        case 4:
                            System.out.println(publisherService.getAll());
                            break;
                    }
                    break;
                case 0:
                    System.out.println("Exit");
                    return;
            }
        }
    }
}

