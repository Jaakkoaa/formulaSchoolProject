package model;

public class Driver {
	
	private int standing = 0;
	private String name ="";
	private int price = 0 ;
	
	public Driver(int standing, String name) {
		super();
		this.standing = standing;
		this.name = name;
		this.price = 100 - ((standing - 1) * 5);
	}

	public int getStanding() {
		return standing;
	}

	public void setStanding(int standing) {
		this.standing = standing;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Driver: standing=" + standing + ", name=" + name + ", price=" + price + "\n";
	}

}
