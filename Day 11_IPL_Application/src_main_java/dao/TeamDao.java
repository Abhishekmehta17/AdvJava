package dao;

import java.util.List;

import pojos.Team;

public interface TeamDao {
	//add a method to add list of team 
	List<Team> getAllTeams();

	String addNewTeam(Team newteam);
	
	Team getTeamDetails(long teamId);
}
