package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.FormulaDao;
import Database.FormulaJdbcDao;


@WebServlet("/delete-player")
public class DeletePlayer  extends HttpServlet{
	
	protected void doGet (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			//haetaan tieto siitä kuka halutaan poistaa. Pelaaja poistetaan nimen mukaan
			
			String nameStr = request.getParameter("name");
			
			
			FormulaDao formuladao = new FormulaJdbcDao();
			
			boolean delete = formuladao.removePlayer(nameStr);
			
			//jos poisto onnistuu mennään takaisin pelaajanäkymään, muuten virheraportti
			
			if (delete) {
				response.sendRedirect("/listplayers");
				
			} else {
				request.setAttribute("viesti", "pelaajan poistossa tapahtui virhe.");
				
				request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();	
			request.setAttribute("viesti", "Sovelluksessa tapahtui virhe,");
			
			request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
			
		} 
		
		
	}

}