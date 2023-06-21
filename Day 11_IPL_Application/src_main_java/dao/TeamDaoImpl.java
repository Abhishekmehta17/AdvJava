package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static utils.HibernateUtils.getFactory;

import pojos.Team;

public class TeamDaoImpl implements TeamDao {

	@Override
	public List<Team> getAllTeams() {
		String jpql = "select new pojos.Team(id,abbreviation) from Team";
		List<Team> teams = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			teams = session.createQuery(jpql, Team.class).getResultList();
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return teams;
	}

	@Override
	public String addNewTeam(Team newteam) {
		String msg= "new team added failed";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(newteam);
			tx.commit();
			msg = "new team added with id successfully";

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public Team getTeamDetails(long teamId) {
		Session session = getFactory().getCurrentSession();
		Team team = null;
		Transaction tx = session.beginTransaction();
		try {
			team=session.get(Team.class, teamId);
			System.out.println(team);
			tx.commit();

		} 
		catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return team;
	}

}
