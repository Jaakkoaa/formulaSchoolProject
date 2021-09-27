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



@WebServlet("/listplayers")
public class ListPlayersTestServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		FormulaDao formuladao = new FormulaJdbcDao();
		ArrayList<Player> players = formuladao.getPlayers();
		
		request.setAttribute("players", players);
		request.getRequestDispatcher("/WEB-INF/listPlayers.jsp").forward(request, response);
}
}