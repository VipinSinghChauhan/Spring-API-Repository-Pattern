package com.chauhan.interfaces.service;

import java.util.Collection;
import org.springframework.stereotype.Service;

import com.chauhan.model.Book;

@Service
public interface IBookService {

	// Get all books
	public Collection<Book> getAllBooks();

	// Get a particular book by isbn no.
	public Book getBook(int isbn);

	// Get all book from a particular library
//	public List<Book> getBooks(String libraryId);

	// Update a book of a given library
	public boolean updateBook(int isbn, Book book);

	// Delete a book of a given library
	public boolean deleteBook(int isbn);

	// Save a book to a given library
	public boolean saveBook(Book book);

}
