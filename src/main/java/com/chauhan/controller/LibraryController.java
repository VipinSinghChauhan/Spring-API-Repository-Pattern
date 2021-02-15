package com.chauhan.controller;

import java.util.Collection;
import com.chauhan.interfaces.service.IBusinessServiceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chauhan.model.Book;
import com.chauhan.model.Library;

@RestController
public class LibraryController {

	@Autowired
	private IBusinessServiceUnit businessServiceUnit;

	@RequestMapping(method = RequestMethod.GET, value = "/library")
	public Collection<Library> getLibraryList() {
		return this.businessServiceUnit.getLibraryService().getLibraryList();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/library/{libraryId}")
	public Library getLibrary(@PathVariable String libraryId) {
		return this.businessServiceUnit.getLibraryService().getLibrary(libraryId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/library")
	public boolean saveLibrary(@RequestBody Library library) {
		return this.businessServiceUnit.getLibraryService().saveLibrary(library);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/library/{libraryId}")
	public boolean updateLibrary(@RequestBody Library library) {
		return this.businessServiceUnit.getLibraryService().updateLibrary(library);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/library/{libraryId}")
	public boolean deleteLibrary(@PathVariable String libraryId) {
		return this.businessServiceUnit.getLibraryService().deleteLibrary(libraryId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/library/{libraryId}/books")
	public Collection<Book> getBooksByLibraryId(@PathVariable String libraryId) {
		return this.businessServiceUnit.getLibraryService().getBooksByLibraryId(libraryId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/library/{libraryId}/books")
	public boolean addBookToLibrary(@PathVariable String libraryId, @RequestBody Book book) {
		return this.businessServiceUnit.getLibraryService().addBookToLibrary(libraryId, book);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/library/{libraryId}/{isbn}")
	public boolean deleteBookFromLibrary(@PathVariable String libraryId, @PathVariable int isbn) {
		return this.businessServiceUnit.getLibraryService().deleteBookFromLibrary(libraryId, isbn);
	}
}
