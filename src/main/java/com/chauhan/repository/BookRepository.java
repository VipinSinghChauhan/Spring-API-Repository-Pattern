package com.chauhan.repository;

import java.util.Collection;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.chauhan.interfaces.service.IBookService;
import com.chauhan.model.Book;

public class BookRepository implements IBookService {
	private static SessionFactory factory;

	public BookRepository() {
		try {
			factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Book.class)
					.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	@Override
	public Collection<Book> getAllBooks() {
		Session session = factory.openSession();
		Transaction tx = null;
		List<Book> bookList = null;

		try {
			tx = session.beginTransaction();
			bookList = (List<Book>) session.createQuery("FROM Book").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return bookList;

	}

	@Override
	public Book getBook(int isbn) {
		Session session = factory.openSession();
		Transaction tx = null;
		Book book = null;
		System.out.println("Book id :" + isbn);

		try {
			tx = session.beginTransaction();
			book = session.get(Book.class, 201);
			System.out.println("Book + " + book);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getClass());
		}

		finally {
			session.close();
		}
		return book;

	}

	@Override
	public boolean updateBook(int isbn, Book book) {
		Session session = factory.openSession();
		Transaction tx = null;
		Book tempBook = null;

		try {
			tx = session.beginTransaction();
			tempBook = session.get(Book.class, isbn);
			tempBook.setAuthor(book.getAuthor());
			tempBook.setCategory(book.getCategory());
			tempBook.setPrice(book.getPrice());
			tempBook.setRating(book.getRating());
			session.save(tempBook);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}

	}

	@Override
	public boolean deleteBook(int isbn) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.delete(session.get(Book.class, isbn));
			tx.commit();
			return true;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean saveBook(Book book) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(book);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}

	}
}
