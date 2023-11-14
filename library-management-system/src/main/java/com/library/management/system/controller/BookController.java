package com.library.management.system.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.management.system.entity.Book;
import com.library.management.system.entity.IssueBook;
import com.library.management.system.service.BookService;
import com.library.management.system.service.IssueBookService;

@Controller
@RequestMapping("/book")
public class BookController {
	private BookService bookService;
	private IssueBookService issueBookService;

	public BookController(BookService bookService, IssueBookService issueBookService) {
		this.bookService = bookService;
		this.issueBookService = issueBookService;
	}

	@GetMapping("/viewIssuedBooks")
	public String viewIssuedBooks(Model model) {
		List<IssueBook> issueBook = issueBookService.findAll();
		model.addAttribute("issueBook", issueBook);
		return "view/issuedbook/view-issued-book";
	}

	@GetMapping("/addBookDetails")
	public String addBookDetails(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "view/librarian/add-book";
	}

	@PostMapping("/saveBookDetails")
	public String saveBookDetails(@ModelAttribute("book") Book book) {
		bookService.saveBooks(book);
		return "redirect:/librarian/viewBookDetails";
	}

	@GetMapping("/deleteBook")
	public String deleteBook(@RequestParam("bookId") int id) {
		bookService.deleteById(id);
		return "redirect:/librarian/viewBookDetails";
	}

	@GetMapping("/issueBook")
	public String issueBook(Model model) {
		IssueBook issueBook = new IssueBook();
		model.addAttribute("issueBook", issueBook);
		return "view/issuedbook/issue-book";
	}

	@PostMapping("/issuingBook")
	public String issuingBook(@ModelAttribute("issueBook") IssueBook issueBook) {
		String bookCallno = issueBook.getBookCallno();
		bookService.issueBook(bookCallno);
		issueBookService.save(issueBook);
		return "redirect:/book/viewIssuedBooks";
	}

	@GetMapping("/returnBook")
	public String returnBook(@RequestParam("bookCallno") String bookCallno, @RequestParam("studentId") int studentId) {
		issueBookService.returnBook(bookCallno,studentId);
		return "redirect:/book/viewIssuedBooks";
	}
}
