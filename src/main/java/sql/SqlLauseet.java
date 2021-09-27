package sql;

public class SqlLauseet {

	//tässä on kaikki ohjelmassa käytetyt sql-lauseet
	
	String createPlayerTable =
			 "CREATE TABLE player(\r\n"
			+ "player_id int auto_increment NOT NULL,\r\n"
			+ "name varchar(25) NOT NULL, \r\n"
			+ "team_id int ,\r\n"
			+ "driver1_id int ,\r\n"
			+ "driver2_id int ,\r\n"
			+ "FOREIGN KEY (team_id) REFERENCES team(team_id),\r\n"
			+ "FOREIGN KEY (driver1_id) REFERENCES driver(driver_id),\r\n"
			+ "FOREIGN KEY (driver2_id) REFERENCES driver(driver_id),\r\n"
			+ "PRIMARY KEY(player_id)\r\n"
			+ ")engine=InnoDB;\r\n";
	
	
	String createTeamTable =
			"CREATE TABLE team(\r\n"
			+"team_id int  auto_increment NOT NULL,\r\n"
			+"name varchar(25) NOT NULL,\r\n"
			+"PRIMARY KEY (team_id)\r\n"
			+")engine=InnoDB; \r\n";
	
	
	String createDriverTable =
			"CREATE TABLE driver(\r\n"+
			"driver_id int auto_increment NOT NULL,\r\n"+
			"name varchar(25) NOT NULL,\r\n"+
			"PRIMARY KEY (driver_id)\r\n"+
			")engine=InnoDB;"; 
	
	
	String insertToTeam =
			"INSERT INTO team (name) VALUES (?);";
	
	String insertToDriver =
			"INSERT INTO driver (name) VALUES (?);";
	
	String selectDrivers =
			"select * from driver";
	
	String selectTeams =
			"select * from team";
			
	
	String insertToPLayer =
			"INSERT INTO player (name, driver1_id, driver2_id, team_id) VALUES (?,?,?,?);";
	
	String dropPLayer =
			"DROP table player";
	
	String dropDriver =
			"DROP table driver";
	
	String dropTeam =
			"DROP table team";
	
	String deletePlayer = "DELETE from player where name=?";
	
	String updatePlayer =
			"UPDATE player SET driver1_id = ?, driver2_id = ?, team_id =? WHERE name=?;";
	
}
