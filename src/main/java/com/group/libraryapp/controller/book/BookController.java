package com.group.libraryapp.controller.book;

import com.group.libraryapp.dto.book.BookCreateRequest;
import com.group.libraryapp.dto.book.BookLoanRequest;
import com.group.libraryapp.dto.book.BookReturnRequest;
import com.group.libraryapp.service.book.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @PostMapping("/book")
    public void saveBook(@RequestBody BookCreateRequest request) {
        //System.out.println(rawJson);
        System.out.println("Received title: " + request.getName()); // 요청 값 출력
        bookService.saveBook(request);
    }

    @PostMapping("/book/loan")
    public void loanBook(@RequestBody BookLoanRequest request){
        System.out.println("Loan book title: "+request.getBookName());
        System.out.println("Loan user name: "+request.getUserName());
        bookService.loanBook(request);

    }
    @PutMapping("/book/return")
    public void returnBook(@RequestBody BookReturnRequest request){
        System.out.println("Return book title: "+request.getBookName());
        System.out.println("Return user name: "+request.getUserName());
        bookService.returnBook(request);
    }

}
