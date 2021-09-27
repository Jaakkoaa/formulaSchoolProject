package Database;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.Database;

import java.sql.PreparedStatement;

import model.*;


public class FormulaJdbcDao implements FormulaDao {

	@Override
	public void createSeasonPlayerTable() {
		
		Connection connection = null;  // tietokantayhteys
		PreparedStatement statement = null;  // sql-lause
	
		//luodaan pöytä tietokantaan 
		
		try {
			connection = Database.getDBConnection();

			String sqlSelect =
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
					
					
			
			statement = connection.prepareStatement(sqlSelect);
			statement.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		}finally {
			Database.closeDBConnection(statement, connection);
		}
	}
	
	
	@Override
public void createSeasonTeamTable() {
		
		Connection connection = null;  // tietokantayhteys
		PreparedStatement statement = null;  // sql-lause
	
		//luodaan pöytä tietokantaan 
		
		
		try {
			connection = Database.getDBConnection();

			String sqlSelect =
					"CREATE TABLE team(\r\n"
					+"team_id int  auto_increment NOT NULL,\r\n"
					+"name varchar(25) NOT NULL,\r\n"
					+"PRIMARY KEY (team_id)\r\n"
					+")engine=InnoDB; \r\n";
				
			
			statement = connection.prepareStatement(sqlSelect);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			Database.closeDBConnection(statement, connection);
		}
	}
	
	
	@Override
public void createSeasonDriverTable() {
	
	Connection connection = null;  // tietokantayhteys
	PreparedStatement statement = null;  // sql-lause

	
	//luodaan taulu tietokantaan 
	
	try {
		connection = Database.getDBConnection();

		String sqlSelect =
				"CREATE TABLE driver(\r\n"+
				"driver_id int auto_increment NOT NULL,\r\n"+
				"name varchar(25) NOT NULL,\r\n"+
				"PRIMARY KEY (driver_id)\r\n"+
				")engine=InnoDB;"; 
		
		statement = connection.prepareStatement(sqlSelect);
		statement.executeUpdate();
		
		
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}finally {
		Database.closeDBConnection(statement, connection);
	}	
}
	
	@Override
	public void insertToTeams(Standings standings) {
		
		
		//lisätään 10 tiimi oliota tietokantaan
		
		ArrayList<Team> teams = standings.getTeams();
		
		for (Team team : teams ) {
			
			Connection connection = null;  // tietokantayhteys
			PreparedStatement statement = null;  // sql-lause

			
			
			try {
				connection = Database.getDBConnection();

				String sqlSelect =
						"INSERT INTO team (name) VALUES (?);";
						
				
				statement = connection.prepareStatement(sqlSelect);
				statement.setString(1, team.getName());
				statement.executeUpdate();
				
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}finally {
				Database.closeDBConnection(statement, connection);
			}	
			
		}
		
	}
	
	@Override
	public void insertToDrivers(Standings standings) {
		 ArrayList<Driver> drivers = standings.getDrivers();
		
		 //lisätään 20 kuski oliota tietokantaan
		 
		for (Driver driver : drivers ) {
			
			Connection connection = null;  // tietokantayhteys
			PreparedStatement statement = null;  // sql-lause

			
			
			try {
				connection = Database.getDBConnection();

				String sqlSelect =
						"INSERT INTO driver (name) VALUES (?);";
						
				
				statement = connection.prepareStatement(sqlSelect);
				statement.setString(1, driver.getName());
				statement.executeUpdate();
				
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}finally {
				Database.closeDBConnection(statement, connection);
			}	
			
		}
	}

	public ArrayList getDriverStandings() {
		
		Connection connection = null;  // tietokantayhteys
		PreparedStatement statement = null;  // sql-lause
		
		ArrayList <Driver> drivers = new ArrayList<Driver>();
		
		//haetaan kuskien listat tietokannasta
		
		try {
			
			connection = Database.getDBConnection();

			String sqlSelect =
					"select * from driver";
					
			
			statement = connection.prepareStatement(sqlSelect);
			
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				
				int standing = rs.getInt("driver_id");
				String name = rs.getString("name");
				
				Driver driver = new Driver(standing, name);
				drivers.add(driver);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			Database.closeDBConnection(statement, connection);
		}	
		
		return drivers;
		
	}
	
public ArrayList getTeamStandings() {
		
		Connection connection = null;  // tietokantayhteys
		PreparedStatement statement = null;  // sql-lause
		
		ArrayList <Team> teams = new ArrayList<Team>();
		
		//haetaan tiimien listat tietokannasta
		
		try {
			
			connection = Database.getDBConnection();

			String sqlSelect =
					"select * from team";
					
			
			statement = connection.prepareStatement(sqlSelect);
			
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				
				int standing = rs.getInt("team_id");
				String name = rs.getString("name");
				
				Team team = new Team(standing, name);
				teams.add(team);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			Database.closeDBConnection(statement, connection);
		}	
		
		return teams;
		
	}

