package com.library.management.system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.library.management.system.dao.BookRepository;
import com.library.management.system.dao.IssueBookRepository;
import com.library.management.system.entity.Book;
import com.library.management.system.entity.IssueBook;

import jakarta.transaction.Transactional;

@Service
public class IssueBookServiceImpl implements IssueBookService {

	private IssueBookRepository issueBookRepository;
	private BookRepository bookRepository;

	public IssueBookServiceImpl(IssueBookRepository issueBookRepository, BookRepository bookRepository) {
		this.issueBookRepository = issueBookRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public void save(IssueBook issueBook) {
		issueBookRepository.save(issueBook);
	}

	@Override
	public List<IssueBook> findAll() {
		return issueBookRepository.findAll();
	}

	@Override
	@Transactional
	public void returnBook(String bookCallno, Integer studentId) {
		issueBookRepository.findByBookCallnoAndStudentId(bookCallno, studentId);
		Book book = bookRepository.findByCallNo(bookCallno);
		if (book.getIssued() > 0) {
			book.setQuantity(book.getQuantity() + 1);
			book.setIssued(book.getIssued() - 1);
			bookRepository.save(book);
			issueBookRepository.deleteByBookCallnoAndStudentId(bookCallno, studentId);
		}
	}

}
