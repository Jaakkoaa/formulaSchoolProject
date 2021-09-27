package control;

import java.io.IOException;
import Database.*;
import model.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/standings")
public class StandigsServerlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//tietokannasta haetaan kuskien ja tiimien listat
		FormulaDao formuladao = new FormulaJdbcDao();
		ArrayList<Driver> drivers = formuladao.getDriverStandings();
		ArrayList<Team> teams = formuladao.getTeamStandings();
		
		
		request.setAttribute("drivers", drivers);
		request.setAttribute("teams", teams);
		
		request.getRequestDispatcher("/WEB-INF/standings.jsp").forward(request, response);
}
}