package com.chauhan.repository;

import org.springframework.stereotype.Component;

import com.chauhan.interfaces.repository.IUnitOfWorkRepository;
import com.chauhan.interfaces.service.IBookService;
import com.chauhan.interfaces.service.ILibraryService;

@Component
public class UnitOfWorkRepository implements IUnitOfWorkRepository {

	private ILibraryService libraryRepository;

	private IBookService bookRepository;

	@Override
	public ILibraryService getLibraryRepository() {
		if (libraryRepository == null) {
			libraryRepository = new LibraryRepository();
		}
		return libraryRepository;
	}

	@Override
	public IBookService getBookRepository() {
		if (bookRepository == null) {
			bookRepository = new BookRepository();
		}
		return bookRepository;
	}

}
