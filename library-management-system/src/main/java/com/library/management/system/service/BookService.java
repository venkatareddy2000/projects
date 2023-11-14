package com.library.management.system.service;

import java.util.List;

import com.library.management.system.entity.Book;

public interface BookService {

	void saveBooks(Book book);

	List<Book> findAll();

	Book updateById(Integer id);

	void deleteById(Integer id);

	void issueBook(String bookCallno);

	Book findByCallno(String bookCallno);

}
