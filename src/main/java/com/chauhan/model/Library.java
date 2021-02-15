package com.chauhan.model;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "Library")
public class Library {

	@Id
	String libraryId;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Collection<Book> books;

	@Column(name = "country")
	String country;

	@Column(name = "city")
	String city;

	@Column(name = "rating")
	int rating;

	public Library(String libraryId, Collection<Book> books, String country, String city, int rating) {
		super();
		this.libraryId = libraryId;
		this.books = books;
		this.country = country;
		this.city = city;
		this.rating = rating;
	}

	public Library() {

	}

	public Collection<Book> getBooks() {
		return books;
	}

	public String getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(String libraryId) {
		this.libraryId = libraryId;
	}

	public void setBooks(Collection<Book> books) {
		this.books = books;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	// other than getter and setter

	@Override
	public String toString() {
		return "Library [libraryId=" + libraryId + ", books=" + books + ", country=" + country + ", city=" + city
				+ ", rating=" + rating + "]";
	}

}
