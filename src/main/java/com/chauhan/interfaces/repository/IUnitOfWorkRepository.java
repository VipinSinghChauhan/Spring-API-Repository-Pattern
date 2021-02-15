package com.chauhan.interfaces.repository;

import com.chauhan.interfaces.service.IBookService;
import com.chauhan.interfaces.service.ILibraryService;

public interface IUnitOfWorkRepository {

	public ILibraryService libraryRepository = null;
	public IBookService bookRepository = null;

	public ILibraryService getLibraryRepository();

	public IBookService getBookRepository();

}