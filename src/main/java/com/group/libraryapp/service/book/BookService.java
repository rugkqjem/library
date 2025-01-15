package com.group.libraryapp.service.book;

import com.group.libraryapp.domain.*;
import com.group.libraryapp.dto.book.BookCreateRequest;
import com.group.libraryapp.dto.book.BookLoanRequest;
import com.group.libraryapp.dto.book.BookReturnRequest;
import com.group.libraryapp.repository.book.BookMemoryJdbcRepository;
import com.group.libraryapp.repository.book.BookJdbcRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BorrowRepository borrowRepository;
    private final UserRepository userRepository;

    public BookService(BookRepository bookRepository, UserRepository userRepository, BorrowRepository borrowRepository) {
        this.borrowRepository=borrowRepository;
        this.userRepository=userRepository;
        this.bookRepository=bookRepository;
    }
    @Transactional
    public void saveBook(BookCreateRequest request){
        bookRepository.save(new Book(request.getName()));
    }
    @Transactional
    public void loanBook(BookLoanRequest request){
        //userrepository에서 request.getUserNmae() 의 user_id 찾아야함
        User user=userRepository.findByName(request.getUserName());
        if(user==null){ throw new IllegalArgumentException("User not found"); }
        Book book=bookRepository.findByTitle(request.getBookName());
        if(book==null){ throw new IllegalArgumentException("Book not found"); }
        if(book.isBorrowed()){
            throw new IllegalArgumentException("Book is already borrowed");
        }
        borrowRepository.save(new Borrow(request.getBookName(),user.getId()));
        book.updateIsborrowed(true);
        bookRepository.save(book);
        //bookrepository에서 해당 책 대출 is_borrowed 1로 수정해야됨
    }
    @Transactional
    public void returnBook(BookReturnRequest request){
        User user=userRepository.findByName(request.getUserName());
        if(user==null){ throw new IllegalArgumentException("User not found"); }
        Book book=bookRepository.findByTitle(request.getBookName());
        book.updateIsborrowed(false);
        Borrow borrow=borrowRepository.findByBooknameAndUserid(request.getBookName(), user.getId());
        borrowRepository.delete(borrow);
        //borrowRepository.findby
    }


}
