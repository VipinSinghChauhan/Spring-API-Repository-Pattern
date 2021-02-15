package com.chauhan.interfaces.service;

import java.util.Collection;
import org.springframework.stereotype.Service;

import com.chauhan.model.Book;
import com.chauhan.model.Library;

@Service
public interface ILibraryService {

	public Collection<Library> getLibraryList();

	public Library getLibrary(String libraryId);

	public boolean saveLibrary(Library library);

	public boolean updateLibrary(Library library);

	public boolean deleteLibrary(String libraryId);

	// Book functionality
	public Collection<Book> getBooksByLibraryId(String libraryId);

	public boolean addBookToLibrary(String libraryId, Book book);

	public boolean deleteBookFromLibrary(String libraryId, int isbn);

}
