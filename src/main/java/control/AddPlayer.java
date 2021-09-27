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
import model.Team;

@WebServlet("/addplayers")
public class AddPlayer extends HttpServlet{
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		
		request.getRequestDispatcher("/WEB-INF/addplayer.jsp").forward(request, response);
		
		}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			//haeteaan tieto JSP:stä
			String name = request.getParameter("name");
			
			String driver1Str = request.getParameter("driver1");
			int driver1 = Integer.parseInt(driver1Str);
			
			String driver2Str = request.getParameter("driver2");
			int driver2 = Integer.parseInt(driver2Str);
			
			String teamStr = request.getParameter("team");
			int team = Integer.parseInt(teamStr);
			
			//viedään ne tiedot tietokantaan 
			
			FormulaDao formuladao = new FormulaJdbcDao();
			ArrayList<Driver> drivers = formuladao.getDriverStandings();
			ArrayList<Team> teams = formuladao.getTeamStandings();
			
			int price= teams.get(team -1 ).getPrice() + drivers.get(driver1 -1 ).getPrice() + drivers.get(driver2 -1 ).getPrice();
			
			if(price <= 200) {
			Player player = new Player(teams.get(team-1), drivers.get(driver1-1), drivers.get(driver2-1), name);
			System.out.println(player);
			
			formuladao.insertToPlayers(player);
			response.sendRedirect("/listplayers");
			}else {
				request.setAttribute("viesti", "you only have 200 euros to use. Try again.");
				request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
			}
			
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
			request.setAttribute("viesti", "Sovelluksessa tapahtui virhe,");
			request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
			
		}
		
		
		}
	
	
}
