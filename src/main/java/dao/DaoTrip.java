/**
 * @author Daniela Darnea
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Trip;

public class DaoTrip {
	public static Connection con = null;
	
	/**
	 * Method to get connection to DB
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public DaoTrip() throws ClassNotFoundException, SQLException {
		this.con = dbConnection.getConnection();
	}
	
	/**
	 * Method to insert trip to DB
	 * @param trip of type Trip
	 * @throws SQLException
	 */
	public void insertTrip(Trip trip) throws SQLException {
		String sql = "INSERT INTO destinationsusers (destinationsId, userId) VALUES (?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, trip.getDestinationsId());
		ps.setInt(2, trip.getUserId());
		
		ps.executeUpdate();
		
		ps.close();
	}
	
	/**
	 * Method to get by user id a trip
	 * @param userId of type Int
	 * @return trip of type Trip
	 * @throws SQLException
	 */
	public Trip getById(int userId) throws SQLException {
		String sql = "SELECT * FROM destinationsusers WHERE userId=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, userId);
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		
		Trip trip = new Trip(rs.getInt(1), rs.getInt(2), rs.getInt(3));
		
		return trip;
	}
	
	/**
	 * Method to list trips
	 * @return listTrips of type ArrayList of Trip
	 * @throws SQLException
	 */
	public ArrayList<Trip> listTrips() throws SQLException {
		String sql = "SELECT * FROM destinationsusers";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Trip> listTrips = null;
		
		while (rs.next()) {
			if (listTrips == null) {
				listTrips = new ArrayList<Trip>();
			}
			listTrips.add(new Trip(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
		}
		return listTrips;
	}
	
	/**
	 * Method to delete Trip
	 * @param id of type id
	 * @throws SQLException
	 */
	public void deleteTrip(int id) throws SQLException {
		String sql = "DELETE FROM destinationsusers WHERE id=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		int filas = ps.executeUpdate();
		ps.close();
	}
	
	/**
	 * Method to list data as JSON
	 * @return json
	 * @throws SQLException
	 */
	public String listJson() throws SQLException {
		
		String json = "";
		Gson gson = new Gson();
		
		json = gson.toJson(this.listTrips());
		
		return json;
	}
	
	/**
	 * Method to list by id trips in JSON format
	 * @param userId of type id
	 * @return json
	 * @throws SQLException
	 */
	public String listByIdJson(int userId) throws SQLException {
		String json = "";
		Gson gson = new Gson();
		
		json = gson.toJson(this.getById(userId));
		
		return json;
	}
}
