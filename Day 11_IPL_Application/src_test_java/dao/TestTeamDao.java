package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pojos.Team;
import utils.HibernateUtils;

class TestTeamDao {
	private static TeamDao dao;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		// build sf n create dao instance
		HibernateUtils.getFactory();// trigger creation of sf
		dao = new TeamDaoImpl();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		HibernateUtils.getFactory().close();
	}

	@Test
	void test() {
		// create team instance : hard coded
		Team newTeam = new Team("Mumbai Indian", "MI", "Neeta Ambani", 35, 55, 25);
//		Team newTeam = new Team("Chennai Super Kings", "CSK", "abc", 35, 65, 25);
		// invoking
		String msg = dao.addNewTeam(newTeam);
		System.out.println(msg);
//		assertEquals(1, newTeam);
	}
	
	@Test
	void testGetAllTeams() {
		List<Team> teams = dao.getAllTeams();
		teams.forEach(t->System.out.println(t.getId()+" "+t.getAbbreviation()));
//		assertEquals(2, teams.size());
	}
}
