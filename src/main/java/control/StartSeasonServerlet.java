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

@WebServlet("/startseason")
public class StartSeasonServerlet extends HttpServlet{
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		
		request.getRequestDispatcher("/WEB-INF/insertnewstandings.jsp").forward(request, response);
		}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			FormulaDao formuladao = new FormulaJdbcDao();
			
			//luodaan tiimien ja kuskien listat parhausjärjestyksessä
			ArrayList<Team> teams = new ArrayList<Team>();
			ArrayList<Driver> drivers = new ArrayList<Driver>();
			
			
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
			
			//poistetaan mahdollinen vanha tietokanta ja luodaan uusi
			Standings standings = new Standings(drivers, teams);
			
			formuladao.deleteDatabase();
			formuladao.createSeasonDriverTable();
			formuladao.createSeasonTeamTable();
			formuladao.createSeasonPlayerTable();
			
			formuladao.insertToDrivers(standings);
			formuladao.insertToTeams(standings);
			
			
			response.sendRedirect("/standings");
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("viesti", "Sovelluksessa tapahtui virhe,");
			request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
		}
		}
	
	
}
