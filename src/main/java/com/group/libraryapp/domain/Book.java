package com.group.libraryapp.domain;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id=null;
    @Column(nullable = false,length = 25)
    private String title;
    private boolean is_borrowed;

    public Book(){}

    public Book(String title){
        if(title==null||title.isBlank()){
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title=title;
        this.is_borrowed=false;
    }

    public String getTitle(){return title;}
    public boolean isBorrowed(){return is_borrowed;}
    public void updateIsborrowed(boolean is_borrowed){this.is_borrowed=is_borrowed;}

}
