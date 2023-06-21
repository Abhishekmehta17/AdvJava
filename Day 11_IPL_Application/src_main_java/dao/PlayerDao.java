package dao;

import pojos.Player;

public interface PlayerDao {

	//add a method to lift team id n abbrevation from all the teams
	String addPlayerToTeam(Player newPlayer,long teamId);
}
