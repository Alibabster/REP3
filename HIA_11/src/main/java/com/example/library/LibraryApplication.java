package com.example.library;

import com.example.library.config.SpringConfiguration;
import com.example.library.controller.BookController;
import com.example.library.controller.MemberController;
import com.example.library.controller.PublisherController;
import com.example.library.entities.*;
import com.example.library.services.*;

import java.util.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.SimpleDateFormat;

@SpringBootApplication
public class LibraryApplication {

    public static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
    public static BookIssueService bookIssueService = context.getBean(BookIssueService.class);
    public static BookReservationService bookReservationService = context.getBean(BookReservationService.class);
    public static PublisherService publisherService = context.getBean(PublisherService.class);
    public static BookController bookController = context.getBean(BookController.class);
    public static MemberController memberController = context.getBean(MemberController.class);
    public static PublisherController publisherController = context.getBean(PublisherController.class);

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

                    System.out.println("1. Search by Author or Title");
                    System.out.println("2. All available books");
                    System.out.println("3. All books");

                    list = in.nextInt();
                    in.nextLine();

                    switch (list) {
                        case 1:
                            System.out.println("Input Author or Title: ");
                            String kw = in.nextLine();
                            if(bookController.getBookByAuthor(kw)!=null) {
                                System.out.println(bookController.getBookByAuthor(kw));
                            }
                            else {
                                System.out.println(bookController.getBookByTitle(kw));
                            }
                            break;
                        case 2:
                            String status = "available";
                            System.out.println(bookController.getBookByStatus(status));
                            break;
                        case 3:
                            System.out.println(bookController.getAllBooks());
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Input member's ID: ");
                    Integer member_id = in.nextInt();
                    in.nextLine();

                    System.out.println("All books: ");
                    System.out.println(bookController.getAllBooks());

                    System.out.println("Book's ID: ");
                    Integer book_id = in.nextInt();

                    Member member = memberController.getMemberById(member_id);
                    Book book = bookController.getBookById(book_id);

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
                            System.out.println(memberController.getAllMembers());
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

