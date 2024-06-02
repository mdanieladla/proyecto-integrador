/**
 * @author Daniela Darnea
 */
package modelo;

import java.sql.SQLException;

import dao.DaoCrew;

/**
 * Represents a Crew (member)
 */
public class Crew {
	private int id;
	private String name;
	private String imageUrl;
	private String role;
	private String bio;
	
	/**
	 * Constructor to generate void of type crew
	 */
	public Crew() {
		
	}
	
	/**
	 * Constructor for DB
	 * @param id of type Integer
	 * @param name of type String
	 * @param imageUrl of type String
	 * @param role of type String
	 * @param bio of type String
	 */
	public Crew(int id, String name, String imageUrl, String role, String bio) {
		super();
		this.id = id;
		this.name = name;
		this.imageUrl = imageUrl;
		this.role = role;
		this.bio = bio;
	}

	/**
	 * Method to add id to the object
	 * @return id of type Integer
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
	 * Method to add role to the object
	 * @return role of type string
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Method to set role
	 * @param role of type string
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * Method to add bio to the object
	 * @return bio of type string
	 */
	public String getBio() {
		return bio;
	}

	/**
	 * Method to set bio
	 * @param bio of type string
	 */
	public void setBio(String bio) {
		this.bio = bio;
	}

	/**
	 * Method to list crew data
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void list() throws ClassNotFoundException, SQLException {
		DaoCrew dao = new DaoCrew();
	}
	
	/**
	 * Method to override and print proper output
	 * @return A String representation of the object
	 */
	@Override
	public String toString() {
		return "Crew [id=" + id + ", name=" + name + ", imageUrl=" + imageUrl + ", role=" + role + ", bio=" + bio + "]";
	}
	
	
	
}
