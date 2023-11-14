package com.library.management.system.service;

import java.util.List;

import com.library.management.system.entity.IssueBook;

public interface IssueBookService {
	void save(IssueBook issueBook);

	List<IssueBook> findAll();

	void returnBook(String bookCallno, Integer studentId);
}
