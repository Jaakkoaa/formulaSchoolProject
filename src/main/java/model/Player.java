package model;

public class Player {
	
	private Team team = null;
	private Driver driver1 = null;
	private Driver driver2 = null;
	private String name = "";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Driver getDriver1() {
		return driver1;
	}

	public void setDriver1(Driver driver1) {
		this.driver1 = driver1;
	}

	public Driver getDriver2() {
		return driver2;
	}

	public void setDriver2(Driver driver2) {
		this.driver2 = driver2;
	}

	public Player(Team team, Driver driver1, Driver driver2, String name) {
		super();
		this.team = team;
		this.driver1 = driver1;
		this.driver2 = driver2;
		this.name = name;
	}

	@Override
	public String toString() {
		return name +": [team=" + team + ", driver1=" + driver1 + ", driver2=" + driver2 + "]";
	}
	
	
	

}
