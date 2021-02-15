package com.chauhan.services;

import java.util.Collection;
import org.springframework.stereotype.Service;

import com.chauhan.interfaces.repository.IUnitOfWorkRepository;
import com.chauhan.interfaces.service.ILibraryService;
import com.chauhan.model.Book;
import com.chauhan.model.Library;

@Service
public class LibraryService implements ILibraryService {

	private IUnitOfWorkRepository unitOfWork;

	public LibraryService(IUnitOfWorkRepository unitOfWork) {
		this.unitOfWork = unitOfWork;
	}

	@Override
	public Collection<Library> getLibraryList() {
		return this.unitOfWork.getLibraryRepository().getLibraryList();
	}

	@Override
	public Library getLibrary(String libraryId) {
		return this.unitOfWork.getLibraryRepository().getLibrary(libraryId);
	}

	@Override
	public boolean saveLibrary(Library library) {
		return this.unitOfWork.getLibraryRepository().saveLibrary(library);
	}

	@Override
	public boolean updateLibrary(Library library) {
		return this.unitOfWork.getLibraryRepository().updateLibrary(library);
	}

	@Override
	public boolean deleteLibrary(String libraryId) {
		return this.unitOfWork.getLibraryRepository().deleteLibrary(libraryId);
	}

	@Override
	public Collection<Book> getBooksByLibraryId(String libraryId) {
		return this.unitOfWork.getLibraryRepository().getBooksByLibraryId(libraryId);
	}

	@Override
	public boolean addBookToLibrary(String libraryId, Book book) {
		return this.unitOfWork.getLibraryRepository().addBookToLibrary(libraryId, book);
	}

	@Override
	public boolean deleteBookFromLibrary(String libraryId, int isbn) {
		return this.unitOfWork.getLibraryRepository().deleteBookFromLibrary(libraryId, isbn);
	}

}
