package program;


import java.util.ArrayList;
import java.util.Scanner;
import Database.FormulaDao;
import Database.FormulaJdbcDao;
import model.Team;
import model.Driver;
import model.Player;
import model.Standings;

public class StartLeague {
	
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int input = 1; 
		Standings lastYearStand = null;
		ArrayList<Player> players = null;
		
		
	
		
		try {
			lastYearStand = lastyearSeasonDp();
			players = showPlayers();
			
		while (input != 0) {
			System.out.println("\n");
			System.out.println("1  Start your season");
			System.out.println("2  Add a player");
			System.out.println("3  See results");
			System.out.println("4  See last years standings");
			System.out.println("5  See players");
			System.out.println("0  stop");
			
			input = sca.nextInt();
			
			
			switch (input) {
			
			
			
			case 1:
				deleteDatabase();
				startSeason();
			
				
				lastYearStand = lastyearSeasonDp();
				break;
			case 2:
				
				if (lastYearStand !=null) {
				makePlayer(lastYearStand);
				players = showPlayers();
				} else {
					System.out.println("start your season first");
				}
				
				break;
			case 3:
				
				
				if (lastYearStand !=null) {
					results(players);} else {
						System.out.println("start your season first");
					}	
					
				break;
				
			case 4:
				if (lastYearStand !=null) {
					System.out.println(lastYearStand);} else {
						System.out.println("start your season first");
					}
				
				break;
			case 5: 
				
					if (players != null) {
						
						System.out.println(players);
					}
				break;
			case 0:
				System.out.println("see you next time!");
				break;
			default :
				System.out.println("not a possible input");
				break;
				
			} 
			}
		}catch (Exception e) {System.out.println(e);}
	}

	
	
	public static Standings startSeason() {
		
		Scanner sca = new Scanner(System.in);
		FormulaDao season = new FormulaJdbcDao();
		
		
		
		System.out.println("write the formula teams in last years standings order starting from 1");
		
		ArrayList<Team> teams = makeTeamStandings();
		
		
		System.out.println("write the formula drivers in last years standings order starting from 1");
		ArrayList<Driver> drivers = makeDriverStandings();
		
		Standings stand = new Standings(drivers, teams);
		
		
		System.out.println("you have started your season");
		
		
		
		season.createSeasonDriverTable();
		season.createSeasonTeamTable();
		season.createSeasonPlayerTable();
		
		season.insertToDrivers(stand);
		season.insertToTeams(stand);
		
		return stand;
	}
	
	
	
	
	public static ArrayList<Team> makeTeamStandings() {
		Scanner sca = new Scanner(System.in);
		ArrayList<Team> teams = new ArrayList<Team>();
		
		
		for (int i = 1; i < 11; i++) {
			Team team = new Team(i, sca.next());
			teams.add(team);
			
		}
		
		System.out.println(teams);
		return teams;
	}
	
	
	
	
	public static ArrayList<Driver> makeDriverStandings() {
		
		Scanner sca = new Scanner(System.in);
		ArrayList<Driver> drivers = new ArrayList<Driver>();
		
		
		for (int i = 1; i < 21; i++) {
			Driver driver= new Driver(i, sca.next());
			drivers.add(driver);
			
		}
		
		System.out.println(drivers);
		return drivers;
	}
	
	
	
	
	public static Player makePlayer(Standings stand) {
		
		FormulaDao league = new FormulaJdbcDao();
		
		Scanner sca = new Scanner(System.in);
		ArrayList<Team> teams = stand.getTeams();
		ArrayList<Driver> drivers = stand.getDrivers();
		
		System.out.println("give your name");
		String name = sca.next();
		
		//pelaajalle tiimi ja kaksi kuskia, jos raha menee alle 0, joutuu valita uudestaan. 
		
		
		int money = 200;
		int firstDriverNumber = 0;
		int secondDriverNumber = 0;
		int teamNumber = 0;
		boolean hasMoney = false;
		while (!hasMoney) {
		
		System.out.println("you have 200 euros");
		while (firstDriverNumber >20 || firstDriverNumber < 1) {
		System.out.println("select a driver by pressing the standing number");
		firstDriverNumber = sca.nextInt() ;
		}
		money = money - drivers.get(firstDriverNumber-1).getPrice();
		
		System.out.println("you have " + money + " euros");
		
		while (secondDriverNumber > 20 || secondDriverNumber < 1) {
		System.out.println("select a driver by pressing the standing number");
		secondDriverNumber = sca.nextInt() ;
		}
		money = money - drivers.get(secondDriverNumber-1).getPrice();
		
		System.out.println("you have " + money + " euros");
		while (teamNumber > 10 || teamNumber < 1) {
		System.out.println("select a Team by pressing the standing number");
		teamNumber = sca.nextInt() ;
		}
		money = money - teams.get(teamNumber-1).getPrice();
		
		
		
		if (money > -1) {hasMoney = true;}else {
			 money = 200;
			 firstDriverNumber = 0;
			 secondDriverNumber = 0;
			 teamNumber = 0;
		}
			
		
		
		}
		
		
		
		Player player = new Player(teams.get(teamNumber-1), drivers.get(firstDriverNumber-1), drivers.get(secondDriverNumber-1), name);
		System.out.println("you have added player "+ name);
	
		league.insertToPlayers(player);
		return player;
		
	}
	
	public static void results(ArrayList<Player> players) {
		
		
		System.out.println("write the formula drivers in this years standings order starting from 1");
		ArrayList<Driver> drivers = makeDriverStandings();
		
		System.out.println("write the formula teams in this years standings order starting from 1");
		ArrayList<Team> teams = makeTeamStandings();
		
	
		for (Player player : players) {
			
			Driver driver1 = player.getDriver1();
			Driver driverThisYear1 = null;
			
			Driver driver2 = player.getDriver2();
			Driver driverThisYear2 = null;
			
			Team team = player.getTeam();
			Team teamThisYear = null;
			
			
			
			for(int i = 0; i <20 ; i ++) {
				
				if (driver1.getName().equalsIgnoreCase(drivers.get(i).getName())) {
					
					driverThisYear1 = drivers.get(i);
					break;
				}
				
			}
			
			
			for(int i = 0; i <20 ; i ++) {
				
				if (driver2.getName().equalsIgnoreCase(drivers.get(i).getName())) {
					
					driverThisYear2 = drivers.get(i);
					break;
				}
				
			}
			
			for(int i = 0; i < 10; i++) {
				
				if (team.getName().equalsIgnoreCase(teams.get(i).getName())) {
					
					teamThisYear = teams.get(i);
					
				}
			}
			
			
			int lastYearEur = driver1.getPrice() + driver2.getPrice() + team.getPrice();
			int thisYearEur = driverThisYear1.getPrice() + driverThisYear2.getPrice() + teamThisYear.getPrice();
			
			int result =  thisYearEur - lastYearEur;
			
			System.out.println(player.getName() + ": " + result);
			
			
		}
		
		
		
		
		
	}
	
	public static Standings lastyearSeasonDp() {
		
		FormulaDao league = new FormulaJdbcDao();
		Standings standing = new Standings(league.getDriverStandings(), league.getTeamStandings());
		
		return standing;
	}
	
	public static void deleteDatabase() {
		FormulaDao league = new FormulaJdbcDao();
		league.deleteDatabase();
	}
	

	public static ArrayList showPlayers() {
		FormulaDao league = new FormulaJdbcDao();
		ArrayList<Player> players = league.getPlayers();
		return players;
		
	}
	
}