	public void insertToPlayers(Player player) {
		
		Connection connection = null;  // tietokantayhteys
		PreparedStatement statement = null;  // sql-lause

		//lisätään pelaaja
		
		try {
			connection = Database.getDBConnection();

			String sqlSelect =
					"INSERT INTO player (name, driver1_id, driver2_id, team_id) VALUES (?,?,?,?);";
					
			
			statement = connection.prepareStatement(sqlSelect);
			statement.setString(1, player.getName());
			statement.setInt(2, player.getDriver1().getStanding());
			statement.setInt(3, player.getDriver2().getStanding());
			statement.setInt(4, player.getTeam().getStanding());
			
			
			statement.executeUpdate();
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			Database.closeDBConnection(statement, connection);
		}
		
		
	}
	
	public void deleteDatabase() {
		
		Connection connection = null;  // tietokantayhteys
		PreparedStatement statement = null;  // sql-lause

		//uuden seasonin luomisessapoistetaan vanhat taulut ja luodaan uudet
		
		try {
			connection = Database.getDBConnection();

			String sqlSelect =
					"DROP table player";
					
			
			statement = connection.prepareStatement(sqlSelect);
			
			statement.executeUpdate();
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			Database.closeDBConnection(statement, connection);
		}	
		

		try {
			connection = Database.getDBConnection();

			String sqlSelect =
					"DROP table driver";
					
			
			statement = connection.prepareStatement(sqlSelect);
			
			statement.executeUpdate();
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			Database.closeDBConnection(statement, connection);
		}	
		

		try {
			connection = Database.getDBConnection();

			String sqlSelect =
					"DROP table team";
					
			
			statement = connection.prepareStatement(sqlSelect);
			
			statement.executeUpdate();
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			Database.closeDBConnection(statement, connection);
		}	
	}
	
	public ArrayList getPlayers() {

		Connection connection = null;  // tietokantayhteys
		PreparedStatement statement = null;  // sql-lause
		
		ArrayList <Player> players = new ArrayList<Player>();
		
		ArrayList <Driver> drivers = getDriverStandings();
		ArrayList <Team> teams = getTeamStandings();
		
		//haetaan pelaajat
		
 		try {
			
			connection = Database.getDBConnection();

			String sqlSelect =
					"select * from player";
					
			
			statement = connection.prepareStatement(sqlSelect);
			
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				
				String name = rs.getString("name");
				int driver1 = rs.getInt("driver1_id");
				int driver2 = rs.getInt("driver2_id");
				int team = rs.getInt("team_id");
				
				//koska arraylistissä on ensimmäinen 0, pitää hassusti poistaa ykkönen olioista
				
				Player player = new Player(teams.get(team - 1), drivers.get(driver1 - 1), drivers.get(driver2 - 1), name);
				players.add(player);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			Database.closeDBConnection(statement, connection);
		}	
		
		return players;
		
	}
	
	public boolean removePlayer(String name) {
		boolean onnistui = false;
		Connection connection = null;
		PreparedStatement statementINS = null;
		
		//poistetaan pelaaja tietokannasta, hassusti käytetään nimeä eikä id:tä
		//tämä sen takia, että kun ensimmäisen kerran ohjelma tehtiin
		//pelaaja oliolle ei javan puolella annettu id:tä
		//nyt ohjelma on niin pitkällä että pelaaja olio on erittäin monessa paikassa
		//ja korjaus olisi ERITTÄIN suuri duuni
		//poisto toimii nimellä ihan hyvin. paitsi kellään pelaajalla ei voi olla samaa nimeä
		//hyvä opetus siitä kuinka kannattaa suunnitella pidemmälle ennen kun ryhdytään hommiin :)
		
		try {
			connection = Database.getDBConnection();
			
			String inserting = "DELETE from player where name=?";
			statementINS = connection.prepareStatement(inserting);
			statementINS.setString(1, name);
			
			
			int rowsAffected = statementINS.executeUpdate();
			if (rowsAffected == 1) onnistui = true ;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			Database.closeDBConnection(statementINS, connection);
		}
		
		return onnistui;
		
	}
	
	public void modifyPlayer(Player player) {
		
		Connection connection = null;  // tietokantayhteys
		PreparedStatement statement = null;  // sql-lause

		//muutetaan pelaajan tietoa, sama homma nimen kanssa
		
		try {
			connection = Database.getDBConnection();

			String sqlSelect =
					"UPDATE player SET driver1_id = ?, driver2_id = ?, team_id =? WHERE name=?;";
					
			
			statement = connection.prepareStatement(sqlSelect);
			
			statement.setInt(1, player.getDriver1().getStanding());
			statement.setInt(2, player.getDriver2().getStanding());
			statement.setInt(3, player.getTeam().getStanding());
			statement.setString(4, player.getName());
			
			statement.executeUpdate();
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			Database.closeDBConnection(statement, connection);
		}
		
		
		
	}

}
