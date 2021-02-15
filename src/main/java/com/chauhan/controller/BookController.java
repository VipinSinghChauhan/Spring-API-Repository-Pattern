package com.chauhan.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chauhan.interfaces.service.IBusinessServiceUnit;
import com.chauhan.model.Book;

@RestController
public class BookController {
	
	@Autowired
	private IBusinessServiceUnit businessServiceUnit;

	@RequestMapping(method = RequestMethod.GET, value = "/books")
	public Collection<Book> getBooks() {
		return this.businessServiceUnit.getBookService().getAllBooks();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/books/{isbn}")
	public Book getBook(@PathVariable int isbn) {
		return this.businessServiceUnit.getBookService().getBook(isbn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/books")
	public boolean saveBook(@RequestBody Book book) {
		System.out.println(book);
		System.out.println(businessServiceUnit);
		return this.businessServiceUnit.getBookService().saveBook(book);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/books/{isbn}")
	public boolean updateBook(@PathVariable int isbn, @RequestBody Book book) {
		return this.businessServiceUnit.getBookService().updateBook(isbn, book);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/books/{isbn}")
	public boolean deleteBook(@PathVariable int isbn) {
		return this.businessServiceUnit.getBookService().deleteBook(isbn);
	}

}
