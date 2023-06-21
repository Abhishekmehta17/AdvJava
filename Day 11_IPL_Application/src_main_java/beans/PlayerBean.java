package beans;
/*
 * myteam fname,lastname,email,dob,bating_avg,wickets teamDao,playerDao | player
 */

import java.time.LocalDate;

import dao.PlayerDaoImpl;
import dao.TeamDaoImpl;
import pojos.Player;
import pojos.Team;

public class PlayerBean {
	private long myteam;
	private String firstName;
	private String lastName;
	private String email;
	private String dOb;
	private String batingAvg;
	private String wicket;
	private TeamDaoImpl teamDao;
	private PlayerDaoImpl playerDao;
	private Player player;

	public PlayerBean() {

		teamDao = new TeamDaoImpl();
		playerDao = new PlayerDaoImpl();
	}

	

	public Long getMyteam() {
		return myteam;
	}



	public void setMyteam(Long myteam) {
		this.myteam = myteam;
	}



	public String getdOb() {
		return dOb;
	}



	public void setdOb(String dOb) {
		this.dOb = dOb;
	}



	public String getBatingAvg() {
		return batingAvg;
	}



	public void setBatingAvg(String batingAvg) {
		this.batingAvg = batingAvg;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWicket() {
		return wicket;
	}

	public void setWicket(String wicket) {
		this.wicket = wicket;
	}

	public TeamDaoImpl getTeamDao() {
		return teamDao;
	}

	public void setTeamDao(TeamDaoImpl teamDao) {
		this.teamDao = teamDao;
	}

	public PlayerDaoImpl getPlayerDao() {
		return playerDao;
	}

	public void setPlayerDao(PlayerDaoImpl playerDao) {
		this.playerDao = playerDao;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public String validateAndAddPlayer() {
		String msg = "Failed to add player!!!!!!";
		System.out.println(myteam);
		Team team = teamDao.getTeamDetails(myteam);
		System.out.println("team"+team);
		if (team != null)
		{
			if(Double.parseDouble(batingAvg)>team.getBattingAvg() && Integer.parseInt(wicket)>team.getWicketsTaken())
				if(LocalDate.now().getYear()-LocalDate.parse(dOb).getYear()>19) {
					player =new Player(firstName,lastName,email,LocalDate.parse(dOb),Double.parseDouble(batingAvg),Integer.parseInt(wicket));
					playerDao.addPlayerToTeam(player, team.getId());
					msg ="new player added successfully!!!!!!";
				}
		}
		return msg;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
