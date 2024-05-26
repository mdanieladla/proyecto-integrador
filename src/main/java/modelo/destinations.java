package modelo;

import java.sql.SQLException;
import dao.daoDestinations;

/**
 * Represents a destination
 */
public class destinations {
	
	private int id;
	private String name;
	private String imageUrl;
	private String description;
	private String distance;
	private String travel;

	/**
	 * Constructor to generate void of type destination
	 */
	public destinations() {
		
	}
	
	/**
	 * Constructor for DB
	 * @param id of type integer
	 * @param name of type string
	 * @param imageUrl of type string
	 * @param description of type string
	 * @param distance of type string
	 * @param travel of type string
	 */
	public destinations(int id, String name, String imageUrl, String description, String distance, String travel) {
		super();
		this.id = id;
		this.name = name;
		this.imageUrl = imageUrl;
		this.description = description;
		this.distance = distance;
		this.travel = travel;
	}
	
	/**
	 * Method to add id to the object
	 * @return id of type integer
	 */
	public int getId() {
		return id;
	}

	/**
	 * Method to set id to the object
	 * @param id of type integer
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Method to add name to the object
	 * @return name of type string
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method to set name to the object
	 * @param name of type string
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method to add imageUrl to the object
	 * @return imageUrl of type string
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * Method to set imageUrl 
	 * @param imageUrl of type string
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * Method to add description to the object
	 * @return description of type string
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Method to set description to object
	 * @param description of type string
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Method to add distance to the object
	 * @return distance of type string
	 */
	public String getDistance() {
		return distance;
	}

	/**
	 * Method to set distance to object
	 * @param distance of type string
	 */
	public void setDistance(String distance) {
		this.distance = distance;
	}

	/**
	 * Method to add travel to the object
	 * @return travel of type string
	 */
	public String getTravel() {
		return travel;
	}

	/**
	 * Method to set travel to object
	 * @param travel of type string
	 */
	public void setTravel(String travel) {
		this.travel = travel;
	}

	/**
	 * Method to list destinations
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void list() throws SQLException, ClassNotFoundException {
		daoDestinations dao = new daoDestinations();
		
	}
	
	/**
	 * Method to override and print proper output
	 * @return A String representation of the object
	 */
	@Override
	public String toString() {
		return "Destinations [id=" + id + ", name=" + name + ", imageUrl=" + imageUrl + ", description=" + description
				+ ", distance=" + distance + ", travel=" + travel + "]";
	}

}
