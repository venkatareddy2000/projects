package com.library.management.system.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.management.system.entity.Book;
import com.library.management.system.service.BookService;

@Controller
@RequestMapping("/librarian")
public class LibrarianController {
	private BookService bookService;

	public LibrarianController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/viewBookDetails")
	public String librarianPage(Model model) {
		List<Book> book = bookService.findAll();
		model.addAttribute("book", book);
		return "view/librarian/view-book-details";
	}

}
