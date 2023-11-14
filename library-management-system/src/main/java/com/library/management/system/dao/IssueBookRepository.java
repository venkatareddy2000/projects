package com.library.management.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.management.system.entity.IssueBook;

public interface IssueBookRepository extends JpaRepository<IssueBook, Integer> {

	IssueBook findByBookCallnoAndStudentId(String bookCallno, int studentId);

    void deleteByBookCallnoAndStudentId(String bookCallno, int studentId);

}
