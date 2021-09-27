package model;

import java.util.ArrayList;

public class Standings {

	private ArrayList<Driver> drivers = null;
	private ArrayList<Team> teams = null;
	
	
	public Standings(ArrayList<Driver> drivers, ArrayList<Team> teams) {
		super();
		this.drivers = drivers;
		this.teams = teams;
	}

	public ArrayList<Driver> getDrivers() {
		return drivers;
	}
	
	public void setDrivers(ArrayList<Driver> drivers) {
		this.drivers = drivers;
	}
	public ArrayList<Team> getTeams() {
		return teams;
	}
	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}

	@Override
	public String toString() {
		return "Standings drivers= \n" + drivers + "] \n , teams= \n [" + teams + "]";
	}
	
	
	
	
	
	
}
