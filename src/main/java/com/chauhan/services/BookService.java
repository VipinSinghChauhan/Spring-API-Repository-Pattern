package com.chauhan.services;

import java.util.Collection;
import org.springframework.stereotype.Service;

import com.chauhan.interfaces.repository.IUnitOfWorkRepository;
import com.chauhan.interfaces.service.IBookService;
import com.chauhan.model.Book;

@Service
public class BookService implements IBookService {

	private IUnitOfWorkRepository unitOfWork;

	public BookService(IUnitOfWorkRepository unitOfWork) {
		this.unitOfWork = unitOfWork;
	}

	@Override
	public Collection<Book> getAllBooks() {
		return this.unitOfWork.getBookRepository().getAllBooks();
	}

	@Override
	public Book getBook(int isbn) {
		return this.unitOfWork.getBookRepository().getBook(isbn);
	}


	@Override
	public boolean updateBook(int isbn, Book book) {
		return this.unitOfWork.getBookRepository().updateBook(isbn, book);
	}

	@Override
	public boolean deleteBook(int isbn) {
		return this.unitOfWork.getBookRepository().deleteBook(isbn);
	}

	@Override
	public boolean saveBook(Book book) {
		return this.unitOfWork.getBookRepository().saveBook(book);
	}

}
