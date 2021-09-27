package program;

import Database.FormulaJdbcDao;
import Database.FormulaDao;
import model.Team;
import model.Driver;
import model.Standings;

import java.util.ArrayList;
import java.util.Scanner; 

public class Testitesti {

	public static void main(String[] args) {
		
		
		
		FormulaDao league = new FormulaJdbcDao();
		

		//league.createSeasonDriverTable();
		//league.createSeasonTeamTable();
		//league.createSeasonPlayerTable();
		
		
		Standings standing = new Standings(league.getDriverStandings(), league.getTeamStandings());
		
		System.out.println(standing);
		
		 }
		 
		

	}


