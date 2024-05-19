/**
 * @author Daniela Darnea
 */
package modelo;

import java.sql.SQLException;

import dao.DaoTrip;

/**
 * Represents a Trip 
 */
public class Trip {
	private int id;
	private int userId;
	private int destinationsId;
	private String destName;
	private String username;
	
	/**
	 * Constructor to generate void object of type Trip
	 * */
	public Trip() {
		
	}
	
	/**
	 * Method to create object from frontend
	 * @param id of type integer
	 */
	public Trip(int id) {
		this.id = id;
	}
	
	/**
	 * Constructor for DB
	 * @param id
	 * @param userId
	 * @param destinationId
	 */
	public Trip(int id, int userId, int destinationsId, String destName, String username) {
		this.id = id;
		this.userId = userId;
		this.destinationsId = destinationsId;
		this.destName = destName;
		this.username = username;
	}
	
	public Trip(String destName, String username) {
		this.destName = destName;
		this.username = username;
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
	 *  Method to add userId to the object
	 * @return userId of type integer
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Method to set userId to the object
	 * @param userId of type integer
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Method to add destinationId to the object
	 * @return destinationId of type integer
	 */
	public int getDestinationsId() {
		return destinationsId;
	}

	/**
	 * Method to set destinationId to the object
	 * @param destinationId of type integer
	 */
	public void setDestinationId(int destinationsId) {
		this.destinationsId = destinationsId;
	}

	/**
	 * Method to add destination name to the object
	 * @return destName of type String
	 */
	public String getDestName() {
		return destName;
	}
	/**
	 * Method to set destName to the object
	 * @param destName of type String
	 */
	public void setDestName(String destName) {
		this.destName = destName;
	}
	/**
	 * Method to add username to the object
	 * @return username of type string
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * Method to set username to the object
	 * @param username of type string
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void buyTrip() throws ClassNotFoundException, SQLException {
		DaoTrip dao = new DaoTrip();
		dao.insertTrip(this);
	}
	
	public void deleteTrip(int id) throws ClassNotFoundException, SQLException {
		DaoTrip dao = new DaoTrip();
		dao.deleteTrip(id);
	}
	
	/**
	 * Method to override and print proper output
	 * @return A String representation of the object
	 */
	@Override
	public String toString() {
		return "Trip [id=" + id + ", userId=" + userId + ", destinationId=" + destinationsId + "]";
	}
	
	
}
