package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.FormulaDao;
import Database.FormulaJdbcDao;
import model.Driver;
import model.Player;
import model.Standings;
import model.Team;
@WebServlet("/results")
public class Results extends HttpServlet{
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		
		request.getRequestDispatcher("/WEB-INF/insertnewstandings.jsp").forward(request, response);
		}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//pelaajat haetaan tietokannasta

	FormulaDao formuladao = new FormulaJdbcDao();
	
	ArrayList<Player> players = formuladao.getPlayers();

	ArrayList<Team> teams = new ArrayList<Team>();
	ArrayList<Driver> drivers = new ArrayList<Driver>();
	String text = "";
	
	//uudet tiimien ja kuskien listat luodaan
	for (int i = 0; i <10; i++) {
		String teamStr = request.getParameter("team"+(i+1));
		System.out.println(teamStr);
		Team team = new Team(i+1, teamStr);
		teams.add(team);
	}
	
	

	for (int i = 0; i <20 ; i++) {
		String driverStr = request.getParameter("driver"+(i+1));
		System.out.println(driverStr);
		Driver driver = new Driver(i+1, driverStr);
		drivers.add(driver);
	}
	
	//pelaajien valitsemat tiimit ja kuskit käydään läpi uusista listoista
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
		
		//lasketaan onko pelaaja tehnyt voittoa vai tappiota
		
		int lastYearEur = driver1.getPrice() + driver2.getPrice() + team.getPrice();
		int thisYearEur = driverThisYear1.getPrice() + driverThisYear2.getPrice() + teamThisYear.getPrice();
		
		int result =  thisYearEur - lastYearEur;
		text = text + player.getName() + ": " + result + "\n";
		System.out.println(player.getName() + ": " + result);
		
	
	
	}
	request.setAttribute("viesti", text);
	request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
}}
