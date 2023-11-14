package com.library.management.system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.library.management.system.dao.BookRepository;
import com.library.management.system.entity.Book;

@Service
public class BookServiceImpl implements BookService {

	private BookRepository bookRepository;

	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public void saveBooks(Book book) {
		bookRepository.save(book);
	}

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public Book updateById(Integer id) {
		Optional<Book> result = bookRepository.findById(id);
		Book book = null;
		if (result.isPresent()) {
			book = result.get();
		} else {
			throw new RuntimeException("Book Id didn't found : " + id);
		}
		return book;
	}

	@Override
	public void deleteById(Integer id) {
		bookRepository.deleteById(id);
	}

	@Override
	public void issueBook(String bookCallno) {
		Book book = bookRepository.findByCallNo(bookCallno);
		if (book.getQuantity() > 0) {
			book.setQuantity(book.getQuantity() - 1);
			book.setIssued(book.getIssued() + 1);
			bookRepository.save(book);
		}
	}

	@Override
	public Book findByCallno(String bookCallno) {
		return bookRepository.findByCallNo(bookCallno);
	}

}
