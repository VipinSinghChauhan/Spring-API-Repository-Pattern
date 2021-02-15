package com.chauhan.interfaces.service;

import org.springframework.stereotype.Service;

@Service
public interface IBusinessServiceUnit {

	public ILibraryService libraryService = null;

	public IBookService bookService = null;
	
	
	
	public ILibraryService getLibraryService();

	public IBookService getBookService();
}
