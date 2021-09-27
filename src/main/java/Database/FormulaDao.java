package Database;

import java.util.ArrayList;

import model.*;


public interface FormulaDao {
			
	public void createSeasonPlayerTable();
	
	public void createSeasonDriverTable();
	
	public void createSeasonTeamTable();
	
	public void insertToTeams(Standings standings);
	
	public void insertToDrivers(Standings standings);
	
	public ArrayList getDriverStandings();
	
	public ArrayList getTeamStandings();
	
	public void insertToPlayers(Player player);
	
	public void deleteDatabase();
	
	public ArrayList getPlayers();
	
	public boolean removePlayer(String name);

	public void modifyPlayer(Player player); 
	
}
