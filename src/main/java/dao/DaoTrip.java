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
	
	public DaoTrip() throws ClassNotFoundException, SQLException {
		this.con = dbConnection.getConnection();
	}
	
	public void insertTrip(Trip trip) throws SQLException {
		String sql = "INSERT INTO destinationsusers (destinationsId, userId) VALUES (?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, trip.getDestinationsId());
		ps.setInt(2, trip.getUserId());
		
		ps.executeUpdate();
		
		ps.close();
	}
	
	public Trip getById(int userId) throws SQLException {
		String sql = "SELECT * FROM destinationsusers WHERE userId=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, userId);
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		
		Trip trip = new Trip(rs.getInt(1), rs.getInt(2), rs.getInt(3));
		
		return trip;
	}
	
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
	
	public void deleteTrip(int id) throws SQLException {
		String sql = "DELETE FROM destinationsusers WHERE id=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		int filas = ps.executeUpdate();
		ps.close();
	}
	
	public String listJson() throws SQLException {
		
		String json = "";
		Gson gson = new Gson();
		
		json = gson.toJson(this.listTrips());
		
		return json;
	}
	
	public String listByIdJson(int userId) throws SQLException {
		String json = "";
		Gson gson = new Gson();
		
		json = gson.toJson(this.getById(userId));
		
		return json;
	}
}
