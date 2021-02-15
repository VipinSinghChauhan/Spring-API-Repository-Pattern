package com.chauhan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Book")
public class Book {

	@Column(name = "title")
	String title;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "isbn")
	int isbn;

	@Column(name = "author")
	String author;

	@Column(name = "price")
	int price;

	@Column(name = "category")
	String category;

	@Column(name = "rating")
	int rating;

	public Book(String title, int isbn, String author, int price, String category, int rating) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.price = price;
		this.category = category;
		this.rating = rating;
	}

	public Book() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", isbn=" + isbn + ", author=" + author + ", price=" + price + ", category="
				+ category + ", rating=" + rating + "]";
	}

}
