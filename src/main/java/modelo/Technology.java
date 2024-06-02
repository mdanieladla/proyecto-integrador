/**
 * @author Daniela Darnea
 */
package modelo;

import java.sql.SQLException;

import dao.DaoTechnology;

/**
 * Represents a technology
 */
public class Technology {
	private int id;
	private String name;
	private String imagePortraitUrl;
	private String imageLandscapeUrl;
	private String description;
	/**
	 * Constructor to generate void of type technology
	 */
	public Technology() {
		
	}
	
	/**
	 * Constructor for DB
	 * @param id of type integer
	 * @param name of type String
	 * @param imagePortraitUrl of type String
	 * @param imageLandscapeUrl of type String
	 * @param description of type String
	 */
	public Technology(int id, String name, String imagePortraitUrl, String imageLandscapeUrl, String description) {
		super();
		this.id = id;
		this.name = name;
		this.imagePortraitUrl = imagePortraitUrl;
		this.imageLandscapeUrl = imageLandscapeUrl;
		this.description = description;
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
	 * Method to add imagePortraitUrl to the object
	 * @return imagePortraitUrl of type string
	 */
	public String getImagePortraitUrl() {
		return imagePortraitUrl;
	}
	
	/**
	 * Method to set imagePortraitUrl 
	 * @param imagePortraitUrl of type string
	 */
	public void setImagePortraitUrl(String imagePortraitUrl) {
		this.imagePortraitUrl = imagePortraitUrl;
	}

	/**
	 * Method to add imageLandscapeUrl to the object
	 * @return imageLandscapeUrl of type string
	 */
	public String getImageLandscapeUrl() {
		return imageLandscapeUrl;
	}

	/**
	 * Method to set imageLandscapeUrl 
	 * @param imageLandscapeUrl of type string
	 */
	public void setImageLandscapeUrl(String imageLandscapeUrl) {
		this.imageLandscapeUrl = imageLandscapeUrl;
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
	 * Method to list technology data
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void list() throws ClassNotFoundException, SQLException {
		DaoTechnology dao = new DaoTechnology();
	}
	
	/**
	 * Method to override and print proper output
	 * @return A String representation of the object
	 */
	@Override
	public String toString() {
		return "Technology [id=" + id + ", name=" + name + ", imagePortraitUrl=" + imagePortraitUrl
				+ ", imageLandscapeUrl=" + imageLandscapeUrl + ", description=" + description + "]";
	}

}
