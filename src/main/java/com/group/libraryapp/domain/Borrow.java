package com.group.libraryapp.domain;

import javax.persistence.*;

@Entity
public class Borrow {
    public Borrow() {}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String bookname;
    @Column(name="user_id")
    private long userid;

    public Borrow(String bookname, long userid) {

        this.bookname = bookname;
        this.userid = userid;
    }

}
