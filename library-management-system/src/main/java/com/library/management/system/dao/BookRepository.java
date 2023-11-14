package com.library.management.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.management.system.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	Book findByCallNo(String callNo);

}
