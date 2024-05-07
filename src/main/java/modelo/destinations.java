package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import dao.dbConnection;
import dao.daoDestinations;

public class Destinations {
	
	private int id;
	private String name;
	private String imageUrl;
	private String description;
	private String distance;
	private String travel;

	public Destinations() {
		
	}
	
	public Destinations(int id, String name, String imageUrl, String description, String distance, String travel) {
		super();
		this.id = id;
		this.name = name;
		this.imageUrl = imageUrl;
		this.description = description;
		this.distance = distance;
		this.travel = travel;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getTravel() {
		return travel;
	}

	public void setTravel(String travel) {
		this.travel = travel;
	}

	public void list() throws SQLException, ClassNotFoundException {
		daoDestinations dao = new daoDestinations();
		
	}
	
	@Override
	public String toString() {
		return "Destinations [id=" + id + ", name=" + name + ", imageUrl=" + imageUrl + ", description=" + description
				+ ", distance=" + distance + ", travel=" + travel + "]";
	}
	
	
}
