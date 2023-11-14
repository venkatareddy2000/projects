package com.library.management.system.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "issuebooks")
public class IssueBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "bookcallno")
	private String bookCallno;
	@Column(name = "studentid")
	private int studentId;
	@Column(name = "studentname")
	private String studentName;
	@Column(name = "studentcontact")
	private String studentContact;
	@Column(name = "issueddate")
	private Timestamp issuedDate;

	@PrePersist
	protected void onCreate() {
		issuedDate = new Timestamp(System.currentTimeMillis());
	}

	public IssueBook() {

	}

	public IssueBook(String bookCallno, int studentId, String studentName, String studentContact) {
		this.bookCallno = bookCallno;
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentContact = studentContact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookCallno() {
		return bookCallno;
	}

	public void setBookCallno(String bookCallno) {
		this.bookCallno = bookCallno;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentContact() {
		return studentContact;
	}

	public void setStudentContact(String studentContact) {
		this.studentContact = studentContact;
	}

	public Timestamp getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Timestamp issuedDate) {
		this.issuedDate = issuedDate;
	}

}
