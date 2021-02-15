package com.chauhan.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import com.chauhan.interfaces.service.ILibraryService;
import com.chauhan.model.Book;
import com.chauhan.model.Library;

@Service
public class LibraryRepository implements ILibraryService {
	private static SessionFactory factory;

	public LibraryRepository() {
		try {
			factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Library.class)
					.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	@Override
	public Collection<Library> getLibraryList() {
		Session session = factory.openSession();
		Transaction tx = null;
		ArrayList<Library> libraryList = null;

		try {
			tx = session.beginTransaction();
			String hql = "from Library";
			libraryList = (ArrayList<Library>) session.createQuery(hql).list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return libraryList;
	}

	@Override
	public Library getLibrary(String libraryId) {
		Session session = factory.openSession();
		Transaction tx = null;
		Library library = null;

		try {
			tx = session.beginTransaction();
			library = session.get(Library.class, libraryId);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return library;

	}

	@Override
	public boolean saveLibrary(Library library) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(library);
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
	public boolean updateLibrary(Library library) {
		Session session = factory.openSession();
		Transaction tx = null;
		Library tempLibrary = null;
		try {
			tx = session.beginTransaction();
			tempLibrary = session.get(Library.class, library.getLibraryId());

			tempLibrary.setCity(library.getCity());
			tempLibrary.setBooks(library.getBooks());
			tempLibrary.setCountry(library.getCountry());
			tempLibrary.setRating(library.getRating());

			session.save(tempLibrary);

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
	public boolean deleteLibrary(String libraryId) {
		Session session = factory.openSession();
		Transaction tx = null;
		Library library = null;

		try {
			tx = session.beginTransaction();
			library = session.get(Library.class, libraryId);
			session.delete(library);
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
	public Collection<Book> getBooksByLibraryId(String libraryId) {
		Session session = factory.openSession();
		Transaction tx = null;
		Collection<Book> bookList = null;

		try {
			tx = session.beginTransaction();
			bookList = session.get(Library.class, libraryId).getBooks();
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
	public boolean addBookToLibrary(String libraryId, Book book) {
		Session session = factory.openSession();
		Transaction tx = null;
		Library library = null;

		try {
			tx = session.beginTransaction();
			library = session.get(Library.class, libraryId);
			library.getBooks().add(book);
			session.save(library);
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

	@Override
	public boolean deleteBookFromLibrary(String libraryId, int isbn) {
		Session session = factory.openSession();
		Transaction tx = null;
		Library library = null;
		Book book = null;

		try {
			tx = session.beginTransaction();
			library = session.get(Library.class, libraryId);
			for (Iterator<Book> iter = library.getBooks().iterator(); iter.hasNext();) {
				book = iter.next();
				if (book.getIsbn() == isbn) {
					break;
				}
			}
			library.getBooks().remove(book);
			session.delete(book);
			session.save(library);
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
