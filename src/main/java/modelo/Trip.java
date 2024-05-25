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
	private int destinationsId;
	private int userId;
	
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
	public Trip(int id, int destinationsId, int userId) {
		this.id = id;
		this.destinationsId = destinationsId;
		this.userId = userId;
	}
	
	public Trip(int destinationsId, int userId) {
		this.destinationsId = destinationsId;
		this.userId = userId;
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
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void insertTrip() throws ClassNotFoundException, SQLException {
		DaoTrip dao = new DaoTrip();
		dao.insertTrip(this);
	}
	
	public void getById(int id) throws ClassNotFoundException, SQLException {
		DaoTrip dao = new DaoTrip();
		Trip trip = dao.getById(id);
		
		this.setId(trip.getId());
		this.setDestinationId(trip.getDestinationsId());
		this.setUserId(trip.getUserId());
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
