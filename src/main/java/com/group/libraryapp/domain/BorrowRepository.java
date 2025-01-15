package com.group.libraryapp.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BorrowRepository extends JpaRepository<Borrow, Long> {
    Borrow findByBooknameAndUserid(String bookname,long userid);
}
