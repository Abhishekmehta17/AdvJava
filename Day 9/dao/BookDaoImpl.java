package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static utils.HibernateUtils.getFactory;

import pojos.Author;
import pojos.Book;

public class BookDaoImpl implements BookDao {

	@Override
	public String addnewBook(Book book, String email) {
		String msg = "new book added failed!!!!";
		String jpql = "select a from Author a where a.email= :em ";
		Session session = getFactory().getCurrentSession();
		Transaction transaction =session.beginTransaction();
		try {
			Author auth=session.createQuery(jpql, Author.class)
					.setParameter("em", email).getSingleResult();
			
			if(auth != null)
			{
				auth.addBook(book);
			}
			transaction.commit();
			msg = " New Book Added Succesfully ! ";
			
		} catch (RuntimeException e) {
			if(transaction!=null)
				transaction.rollback();
			throw e;
		}
		return msg;
	}

}
