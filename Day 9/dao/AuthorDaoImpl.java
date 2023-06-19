package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static utils.HibernateUtils.getFactory;

import pojos.Author;

public class AuthorDaoImpl implements AuthorDao {

	@Override
	public String launchNewAuthor(Author auth) {
		String msg = "Adding new author failed";
		// get session from sf
		Session session = getFactory().getCurrentSession();

		// transaction
		Transaction tx = session.beginTransaction();

		// try-catch
		try {
			session.persist(auth);
			// get all book list using forEach
			tx.commit();
			msg = "new book added successfully!!!!!";

		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
				throw e;
			}
		}
		return msg;
	}

}
