package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Player;
import pojos.Team;

public class PlayerDaoImpl implements PlayerDao {

	@Override
	public String addPlayerToTeam(Player newPlayer, long teamId) {
		String msg = "new palyer added failed";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		Team team=session.get(Team.class, teamId);
		try {
			team.addPlayer(newPlayer);
			session.persist(newPlayer);
			tx.commit();
			msg = "new player added successfully";

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

}
