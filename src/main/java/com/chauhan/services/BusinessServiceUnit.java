package com.chauhan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chauhan.interfaces.repository.IUnitOfWorkRepository;
import com.chauhan.interfaces.service.IBookService;
import com.chauhan.interfaces.service.IBusinessServiceUnit;
import com.chauhan.interfaces.service.ILibraryService;

@Service
public class BusinessServiceUnit implements IBusinessServiceUnit {

	@Autowired
	private IUnitOfWorkRepository unitOfWork;

	@Autowired
	private ILibraryService libraryService;
	@Autowired
	private IBookService bookService;

	public ILibraryService getLibraryService() {

		if (this.libraryService == null) {
			this.libraryService = new LibraryService(unitOfWork);
		}

		return this.libraryService;
	}

	public void setLibraryService(ILibraryService libraryService) {
		this.libraryService = libraryService;
	}

	@Override
	public IBookService getBookService() {
		if (this.bookService == null) {
			this.bookService = new BookService(unitOfWork);
		}
		return this.bookService;
	}

}
