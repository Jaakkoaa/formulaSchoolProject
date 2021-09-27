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


@WebServlet("/modify")
public class ModifyServerlet extends HttpServlet{
	
	
	
	String name = "";
	

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		//haetaan pelaajan nimi, jota muokataan
		request.getRequestDispatcher("/WEB-INF/modify.jsp").forward(request, response);
		name = request.getParameter("name");
		}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//vaihdetaan tiedot ja lähetetään ne tietokantaan
		try {
			FormulaDao formuladao = new FormulaJdbcDao();
			ArrayList<Driver> drivers = formuladao.getDriverStandings();
			ArrayList<Team> teams = formuladao.getTeamStandings();
			
			String driver1Str = request.getParameter("driver1");
			int driver1 = Integer.parseInt(driver1Str);
			
			String driver2Str = request.getParameter("driver2");
			int driver2 = Integer.parseInt(driver2Str);
			
			String teamStr = request.getParameter("team");
			int team = Integer.parseInt(teamStr);
			
			
			//lasketaan valittujen pelaajien ja tiimien yhteinen hinta
			int price= teams.get(team -1 ).getPrice() + drivers.get(driver1 -1 ).getPrice() + drivers.get(driver2 -1 ).getPrice();
			if(price <= 200) {
				Player player = new Player(teams.get(team-1), drivers.get(driver1-1), drivers.get(driver2-1), name);
				System.out.println(player);
				
				formuladao.modifyPlayer(player);;
				response.sendRedirect("/listplayers");
				
				//Pelaaja ei voi valita ainoastaan parhaita kuskeja ja tiimejä, koska käytössä on vain 200e
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
